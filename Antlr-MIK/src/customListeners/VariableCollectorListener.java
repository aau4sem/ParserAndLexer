package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.Procedure;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
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

    //TODO Maybe split into two listeners: one of them being declaration collector???

    //Two variableScopeData to keep track of variable declarations in the main and function scope
    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.ScopeType.MAIN_SCOPE);
    //private VariableScopeData procedureScope = new VariableScopeData(VariableScopeData.ScopeType.PROCEDURE_SCOPE);
    private ProcedureScopeData procedureScope = new ProcedureScopeData(mainScope);

    //Keeps track of which scope the parsing/tree walk currently is in
    private VariableScopeData.ScopeType currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;

    //Collection for declared procedures
    private HashMap<String, Procedure> procedures = new HashMap<>();

    //All supported variable types
    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}

    public boolean isInProcedureDefinition = false; //TODO Comment

    // CORE METHODS -----------------------------------------------------------

    /** Used to add variables to the current scope.
     * @param varCon variable container, containing the value and information of the variable. */
    public void addVariableToScope(VariableContainer varCon){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE){
            mainScope.addVariable(varCon);
        }
    }

    /** Used to overwrite a value of a variables.
     * @param val the new value that will be used to overwrite the old one.
     * @param identifier the identifier of the variable to overwrite. */
    public void overwriteValueOfVariable(String identifier, String val){

        if(currentScope == VariableScopeData.ScopeType.PROCEDURE_SCOPE){
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
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            varCon = mainScope.getVariable(identifier);
        else{
            varCon = procedureScope.getVariable(identifier);
            if(varCon == null)
                varCon = mainScope.getVariable(identifier);
        }

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

    // OVERWRITES ----------------------------------------------------

    @Override
    public void exitAssignment(Tactic.AssignmentContext ctx) {

        if(isInProcedureDefinition)
            return;

        String identifier = ctx.identifier(0).getText();
        String value;

        //Check the identifier on the left side of the assignment
        VariableContainer varConToOverwrite = getValueFromIdentifier(identifier);

        if(varConToOverwrite == null){
            System.out.println("The variable to overwrite has not been declared!");
            throw new IllegalArgumentException();
        }

        VariableType typeLeftIdentifier = varConToOverwrite.getType();


        //TODO Check if it is an array assignment

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
                if(typeLeftIdentifier == varConRight.getType()){
                    value = varConRight.getValue();
                } else if(typeLeftIdentifier == VariableType.INT && varConRight.getType() == VariableType.FLOAT){
                    throw new IllegalArgumentException(); //Trying to assign an float to an int
                    //value = String.valueOf(TypeCheckerHelper.trimFloatToInt(varConRight.getValue())); //Cast value from float to int //TODO We do want to casts float to int right?
                } else if(typeLeftIdentifier == VariableType.FLOAT && varConRight.getType() == VariableType.INT){
                    value = varConRight.getValue(); //Casting int to float
                } else{
                    System.out.println("The value in the right side of the assignment is wrong.");
                    throw new IllegalArgumentException();
                }
            }else if(valueContext.number() != null){ //format: number
                Number num = TypeCheckerHelper.parseNumber(valueContext.number().getText());
                if(typeLeftIdentifier == VariableType.INT){
                    if(num.getIntValue() == null){
                        throw new IllegalArgumentException(); //Trying to assign a float value to an int
                    }
                    value = String.valueOf(num.getIntValue());
                }else if (typeLeftIdentifier == VariableType.FLOAT){
                    if(num.getIntValue() != null)
                        value = String.valueOf(num.getIntValue());
                    else if(num.getFloatValue() != null)
                        value = String.valueOf(num.getFloatValue());
                    else
                        throw new IllegalArgumentException(); //This is not possible!
                }else
                    throw new IllegalArgumentException(); //This is not possible!
            }else if(valueContext.bool() != null){ //format: bool
                value = String.valueOf(TypeCheckerHelper.parseBool(valueContext.bool().getText()));
            }else if(valueContext.string() != null){ //format: string
                value = TypeCheckerHelper.parseString(valueContext.string().getText());
                if(value == null) throw new IllegalArgumentException(); //Could not parse string.
            } else if(valueContext.vec() != null){ //format: vec
                value = String.valueOf(TypeCheckerHelper.parseVector(valueContext.vec().getText()));
            }else
                throw new IllegalArgumentException(); //Grammar has changed

        } else if(ctx.arithExpr() != null){ //format identifier = arithExpr
            String result = String.valueOf(getArithmeticResult(ctx.arithExpr()));
            value = String.valueOf(TypeCheckerHelper.trimFloatToInt(result)); //If the type the result is saved in, is of type integer, decimals will be cut off
        //} else if(ctx.boolStmt() != null){ //format identifier = boolStmt //TODO Change in grammar has made this invalid, Mathias is working on solution
        //    value = String.valueOf(getBoolStmtResult(ctx.boolStmt())); //TODO Change in grammar has made this invalid, Mathias is working on solution
        } else if(ctx.vecExpr() != null){ //format identifier = vecExpr (subtraction or addition)
            throw new IllegalArgumentException(); //TODO Not yet implemented
        } else if(ctx.identifier().size() == 2){ //format identifier = (identifier (LBRACKET integer RBRACKET)+) | dotStmt)
            throw new IllegalArgumentException(); //TODO Not yet implemented
        } else
            throw new IllegalArgumentException(); //Grammar has changed

        if(value == null)
            throw new IllegalArgumentException(); //This should not be throw! If so, then the above code is not properly written.

        overwriteValueOfVariable(identifier, value);
    }

    @Override
    public void exitArrayAssign(Tactic.ArrayAssignContext ctx) {
        if(isInProcedureDefinition)
            return;
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
        proc.addAllStatments(ctx.procedureBlock().stmt());

        //TODO Is some of the arguments named the same?

        procedures.put(procedureIdentifier, proc);

        this.isInProcedureDefinition = false;
    }

    @Override
    public void exitProcedureCall(Tactic.ProcedureCallContext ctx) {

        String identifier = ctx.identifier().getText();

        //Is the procedure call one of the three action calls? If so, do not do anything. (This is handled in ActionCollectorListener.)
        if(!(identifier.compareTo("change") == 0 || identifier.compareTo("move") == 0 ||identifier.compareTo("wait") == 0)){
            this.currentScope = VariableScopeData.ScopeType.PROCEDURE_SCOPE;

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

            this.currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;
            this.procedureScope.reset();
        }
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
        super.exitArrayDcl(ctx); //TODO HANDLE
    }

    // -----------------------------------------------------------------

    public void exitDotAssignment(Tactic.DotAssignmentContext ctx) {

        if(isInProcedureDefinition)
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
            GamePiece gp = TypeCheckerHelper.parseGamePiece(getValueFromScope(identifier).getValue());
            gp.changeProperty(gpPropType, newPropertyValue);

            //Save the changed GamePiece
            String changedGpValue = gp.getGamePieceString();
            addVariableToScope(new VariableContainer(identifier, changedGpValue, VariableCollectorListener.VariableType.GAMEPIECE));
        }
    }

    // ARITHMETIC EXPRESSIONS ------------------------------

    private float getArithmeticResult(Tactic.ArithExprContext ctx){

        if(ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)  instanceof ArithmeticGatherer)
            return (float)((ArithmeticGatherer) ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)).getResult();

        //This should never happen. If it does, the arithmetic expression
        //parsing (below functions) did not go ad expected.
        throw new IllegalArgumentException();
    }

    @Override
    public void exitArithExprParent(Tactic.ArithExprParentContext ctx) {

        if(isInProcedureDefinition)
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

        if(isInProcedureDefinition)
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        ag.addValue("(");
        ag.addValue(((ArithmeticGatherer)ctx.arithExpr().children.get(0).getChild(ctx.arithExpr().children.get(0).getChildCount() -1)).getEquation());
        ag.addValue(")");

        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprMiddle(Tactic.ArithExprMiddleContext ctx) {

        if(isInProcedureDefinition)
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprRight(Tactic.ArithExprRightContext ctx) {

        if(isInProcedureDefinition)
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprLeft(Tactic.ArithExprLeftContext ctx) {

        if(isInProcedureDefinition)
            return;

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprBoth(Tactic.ArithExprBothContext ctx) {

        if(isInProcedureDefinition)
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

                if(varCon.getType() != VariableCollectorListener.VariableType.INT && varCon.getType() != VariableCollectorListener.VariableType.FLOAT)
                    throw new IllegalArgumentException(); //Not the correct type

                ag.addValue(varCon.getValue());
            } else {
                throw new IllegalArgumentException(); //Grammar has changed
            }
        }
    }

    // BOOL STMT ----------------------------------------------------------------------

    /** @return the result of the given BoolStmtContext. */ //TODO Change in grammar has made this invalid, Mathias is working on solution
    /*
    private boolean getBoolStmtResult(Tactic.BoolStmtContext ctx){

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
            throw new IllegalArgumentException(); //Grammar has changed
        }
    }*/

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
            throw new IllegalArgumentException(); //Grammar has changed

        throw new IllegalArgumentException(); //Should not be reached
    }

    @Override
    public void exitDotStmt(Tactic.DotStmtContext ctx) {
        if(isInProcedureDefinition)
            return;

        //TODO
    }

    @Override
    public void exitCondStmt(Tactic.CondStmtContext ctx) {
        if(isInProcedureDefinition)
            return;

        //TODO
    }

    @Override
    public void exitWhileStmt(Tactic.WhileStmtContext ctx) {
        if(isInProcedureDefinition)
            return;

        //TODO
    }
}
