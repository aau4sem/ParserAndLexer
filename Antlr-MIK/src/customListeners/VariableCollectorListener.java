package customListeners;

import exceptions.GrammarHasChangedException;
import gen.Tactic;
import gen.TacticBaseListener;
import model.Procedure;
import model.dataTypes.Array;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;
import model.utils.ArgumentGatherer;
import model.utils.ArithmeticGatherer;
import model.utils.Parameter;
import model.utils.TypeCheckerHelper;
import model.variables.ProcedureScopeData;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** This class will collect and handle variables during parsing.
 * The idea is that during the pass, this class will contain a
 * model with the current state of variables, and other classes
 * and listeners will request this class for information regarding
 * variables. */
public class VariableCollectorListener extends TacticBaseListener {

    public enum ScopeType {MAIN_SCOPE, PROCEDURE_SCOPE }

    private ActionCollectorListener acl;
    private BoardListener bl;

    //Two variableScopeData to keep track of variable declarations in the main and function scope
    private VariableScopeData mainScope = new VariableScopeData();
    private ProcedureScopeData procedureScope = new ProcedureScopeData(mainScope);

    //Keeps track of which scope the parsing/tree walk currently is in
    private ScopeType currentScope = ScopeType.MAIN_SCOPE;

    //Collection for declared procedures
    private HashMap<String, Procedure> procedures = new HashMap<>();

    //All supported variable types
    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}

    public boolean isInProcedureDefinition = false;
    public boolean isTraversingWhileStmt = false;

    private boolean isWalkingConditional = false;
    private boolean isInIfBlock = false;
    private boolean isInElseBlock = false;
    public boolean mayRunIfBlock = false;
    public boolean mayRunElseBlocK = false;

    // CORE METHODS -----------------------------------------------------------

    /** Used to add variables to the current scope.
     * @param varCon variable container, containing the value and information of the variable. */
    public void addVariableToScope(VariableContainer varCon){
        mainScope.addVariable(varCon);
    }

    /** Used to overwrite a value of a variables.
     * @param val the new value that will be used to overwrite the old one.
     * @param identifier the identifier of the variable to overwrite. */
    public void overwriteValueOfVariable(String identifier, String val){

        if(currentScope == ScopeType.PROCEDURE_SCOPE){
            VariableContainer varCon = procedureScope.getVariable(identifier);

            if(varCon != null){
                procedureScope.overwriteValueOfVariable(identifier, val);
                return;
            }
        }

        VariableContainer varCon = mainScope.getVariable(identifier);

        if(varCon == null){
            throw new IllegalArgumentException(); //Variable has not been declared
        }

        mainScope.overwriteValueOfVariable(identifier, val);
    }

    /** Used to get variables from the current scope. If the current scope
     * is procedure scope, and ff the variable is not found in the function
     * scope, it will then search the main scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    public VariableContainer getValueFromScope(String identifier){

        VariableContainer varCon;

        //Get VariableContainer from the current scope
        if(currentScope == ScopeType.MAIN_SCOPE){
            varCon = mainScope.getVariable(identifier);
        } else {
            varCon = procedureScope.getVariable(identifier);
            if(varCon == null)
                varCon = mainScope.getVariable(identifier);
        }

        if(varCon.isArray()){
            System.out.println("The requested variable is of the type array. Use other method for this.");
            throw new IllegalArgumentException();
        }

        return varCon;
    }

    /** Used to get variables from the current scope. If the current scope
     * is procedure scope, and ff the variable is not found in the function
     * scope, it will then search the main scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    public VariableContainer getArrayValueFromScope(String identifier){

        VariableContainer varCon;

        //Get VariableContainer from the current scope
        if(currentScope == ScopeType.MAIN_SCOPE){
            varCon = mainScope.getVariable(identifier);
        } else {
            varCon = procedureScope.getVariable(identifier);
            if(varCon == null)
                varCon = mainScope.getVariable(identifier);
        }

        if(varCon != null)
            if(!varCon.isArray())
                return null;

        return varCon;
    }

    /** Used to get a value from an identifier. */
    public VariableContainer getValueFromIdentifier(String identifier){
        return getValueFromScope(identifier);
    }

    /** @return true if the given identifier is found in the current scope or an above scope. */
    private boolean hasBeenInitialized(String identifier){
        return getValueFromScope(identifier) != null;
    }

    /** Used to check if an identifier is declared, assigned and has the correct type.
     * Will throw an exceptions of any of the three cases does not pass.
     * @param identifier the identifier for the value to check.
     * @param requestedType the type the value should have.
     * @return a variableContainer holding the value matching the given identifier. */
    public VariableContainer identifierToValueCheck(String identifier, VariableCollectorListener.VariableType requestedType){

        VariableContainer varCon = getValueFromScope(identifier);

        if(varCon == null){
            System.out.println("The requested variable has not been declared.");
            throw new IllegalArgumentException();
        }

        if(varCon.getValue() == null){
            System.out.println("The requested variable has been declared but not assigned.");
            throw new IllegalArgumentException();
        }

        if(varCon.getType() != requestedType){
            System.out.println("The requested variable does exist, is assigned, but is not of the right type."); //TODO This should never happen: we check the value before assigning it.
            throw new IllegalArgumentException();
        }

        return varCon;
    }

    /** @return the procedure matching the given identifier. */
    private Procedure getProcedureFromIdentifier(String identifier){

        Procedure procedure = procedures.get(identifier);

        if(procedure == null)
            throw new IllegalArgumentException(); //The procedure being called does not exist

        return procedure;
    }

    // UTILITIES -----------------------------------------------------------------

    /** @return all GamePieces instantiated. */
    public ArrayList<GamePiece> getAllGamePieces(){

        ArrayList<GamePiece> allGamePieces = new ArrayList<>();

        for( VariableContainer varCon : mainScope.getAllVariablesOfType(VariableCollectorListener.VariableType.GAMEPIECE))
            allGamePieces.add(TypeCheckerHelper.parseGamePiece(varCon.getValue()));

        return allGamePieces;
    }

    /** Used in overwrites of stmt's, to check if a stmt is allowed to run on the current place in the tree-walk. */
    public boolean mayThisStmtRun(){

        if(isInProcedureDefinition)
            return false;

        if(isWalkingConditional){

            if(isInElseBlock && !mayRunElseBlocK)
                return false;

            if(isInIfBlock && !mayRunIfBlock)
                return false;
        }


        return true;
    }

    // OVERWRITES ----------------------------------------------------

    @Override
    public void exitAssignment(Tactic.AssignmentContext ctx) {

        if(!mayThisStmtRun())
            return;

        if(isTraversingWhileStmt)
            return;

        //Do check for board path assignment
        if(ctx.identifier().getText().compareTo(BoardListener.boardKeyword) == 0)
            return;

        String identifier = ctx.identifier().getText();

        //Check the identifier on the left side of the assignment
        VariableContainer varConToOverwrite = getValueFromIdentifier(identifier);

        if(varConToOverwrite == null){
            System.out.println("The variable to overwrite has not been declared!");
            throw new IllegalArgumentException();
        }

        String value = getValueOfRightSideAssignment(ctx.assignmentRight(), varConToOverwrite.getType());

        overwriteValueOfVariable(identifier, value);
    }

    private String getValueOfRightSideAssignment(Tactic.AssignmentRightContext ctx, VariableType desiredType){

        String value;

        if(ctx.value() != null){ //format: identifier = value

            //Get value
            Tactic.ValueContext valueContext = ctx.value(); //format: identifier | number | bool | string | vec;
            if (valueContext.identifier() != null){ //format: identifier

                VariableContainer varConRight = getValueFromIdentifier(valueContext.identifier().getText());

                if(varConRight == null){
                    System.out.println("The identifier on the right side of equals is not found.");
                    throw new IllegalArgumentException();
                }

                //Type checking for assignment
                if(desiredType == varConRight.getType()){
                    value = varConRight.getValue();
                } else if(desiredType == VariableType.INT && varConRight.getType() == VariableType.FLOAT){
                    //throw new IllegalArgumentException(); //Trying to assign an float to an int
                    value = String.valueOf(TypeCheckerHelper.trimFloatToInt(varConRight.getValue())); //Cast value from float to int
                } else if(desiredType == VariableType.FLOAT && varConRight.getType() == VariableType.INT){
                    value = varConRight.getValue(); //Casting int to float
                } else{
                    System.out.println("The value in the right side of the assignment is wrong.");
                    throw new IllegalArgumentException();
                }
            }else if(valueContext.number() != null){ //format: number

                if(desiredType != VariableType.INT && desiredType != VariableType.FLOAT)
                    throw new IllegalArgumentException();

                Number num = TypeCheckerHelper.parseNumber(valueContext.number().getText());
                if(desiredType == VariableType.INT){
                    if(num.getIntValue() == null){
                        throw new IllegalArgumentException(); //Trying to assign a float value to an int
                    }
                    value = String.valueOf(num.getIntValue());
                }else if (desiredType == VariableType.FLOAT){
                    if(num.getIntValue() != null)
                        value = String.valueOf(num.getIntValue());
                    else if(num.getFloatValue() != null)
                        value = String.valueOf(num.getFloatValue());
                    else
                        throw new IllegalArgumentException(); //This is not possible!
                }else
                    throw new IllegalArgumentException(); //This is not possible!
            }else if(valueContext.bool() != null){ //format: bool
                if(desiredType != VariableType.BOOL)
                    throw new IllegalArgumentException();
                value = String.valueOf(TypeCheckerHelper.parseBool(valueContext.bool().getText()));
            }else if(valueContext.string() != null){ //format: string
                if(desiredType != VariableType.STRING)
                    throw new IllegalArgumentException();
                value = TypeCheckerHelper.parseString(valueContext.string().getText());
            } else if(valueContext.vec() != null){ //format: vec
                if(desiredType != VariableType.VEC)
                    throw new IllegalArgumentException();
                Vector vec = getVector(valueContext.vec());
                value = vec.toString();
            }else
                throw new GrammarHasChangedException("AssignmentRightContext");

        } else if(ctx.arithExpr() != null){ //format identifier = arithExpr

            //TODO VECTOR ARITHMETIC CHECK!!
            //TODO is one of the arguments in the arithExpr an vector?
            boolean doesArithExprContainVec = doesArithExprContainVector(ctx.arithExpr());

            if(doesArithExprContainVec){
                boolean isValidVectorExpr = isArithExprAValidVectorExpr(ctx.arithExpr());

                //TODO If yes.. get vector arithmetic result
                if(isValidVectorExpr){

                    //format: (x,x,x)+(x,x,x) or (x,x,x)-(x,x,x)
                    StringBuilder firstVecString = new StringBuilder();
                    StringBuilder secondVecString = new StringBuilder();
                    String operator = null;

                    ArithmeticGatherer ag = (ArithmeticGatherer)ctx.arithExpr().children.get(0).getChild(ctx.arithExpr().children.get(0).getChildCount() -1);
                    String equation = ag.getEquation();

                    int parenthesesCounter = 0;

                    for(char c : equation.toCharArray()){

                        if(c == '(' || c == ')'){
                            if(parenthesesCounter == 0 || parenthesesCounter == 1)
                                firstVecString.append(c);
                            else if(parenthesesCounter == 2 || parenthesesCounter == 3)
                                secondVecString.append(c);

                            parenthesesCounter++;
                        }
                        else if(parenthesesCounter == 1)
                            firstVecString.append(c);
                        else if(parenthesesCounter == 2)
                            operator = String.valueOf(c);
                        else if(parenthesesCounter == 3)
                            secondVecString.append(c);

                    }

                    Vector firstVec = TypeCheckerHelper.parseVector(firstVecString.toString());
                    Vector secondVec = TypeCheckerHelper.parseVector(secondVecString.toString());

                    value = getResultOfVectorOperation(firstVec, secondVec, operator).toString();

                }else{
                    System.out.println("In the assignment, one of the identifiers resolves to a vector but the equation is not a valid vector equation.");
                    throw new IllegalArgumentException();
                }
            }else{
                String result = String.valueOf(getArithmeticResult(ctx.arithExpr()));
                value = String.valueOf(TypeCheckerHelper.trimFloatToInt(result)); //If the type the result is saved in, is of type integer, decimals will be cut off
            }
        } else if(ctx.boolExpr() != null){ //format identifier = boolStmt //TODO Change in grammar has made this invalid, Mathias is working on solution
            value = String.valueOf(getBoolStmtResult(ctx.boolExpr())); //TODO Change in grammar has made this invalid, Mathias is working on solution
        } else if(ctx.vecExpr() != null){ //format identifier = vecExpr (subtraction or addition)
            value = getResultOfVectorArithmetic(ctx.vecExpr()).toString();
        } else if(ctx.identifier() != null) { //format identifier = identifier LBRACKET integer RBRACKET

            VariableContainer varCon = getArrayValueFromScope(ctx.identifier().getText());

            if(varCon == null){
                System.out.println("The requested array does not exist.");
                throw new IllegalArgumentException();
            }

            if(varCon.getType() != desiredType){
                System.out.println("The array is not of the requested type.");
                throw new IllegalArgumentException();
            }

            int index = Integer.parseInt(ctx.integer().getText());

            if(index >= varCon.getLengthOfArray()){
                System.out.println("The index addressing the array is larger than the array.");
                throw new IllegalArgumentException();
            }

            if(index < 0){
                System.out.println("The index addressing the array is a negative number.");
                throw new IllegalArgumentException();
            }

            value = TypeCheckerHelper.getArrayElements(varCon.getValue()).get(index);
        }else if(ctx.dotStmt() != null){ //format: = identifier (('.' identifier('[' integer ']')?))+ ;

            String firstIdentifier = ctx.dotStmt().identifier().get(0).getText();

            //Is the dotStmt for getting the length of an array?
            if(ctx.dotStmt().identifier(1).getText().compareTo("length") == 0){
                VariableContainer varCon = getArrayValueFromScope(firstIdentifier);

                if(varCon == null){
                    System.out.println("The identifier being dotted with length, is either not initialized or not an array.");
                    throw new IllegalArgumentException();
                }
                
                value = String.valueOf(varCon.getLengthOfArray());
            }else{
                System.out.println("You are using dot-notation but not on a game piece and not as .length on an array.");
                throw new IllegalArgumentException();
            }
        } else
            throw new GrammarHasChangedException("AssignmentRightContext");

        if(value == null)
            throw new IllegalArgumentException(); //This should not be throw! If so, then the above code is not properly written.

        return value;
    }

    /** @return a vector from the given context. */
    private Vector getVector(Tactic.VecContext ctx){

        ArrayList<Tactic.VecParaContext> parameters = new ArrayList<>(ctx.vecPara());
        Integer[] values = new Integer[3];

        //First parameter
        for(int i = 0; i < parameters.size(); i++){

            if(parameters.get(i).identifier() != null){

                identifierToValueCheck(parameters.get(i).identifier().getText(), VariableType.INT);
                VariableContainer varCon = getValueFromIdentifier(parameters.get(i).identifier().getText());

                values[i] = TypeCheckerHelper.parseInt(varCon.getValue());

            }else if(parameters.get(i).integer() != null){
                values[i] = TypeCheckerHelper.parseInt(parameters.get(i).integer().getText());
            }else if(parameters.get(i).arithExpr() != null){
                float temp = getArithmeticResult(parameters.get(i).arithExpr());
                values[i] = (int)temp;
            }else
                throw new GrammarHasChangedException();
        }

        if(values[2] == null)
            return new Vector(values[0], values[1]);
        else
            return new Vector(values[0], values[1], values[2]);
    }

    // CONDITIONALS ---------------------------------------------------------------------


    @Override
    public void exitBoolExpr(Tactic.BoolExprContext ctx) {

        if(isInProcedureDefinition)
            return;

        if(isWalkingConditional){

            boolean evaluation = getBoolStmtResult(ctx);

            if(evaluation){
                mayRunIfBlock = true;
            }else
                mayRunElseBlocK = true;
        }
    }

    @Override
    public void enterCondStmt(Tactic.CondStmtContext ctx) {
        isWalkingConditional = true;
    }

    @Override
    public void exitCondStmt(Tactic.CondStmtContext ctx) {
        mayRunIfBlock = false;
        mayRunElseBlocK = false;
        isWalkingConditional = false;
    }

    @Override
    public void enterIfStmt(Tactic.IfStmtContext ctx) {
        isInIfBlock = true;
    }

    @Override
    public void exitIfStmt(Tactic.IfStmtContext ctx) {
        isInIfBlock = false;
    }

    @Override
    public void enterElseStmt(Tactic.ElseStmtContext ctx) {
        isInElseBlock = true;
    }

    @Override
    public void exitElseStmt(Tactic.ElseStmtContext ctx) {
        isInElseBlock = false;
    }

    @Override
    public void exitArrayAssign(Tactic.ArrayAssignContext ctx) {
        if(isInProcedureDefinition)
            return;

        if(isTraversingWhileStmt)
            return;

        //TODO Might be on the format: []{x,x,x,,x};

        String identifier = ctx.identifier().getText();
        int index = TypeCheckerHelper.parseInt(ctx.integer().getText());

        VariableContainer varConToOverwrite = getArrayValueFromScope(identifier);

        if(varConToOverwrite == null){
            System.out.println("In the array assignment: the variable being assigned either does not exist or is not an array.");
            throw new IllegalArgumentException();
        }

        String value = getValueOfRightSideAssignment(ctx.assignmentRight(0), varConToOverwrite.getType());
        String newValue;

        if(varConToOverwrite.getType() == VariableType.INT){

            Integer[] array = TypeCheckerHelper.parseIntegerArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseInt(value);

            newValue = new Array(array, VariableType.BOOL).toString();
        } else if(varConToOverwrite.getType() == VariableType.FLOAT){

            Float[] array = TypeCheckerHelper.parseFloatArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseFloat(value);

            newValue = new Array(array, VariableType.BOOL).toString();
        } else if(varConToOverwrite.getType() == VariableType.VEC){

            Vector[] array = TypeCheckerHelper.parseVectorArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseVector(value);

            newValue = new Array(array, VariableType.BOOL).toString();
        } else if(varConToOverwrite.getType() == VariableType.BOOL){

            Boolean[] array = TypeCheckerHelper.parseBooleanArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseBool(value);

            newValue = new Array(array, VariableType.BOOL).toString();
        } else if(varConToOverwrite.getType() == VariableType.STRING){

            String[] array = TypeCheckerHelper.parseStringArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseString(value);

            newValue = new Array(array, VariableType.STRING).toString();
        } else if(varConToOverwrite.getType() == VariableType.GAMEPIECE){

            GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(varConToOverwrite.getValue());

            if(index >= array.length){
                System.out.println("The index for the array assignment is greater than the number of elements in the array.");
                throw new IllegalArgumentException();
            }

            array[index] = TypeCheckerHelper.parseGamePiece(value);

            newValue = new Array(array, VariableType.GAMEPIECE).toString();
        }else
            throw new GrammarHasChangedException("ArrayAssignContext");

        overwriteValueOfVariable(identifier, newValue);
    }
    
    // PROCEDURES -------------------------------------------------------------------------

    @Override
    public void enterProcedureDef(Tactic.ProcedureDefContext ctx) {
        this.isInProcedureDefinition = true;
    }

    @Override
    public void exitProcedureDef(Tactic.ProcedureDefContext ctx) {

        ArrayList<Tactic.TypeContext> types = new ArrayList<>(ctx.type());
        ArrayList<Tactic.IdentifierContext> identifiers = new ArrayList<>(ctx.identifier());
        String procedureIdentifier = identifiers.get(0).getText();
        identifiers.remove(0);

        Procedure proc = new Procedure(procedureIdentifier, this);

        //Collect all arguments
        for(int i = 0; i < types.size(); i++){
            VariableCollectorListener.VariableType type = TypeCheckerHelper.parseVariableType(types.get(i).getText());
            proc.addArgument(new Parameter(type, identifiers.get(i).getText()));
        }

        //Collect all statements in the procedure body
        proc.addAllStatments(ctx.procedureBlock().procedureStmt());

        //TODO Is some of the arguments named the same?

        procedures.put(procedureIdentifier, proc);

        this.isInProcedureDefinition = false;
    }

    @Override
    public void exitProcedureCall(Tactic.ProcedureCallContext ctx) {

        if(isTraversingWhileStmt)
            return;

        String identifier = ctx.identifier().getText();

        this.currentScope = ScopeType.PROCEDURE_SCOPE;

        Procedure procedure = getProcedureFromIdentifier(identifier);

        //Does the procedure have arguments
        if(ctx.children.size() > 3) {
            if (!(ctx.children.get(2).getChild(ctx.children.get(2).getChildCount() - 1) instanceof ArgumentGatherer))
                throw new IllegalArgumentException(); //The arguments has not been collected.

            ArgumentGatherer ag = (ArgumentGatherer) ctx.children.get(2).getChild(ctx.children.get(2).getChildCount() - 1);
            procedureScope.setGivenArguments(ag.getConvertedArgumentsList());
            //procedure.execute(ag.getConvertedArgumentsList(), this, identifier);
        }


        this.procedureScope.setCurrentProcedure(procedure);
        this.procedureScope.execute();

        this.currentScope = ScopeType.MAIN_SCOPE;
        this.procedureScope.reset();
    }

    // DECLARATIONS ----------------------------------------------------

    @Override
    public void exitIntDcl(Tactic.IntDclContext ctx) {
        addVariableToScope(new VariableContainer(ctx.identifier().getText(), null, VariableType.INT));
    }

    @Override
    public void exitFloatDcl(Tactic.FloatDclContext ctx) {
        addVariableToScope(new VariableContainer(ctx.identifier().getText(), null, VariableType.FLOAT));
    }

    @Override
    public void exitVecDcl(Tactic.VecDclContext ctx) {
        addVariableToScope(new VariableContainer(ctx.identifier().getText(), null, VariableType.VEC));
    }

    @Override
    public void exitBoolDcl(Tactic.BoolDclContext ctx) {
        addVariableToScope(new VariableContainer(ctx.identifier().getText(), null, VariableType.BOOL));
    }

    @Override
    public void exitStringDcl(Tactic.StringDclContext ctx) {
        addVariableToScope(new VariableContainer(ctx.identifier().getText(), null, VariableType.STRING));
    }

    @Override
    public void exitGpDcl(Tactic.GpDclContext ctx) {
        String identifier = ctx.identifier().getText();
        addVariableToScope(new VariableContainer(identifier, "name:" + identifier + ",position:,size:,color:,label:,opacity:,shape:,", VariableType.GAMEPIECE));
    }

    @Override
    public void exitArrayDcl(Tactic.ArrayDclContext ctx) {

        //Trying to create an array with 0 elements?
        if(ctx.children.get(2).getText().compareTo("0") == 0){
            System.out.println("An array with 0 elements is being created!");
            throw new IllegalArgumentException();
        }

        int sizeOfArray = Integer.parseInt(ctx.children.get(2).getText());
        String identifier = ctx.identifier().getText();

        VariableContainer varCon;

        if(ctx.type().getText().compareTo("int") == 0){
            Integer[] tempArray = new Integer[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = 1;

            Array<Integer> customArray = new Array<>(tempArray, VariableType.INT);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else if(ctx.type().getText().compareTo("float") == 0){
            Float[] tempArray = new Float[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = 1f;

            Array<Float> customArray = new Array<>(tempArray, VariableType.FLOAT);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else if(ctx.type().getText().compareTo("vector") == 0){
            Vector[] tempArray = new Vector[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = new Vector(0,0,0);

            Array<Vector> customArray = new Array<>(tempArray, VariableType.VEC);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else if(ctx.type().getText().compareTo("bool") == 0){
            Boolean[] tempArray = new Boolean[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = true;

            Array<Boolean> customArray = new Array<>(tempArray, VariableType.BOOL);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else if(ctx.type().getText().compareTo("string") == 0){
            String[] tempArray = new String[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = "";

            Array<String> customArray = new Array<>(tempArray, VariableType.STRING);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else if(ctx.type().getText().compareTo("GamePiece") == 0){
            GamePiece[] tempArray = new GamePiece[sizeOfArray];
            for(int i = 0; i < sizeOfArray; i++)
                tempArray[i] = new GamePiece();

            Array<GamePiece> customArray = new Array<>(tempArray, VariableType.GAMEPIECE);
            varCon = new VariableContainer(identifier, customArray.toString(), customArray.getType(), true);
        }else
            throw new GrammarHasChangedException("exitArrayDcl");

        addVariableToScope(varCon);
    }

    // -----------------------------------------------------------------

    public void exitDotAssignment(Tactic.DotAssignmentContext ctx) {

        if(!mayThisStmtRun())
            return;

        if(isTraversingWhileStmt)
            return;

        String identifier = ctx.dotStmt().identifier().get(0).getText();

        if(!hasBeenInitialized(identifier)){
            System.out.println("Dot assignment is used on a non-initialized variable.");
            throw new IllegalArgumentException();
        }

        VariableContainer variableBeingDotted = getValueFromScope(identifier);

        //This section is triggered when DotAssignment is used on a GamePiece
        if(variableBeingDotted.getType() == VariableCollectorListener.VariableType.GAMEPIECE){

            String identifierAfterDot = ctx.dotStmt().identifier().get(1).getText();

            //Parse identifierAfterDot to get the GP property
            GamePiece.GamePiecePropertyType gpPropType = TypeCheckerHelper.parseGamePiecePropertyType(identifierAfterDot);

            if(gpPropType == null){
                System.out.println("A GamePiece is being dotted with a non-GPProperty string");
                throw new IllegalArgumentException();
            }

            //Change the property in the GP (also removed citation-marks if needed)
            String newPropertyValue = TypeCheckerHelper.parseString(ctx.value().getText()); //Trim citations
            if(gpPropType == GamePiece.GamePiecePropertyType.COLOR) ActionCollectorListener.checkGamePiecePropertyColorValue(newPropertyValue);
            GamePiece gp = TypeCheckerHelper.parseGamePiece(variableBeingDotted.getValue());
            gp.changeProperty(gpPropType, newPropertyValue);

            //Save the changed GamePiece
            String changedGpValue = gp.getGamePieceString();
            addVariableToScope(new VariableContainer(variableBeingDotted.getIdentifier(), changedGpValue, VariableCollectorListener.VariableType.GAMEPIECE));
        }
    }

    //VECTOR ARITHMETIC
    /** @return the result of the given VecExpr. */
    private Vector getResultOfVectorArithmetic(Tactic.VecExprContext ctx){

        Vector resultVector = null;
        String operator = null;


        for(ParseTree child : ctx.children){
            if(child instanceof Tactic.VecContext){
                if(resultVector != null){
                    Vector currentVector = TypeCheckerHelper.parseVector(child.getText());
                    resultVector = getResultOfVectorOperation(resultVector, currentVector, operator);
                } else //First vector
                    resultVector = TypeCheckerHelper.parseVector(child.getText());

            }else if(child instanceof Tactic.VecOperatorContext){
                operator = child.getText();
            }else if(child instanceof  Tactic.IdentifierContext){

                VariableContainer varCon = getValueFromIdentifier(child.getText());

                if(varCon == null){
                    System.out.println("The identifier has not been declared.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getType() != VariableType.VEC){
                    System.out.println("The variable has been declared but is not of type vector.");
                    throw new IllegalArgumentException();
                }

                Vector currentVector = TypeCheckerHelper.parseVector(varCon.getValue());
                resultVector = getResultOfVectorOperation(resultVector, currentVector, operator);
            }
        }

        return resultVector;
    }

    private Vector getResultOfVectorOperation(Vector one, Vector two, String operator){
        if(operator.compareTo("+") == 0){ //Addition
            one.addVector(two);
        }else if(operator.compareTo("-") == 0){ //Subtraction
            one.subVector(two);
        }else
            throw new GrammarHasChangedException("VectorOperations");

        return one;
    }

    // ARITHMETIC EXPRESSIONS ------------------------------

    private boolean doesArithExprContainVector(Tactic.ArithExprContext ctx){
        ArithmeticGatherer ag = (ArithmeticGatherer)ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1);
        return doesEquationContainAVector(ag.getEquation());
    }

    public boolean doesEquationContainAVector(String equation){

        boolean vectorFound = false;
        boolean isParsingVector = false;
        int commaCounter = 0;

        for(char c : equation.toCharArray()){

            if(c == '('){
                isParsingVector = true;
                commaCounter = 0;
            }else if(c == ')'){
                if(isParsingVector && commaCounter == 2){
                    vectorFound = true;
                }

                isParsingVector = false;
            }else if(c == ','){
                commaCounter++;
            }
        }

        return vectorFound;
    }

    /** Checks: only two values, and both vectors. */
    private boolean isArithExprAValidVectorExpr(Tactic.ArithExprContext ctx){

        //TODO Does the arithmetic expr, only contain two elements?
        //TODO is both elements vectors?

        ArithmeticGatherer ag = (ArithmeticGatherer)ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1);
        String equation = ag.getEquation();

        //Does the equation contain 2x')' , 2x'(' , 4x',' and one sign, either + or -

        int lParenthesesCounter = 0;
        int rParenthesesCounter = 0;
        int commaCounter = 0;
        int plusMinusSignCounter = 0;

        //TODO REWORK CHECK: first ( ... then numbers or - until comma and so on..
        for(char c : equation.toCharArray()){

            if(c == '(')
                lParenthesesCounter++;
            else if(c == ')')
                rParenthesesCounter++;
            else if(c == ',')
                commaCounter++;
            else if(c == '+' || c == '-')
                plusMinusSignCounter++;
            else if(isCharADigit(c) || c == '.') //TODO CHECK for negative values in vectors
                continue;
            else
                return false;

        }

        return lParenthesesCounter == 2 && rParenthesesCounter == 2 && commaCounter == 4 && plusMinusSignCounter > 0;
    }

    private boolean isCharADigit(char c){
        return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9';
    }

    private float getArithmeticResult(Tactic.ArithExprContext ctx){

        if(ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)  instanceof ArithmeticGatherer)
            return (float)((ArithmeticGatherer) ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)).getResult();

        //This should never happen. If it does, the arithmetic expression
        //parsing (below functions) did not go ad expected.
        throw new IllegalArgumentException();
    }

    @Override
    public void exitArithExprParent(Tactic.ArithExprParentContext ctx) {

        if(!mayThisStmtRun())
            return;

        //Get all arithmeticGatherers from the children
        ArrayList<ArithmeticGatherer> ags = new ArrayList<>();

        for (ParseTree child : ctx.children)
            ags.add((ArithmeticGatherer) child.getChild(child.getChildCount() -1));

        //Put together the final ag with the final equation
        ArithmeticGatherer finalAG = new ArithmeticGatherer();
        for (ArithmeticGatherer ag : ags)
            finalAG.addValue(ag.getEquation());

        ctx.addChild(finalAG);
    }

    @Override
    public void exitArithExprParenthMiddle(Tactic.ArithExprParenthMiddleContext ctx) {

        if(!mayThisStmtRun())
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        ag.addValue("(");
        ag.addValue(((ArithmeticGatherer)ctx.arithExpr().children.get(0).getChild(ctx.arithExpr().children.get(0).getChildCount() -1)).getEquation());
        ag.addValue(")");

        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprMiddle(Tactic.ArithExprMiddleContext ctx) {

        if(!mayThisStmtRun())
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprRight(Tactic.ArithExprRightContext ctx) {

        if(!mayThisStmtRun())
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprLeft(Tactic.ArithExprLeftContext ctx) {

        if(!mayThisStmtRun())
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprBoth(Tactic.ArithExprBothContext ctx) {

        if(!mayThisStmtRun())
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    /** Fills the given ArithmeticGatherer with the values of children in the given list.
     * @param nodes the list of children found in: arithExprMiddle, arithExprRight, arithExprBoth and arithExprLeft.*/
    private void getAllArithmeticEndNodes(ArithmeticGatherer ag, List<ParseTree> nodes){
        for (ParseTree node : nodes) {
            if (node instanceof Tactic.NumberContext) {
                ag.addValue(node.getText());
            } else if (node instanceof Tactic.ArithActionContext) {
                ag.addValue(node.getText());
            } else if (node instanceof Tactic.IdentifierContext) {

                VariableContainer varCon = getValueFromIdentifier(node.getText());

                if(varCon == null)
                    throw new IllegalArgumentException(); //The variable has not been initialized

                if(varCon.getType() != VariableCollectorListener.VariableType.INT &&
                        varCon.getType() != VariableCollectorListener.VariableType.FLOAT &&
                        varCon.getType() != VariableType.VEC)
                    throw new IllegalArgumentException(); //Not the correct type

                ag.addValue(varCon.getValue());
            } else {
                throw new GrammarHasChangedException("ArithmeticContext");
            }
        }
    }

    // BOOL STMT ----------------------------------------------------------------------

    /** @return the result of the given BoolStmtContext. */
    public boolean getBoolStmtResult(Tactic.BoolExprContext ctx){
        if(ctx.identifier() != null){
            identifierToValueCheck(ctx.identifier().getText(), VariableType.BOOL);
            VariableContainer varCon = getValueFromIdentifier(ctx.identifier().getText());
            return TypeCheckerHelper.parseBool(varCon.getValue());
        }else if(ctx.bool() != null){
            return TypeCheckerHelper.parseBool(ctx.bool().getText());
        }else if(ctx.boolOperaters() != null){

            Tactic.ValueContext firstValue = ctx.value(0);
            Tactic.ValueContext secondValue = ctx.value(1);

            if(firstValue.bool() != null && secondValue != null){ //Both booleans
                boolean firstBool = TypeCheckerHelper.parseBool(firstValue.bool().getText());
                boolean secondBool = TypeCheckerHelper.parseBool(secondValue.bool().getText());
                return performBoolOperationOnBool(firstBool, secondBool, ctx.boolOperaters());
            }else if(firstValue.vec() != null || secondValue.vec() != null){
                throw new IllegalArgumentException(); //BoolStmt contains vectors.
            }else if(firstValue.string() != null && secondValue.string() != null){
                throw new IllegalArgumentException(); //Bool comparison of two strings
            }else if(firstValue.number() != null || firstValue.identifier() != null){
                if(secondValue.number() != null || secondValue.identifier() != null){

                    //At this point both values have on of the two types: Number or Identifier.

                    Number firstNum;
                    Number secondNum;

                    if(firstValue.number() != null){
                        firstNum = TypeCheckerHelper.parseNumber(firstValue.number().getText());
                    }else{ //The first value is an identifier
                        //Resolve identifier and check if it exists
                        VariableContainer varCon = getValueFromIdentifier(firstValue.identifier().getText());
                        if(varCon == null)
                            throw new IllegalArgumentException(); //In the boolstmt, the first identifier does not exist.

                        //Resolve value to number and check if it was a number
                        firstNum = TypeCheckerHelper.parseNumber(varCon.getValue());
                        if(firstNum == null)
                            throw new IllegalArgumentException(); //In the boolstmt, the first identifier is not a number or has not yet been assigned.
                    }

                    if(secondValue.number() != null){
                        secondNum = TypeCheckerHelper.parseNumber(secondValue.number().getText());
                    }else{ //The second value is an identifier
                        //Resolve identifier and check if it exists
                        VariableContainer varCon = getValueFromIdentifier(secondValue.identifier().getText());
                        if(varCon == null)
                            throw new IllegalArgumentException(); //In the boolstmt, the first identifier does not exist.

                        //Resolve value to number and check if it was a number
                        secondNum = TypeCheckerHelper.parseNumber(varCon.getValue());
                        if(secondNum == null)
                            throw new IllegalArgumentException(); //In the boolstmt, the first identifier is not a number or has not yet been assigned.
                    }

                    return performBoolOperationOnNumbers(firstNum, secondNum, ctx.boolOperaters());
                }else{
                    throw new IllegalArgumentException(); //Not supported operation
                }
            }else{
                throw new IllegalArgumentException(); //Not supported operation
            }
        }else{
            throw new GrammarHasChangedException("BoolExprContext");
        }
    }

    /** Takes two numbers and an operator: ==, <, >, <=, >=, !=, performs the operations and returns the result. */
    private Boolean performBoolOperationOnNumbers(Number firstNum, Number secondNum, Tactic.BoolOperatersContext operatersContext){

        float firstVal = (firstNum.getIntValue() != null) ? firstNum.getIntValue() : firstNum.getFloatValue();
        float secondVal = (secondNum.getIntValue() != null) ? secondNum.getIntValue() : secondNum.getFloatValue();

        if(operatersContext.BOOL_EQUAL() != null){
            return firstVal == secondVal; // ==
        }else if(operatersContext.BOOL_LESS() != null){
            return firstVal < secondVal; // <
        }else if(operatersContext.BOOL_GREATER() != null){
            return firstVal > secondVal; // >
        }else if(operatersContext.BOOL_LESS_OR_EQUAL() != null){
            return firstVal <= secondVal; // <=
        }else if(operatersContext.BOOL_GREATER_OR_EQUAL() != null){
            return firstVal >= secondVal; // >=
        }else if(operatersContext.BOOL_N_EQUAL() != null){
            return firstVal != secondVal; // !=
        }else {
            throw new IllegalArgumentException(); //Illegal operators on numbers.
        }
    }

    /** Takes two booleans and an operator: ==, &&, ||, != , performs the operations and returns the result. */
    private Boolean performBoolOperationOnBool(boolean firstBool, boolean secondBool, Tactic.BoolOperatersContext operatorContext){

        if(operatorContext.BOOL_COND_AND() != null){
            return firstBool && secondBool;
        }else if(operatorContext.BOOL_COND_OR() != null){
            return firstBool || secondBool;
        }else if(operatorContext.BOOL_EQUAL() != null){
            return firstBool == secondBool;
        }else if(operatorContext.BOOL_GREATER() != null){
            throw new IllegalArgumentException(); //firstBool > secondBool;
        }else if(operatorContext.BOOL_GREATER_OR_EQUAL() != null){
            throw new IllegalArgumentException();  //firstBool >= secondBool;
        }else if(operatorContext.BOOL_LESS() != null){
            throw new IllegalArgumentException(); //firstBool < secondBool;
        }else if(operatorContext.BOOL_N_EQUAL() != null){
            return firstBool != secondBool;
        }else if(operatorContext.BOOL_LESS_OR_EQUAL() != null) {
            throw new IllegalArgumentException(); //firstBool <= secondBool;
        }else if(operatorContext.BOOL_COND_AND() != null){
            return firstBool && secondBool;
        }else
            throw new GrammarHasChangedException("BoolOperatersContext");
    }

    @Override
    public void exitDotStmt(Tactic.DotStmtContext ctx) {
        if(!mayThisStmtRun())
            return;

        if(isTraversingWhileStmt)
            return;

        //TODO
    }

    @Override
    public void enterWhileStmt(Tactic.WhileStmtContext ctx) {
        isTraversingWhileStmt = true;
    }

    @Override
    public void exitWhileStmt(Tactic.WhileStmtContext ctx) {
        if(!mayThisStmtRun())
            return;

        isTraversingWhileStmt = false;

        //Setup phase
        boolean conditional = getBoolStmtResult(ctx.boolExpr()); //Evaluate boolExpr
        //Is evaluate boolExpr true? Then collect statements
        List<Tactic.StmtContext> statements = new ArrayList<>();
        if(conditional && ctx.block().stmt() != null)
            statements = ctx.block().stmt();

        //Should we run stmts?
        while(conditional){

            //Run all statements
            for(Tactic.StmtContext stmt : statements){
                if(stmt.dotAssignment() != null){
                    this.exitDotAssignment(stmt.dotAssignment());
                }else if(stmt.arrayAssign() != null){
                    this.exitArrayAssign(stmt.arrayAssign());
                }else if(stmt.procedureCall() != null){
                    this.exitProcedureCall(stmt.procedureCall());
                }else if(stmt.condStmt() != null){

                    this.isWalkingConditional = true;
                    this.exitBoolExpr(stmt.condStmt().ifStmt().boolExpr()); //Evaluate if or else?

                    Procedure temp = new Procedure("temp", this);

                    if(mayRunIfBlock)
                        for(Tactic.StmtContext stmtCtx : stmt.condStmt().ifStmt().block().stmt())
                            temp.runStmt(stmtCtx.children.get(0));

                    if(mayRunElseBlocK)
                        for(Tactic.StmtContext stmtCtx : stmt.condStmt().elseStmt().block().stmt())
                            temp.runStmt(stmtCtx.children.get(0));

                    this.isWalkingConditional = false;
                }else if(stmt.whileStmt() != null){
                    this.exitWhileStmt(stmt.whileStmt());
                }else if(stmt.assignment() != null){
                    bl.exitAssignment(stmt.assignment());
                    this.exitAssignment(stmt.assignment());
                }else if(stmt.action() != null){
                    acl.exitAction(stmt.action());
                }
            }

            conditional = getBoolStmtResult(ctx.boolExpr());
        }
    }

    public void setAcl(ActionCollectorListener acl) {
        this.acl = acl;
    }

    public void setBl(BoardListener bl) {
        this.bl = bl;
    }

    /** This method is used to combine all arguments in a function call.
     * It uses that class ArgumentGatherer to collect and merge arguments while traversing
     * the tree for a given function call.
     * Method: This method is called every time an Argument node is exited. If it only has one child,
     * it is an end note with a value, here we create an instance of the ArgumentCollector with the current
     * nodes value, and attached to the current node. If the node being exited has three children,
     * an argument node, a comma node, and another argument node, we create a new ArgumentGatherer
     * from the two attached to the current nodes two argument children. Purpose: when exiting a
     * function call, we can then get the last child for that node, and it will be a ArgumentGatherer
     * containing all arguments for the function call. */
    @Override
    public void exitArguments(Tactic.ArgumentsContext ctx) {

        if(!mayThisStmtRun())
            return;


        if (ctx.children.size() == 1) { //This is an end note. The child is a value
            ArgumentGatherer ag = new ArgumentGatherer();
            ag.addArgument((Tactic.ValueContext) ctx.children.get(0));
            ctx.addChild(ag);
        } else if (ctx.children.size() == 3) { //This is a node that has two arguments as children. The middle child is a comma.

            //Get the last child of the first node in this node: current(ctx).1.last
            ArgumentGatherer agFirstArgument = (ArgumentGatherer) ((Tactic.ArgumentsContext) ctx.children.get(0)).children.get(ctx.children.get(0).getChildCount() - 1);

            //Get the last child of the third node in this node: current(ctx).3.last
            ArgumentGatherer agSecondArgument = (ArgumentGatherer) ((Tactic.ArgumentsContext) ctx.children.get(2)).children.get(ctx.children.get(2).getChildCount() - 1);

            //Merge the arguments of the children and
            ArgumentGatherer mergedAg = new ArgumentGatherer();
            mergedAg.addAllArguments(agFirstArgument.getList());
            mergedAg.addAllArguments(agSecondArgument.getList());

            //Attach the merged ArgumentGatherer to the current node
            ctx.addChild(mergedAg);
        }
    }
}
