package customListeners;

import exceptions.IllegalArgumentType;
import model.dataTypes.GamePiece;
import model.utils.ArithmeticGatherer;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;
import gen.*;
import java.util.ArrayList;

/** This class will collect and handle variables during parsing.
 * The idea is that during the pass, this class will contain a
 * model with the current state of variables, and other classes
 * and listeners will request this class for information regarding
 * variables. */
public class VariableCollectorListener extends TacticBaseListener {

    //Two variableScopeData to keep track of variable declarations in the main and function scope
    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.ScopeType.MAIN_SCOPE);
    private VariableScopeData functionScope = new VariableScopeData(VariableScopeData.ScopeType.FUNCTION_SCOPE);

    //Keeps track of which scope the parsing/tree walk currently is in
    private VariableScopeData.ScopeType currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;

    //All supported variable types
    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}

    // CORE METHODS -----------------------------------------------------------

    /** Used to add variables to the current scope.
     * @param varCon variable container, containing the value and information of the variable. */
    private void addVariableToScope(VariableContainer varCon){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE){
            mainScope.addVariable(varCon);
        }else{
            functionScope.addVariable(varCon);
        }
    }

    /** Used to get variables from the current scope. If the current scope
     * is function scope, and ff the variable is not found in the function
     * scope, it will then search the main scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    private VariableContainer getValueFromScope(String identifier){

        VariableContainer varCon;

        //Get VariableContainer from the current scope
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            varCon = mainScope.getVariable(identifier);
        else{
            varCon = functionScope.getVariable(identifier);
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

    // UTILITIES -----------------------------------------------------------------

    /** @return the same string but without " at the start and the end. */
    private String trimCitations(String input){

        boolean isFirstCitation = false;
        boolean isLastCitation = false;

        if(input.charAt(0) == '"')
            isFirstCitation = true;
        if(input.charAt(input.length() -1) == '"')
            isLastCitation = true;

        if(isFirstCitation && isLastCitation)
            return input.substring(1, input.length() -1);
        if(isFirstCitation)
            return input.substring(1);
        if(isLastCitation)
            return input.substring(0, input.length() -1);

        return input;
    }

    /** @return all GamePieces instantiated. */
    public ArrayList<GamePiece> getAllGamePieces(){

        ArrayList<GamePiece> allGamePieces = new ArrayList<>();

        for( VariableContainer varCon : mainScope.getAllVariablesOfType(VariableType.GAMEPIECE))
            allGamePieces.add(TypeCheckerHelper.parseGamePiece(varCon.getValue()));

        return allGamePieces;
    }

    // OVERWRITES ----------------------------------------------------

    /** When entering a function definition, the current scope is changed. */
    @Override
    public void enterFunctionDef(Tactic.FunctionDefContext ctx) {
        this.currentScope = VariableScopeData.ScopeType.FUNCTION_SCOPE;
    }

    /** When exiting a function definition the scope is changed back to MAIN_SCOPE,
     * and the saved variables for the function scope is removed. */
    @Override
    public void exitFunctionDef(Tactic.FunctionDefContext ctx) {
        this.currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;
        //Reset the function scope
        this.functionScope = new VariableScopeData(VariableScopeData.ScopeType.FUNCTION_SCOPE);
    }

    //TODO: If we still support functions: The scope should also change when entering a function call

    // Declarations:
    @Override
    public void exitIntDcl(Tactic.IntDclContext ctx) {

        String identifier = ctx.children.get(1).getText();
        String value;

        //Is there an assign?
        if(ctx.ASSIGN() != null){ //format: INTEGER identifier ASSIGN (number | arithExpr | identifier)
            if(ctx.number() != null){ //format: INTEGER identifier ASSIGN number
                value = ctx.number().getText();

                Integer parsedValue = TypeCheckerHelper.parseInt(value);

                if(parsedValue == null){
                    System.out.println("The value being assigned is not of type integer.");
                    throw new IllegalArgumentException();
                }
            } else if(ctx.identifier().get(1) != null){ //format: INTEGER identifier ASSIGN identifier
                //Get the second identifier from the statement and the matching variable
                String otherIdentifier = ctx.identifier().get(1).getText();
                VariableContainer varCon = getValueFromScope(otherIdentifier);

                if(varCon == null){
                    System.out.println("The requested variable has not been declared.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getValue() == null){
                    System.out.println("The requested variable has been declared but not assigned.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getType() != VariableType.INT){
                    System.out.println("The requested variable does exist, is assigned, but is not an integer."); //TODO This should never happen: we check the value before assigning it.
                    throw new IllegalArgumentException();
                }

                value = TypeCheckerHelper.parseInt(varCon.getValue()).toString();

            } else if(ctx.arithExpr() != null) {  //format: INTEGER identifier ASSIGN arithExpr
                value = null; //TODO TEMP //Use the same technique used for gathering arguments
            }else{
                throw new IllegalArgumentException(); //If this is thrown, the grammar has been changed.
            }
        }else{ //format: INTEGER identifier
            value = null;
        }

        addVariableToScope(new VariableContainer(identifier, value, VariableType.INT));
    }

    @Override
    public void exitFloatDcl(Tactic.FloatDclContext ctx) {

        String identifier = ctx.children.get(1).getText();
        String value;

        //Is there an assign?
        if(ctx.ASSIGN() != null){ //format: FLOAT identifier (ASSIGN (number | identifier | arithExpr | functionCall))?;
            if(ctx.number() != null){ //format: FLOAT identifier ASSIGN number
                value = ctx.number().getText();

                Float parsedValue = TypeCheckerHelper.parseFloat(value);

                if(parsedValue == null){
                    System.out.println("The value being assigned is not of type float.");
                    throw new IllegalArgumentException();
                }
            }else if(ctx.identifier().get(1) != null) { //format: FLOAT identifier ASSIGN identifier

                //Get the second identifier from the statement and the matching variable
                String otherIdentifier = ctx.identifier().get(1).getText();
                VariableContainer varCon = getValueFromScope(otherIdentifier);

                if(varCon == null){
                    System.out.println("The requested variable has not been declared.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getValue() == null){
                    System.out.println("The requested variable has been declared but not assigned.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getType() != VariableType.FLOAT){
                    System.out.println("The requested variable does exist, is assigned, but is not a float."); //TODO This should never happen: we check the value before assigning it.
                    throw new IllegalArgumentException();
                }

                value = TypeCheckerHelper.parseFloat(varCon.getValue()).toString();
            } else if(ctx.arithExpr() != null){ //format: FLOAT identifier ASSIGN arithExpr
                value = null; //TODO TEMP //Use the same technique used for gathering arguments
            }else{
                throw new IllegalArgumentException(); //If this is thrown, the grammar has been changed.
            }
        }else{ //format: FLOAT identifier
            value = null;
        }

        addVariableToScope(new VariableContainer(identifier, value, VariableType.FLOAT));
    }

    @Override
    public void exitVecDcl(Tactic.VecDclContext ctx) {

        String identifier = ctx.children.get(1).getText();
        String value = null;

        //Is there an assign?
        if(ctx.ASSIGN() != null){ //format: VEC identifier ASSIGN (vec | vecExpr | functionCall | identifier);
            if(ctx.vec() != null) { //format: VEC identifier ASSIGN vec //format: vector x = (3,2,3) eller vector x = (3,2)

                //Get all children of type number
                ArrayList<Tactic.NumberContext> numbers = new ArrayList<>();

                for(int i = 0; i < ctx.vec().children.size(); i++){
                    if(ctx.vec().children.get(i) instanceof Tactic.NumberContext)
                        numbers.add((Tactic.NumberContext)ctx.vec().children.get(i));
                }

                //2d or 3d vector? Then check types of values
                if(numbers.size() == 2){ //2d vector

                    int intValues = 0;
                    int floatValues = 0;

                    //Count number of each type
                    for(Tactic.NumberContext numCon : numbers){
                        if(numCon.integer() != null)
                            intValues++;
                        if(numCon.floatVal() != null)
                            floatValues++;
                    }

                    if(intValues == 2){

                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(numbers.get(0).integer().getText());
                        sb.append(",");
                        sb.append(numbers.get(1).integer().getText());
                        sb.append(",");
                        sb.append("-1");
                        sb.append(")");

                        value = sb.toString();

                    }else if(floatValues == 2){

                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(numbers.get(0).floatVal().getText());
                        sb.append(",");
                        sb.append(numbers.get(1).floatVal().getText());
                        sb.append(",");
                        sb.append("-1");
                        sb.append(")");

                        value = sb.toString();

                    } else{
                        System.out.println("The vector has been declared with a mix of types!");
                        throw new IllegalArgumentException();
                    }

                } else if(numbers.size() == 3){ //3d vector

                    int intValues = 0;
                    int floatValues = 0;

                    //Count number of each type
                    for(Tactic.NumberContext numCon : numbers){
                        if(numCon.integer() != null)
                            intValues++;
                        if(numCon.floatVal() != null)
                            floatValues++;
                    }

                    if(intValues == 3){

                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(numbers.get(0).integer().getText());
                        sb.append(",");
                        sb.append(numbers.get(1).integer().getText());
                        sb.append(",");
                        sb.append(numbers.get(2).integer().getText());
                        sb.append(")");

                        value = sb.toString();

                    }else if(floatValues == 3){

                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(numbers.get(0).floatVal().getText());
                        sb.append(",");
                        sb.append(numbers.get(1).floatVal().getText());
                        sb.append(")");
                        sb.append(numbers.get(2).floatVal().getText());
                        sb.append(")");

                        value = sb.toString();

                    } else{
                        System.out.println("The vector has been declared with a mix of types!");
                        throw new IllegalArgumentException();
                    }

                } else{
                    throw new IllegalArgumentException(); //Cannot happen unless grammar has been changed
                }
            } else if(ctx.vecExpr() != null){

                //TODO parse vector expression

            } else if(ctx.identifier().get(1) != null){ //format: VEC identifier ASSIGN identifier
                //Get the second identifier from the statement and the matching variable
                String otherIdentifier = ctx.identifier().get(1).getText();
                VariableContainer varCon = getValueFromScope(otherIdentifier);

                if(varCon == null){
                    System.out.println("The requested variable has not been declared.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getValue() == null){
                    System.out.println("The requested variable has been declared but not assigned.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getType() != VariableType.VEC){
                    System.out.println("The requested variable does exist, is assigned, but is not a vector."); //TODO This should never happen: we check the value before assigning it.
                    throw new IllegalArgumentException();
                }

                value = TypeCheckerHelper.parseVector(varCon.getValue()).toString();

            } else{
                throw new IllegalArgumentException(); //If this is thrown, the grammar has been changed.
            }
        }else{ //format: VEC identifier
            value = null;
        }

        addVariableToScope(new VariableContainer(identifier, value, VariableType.VEC));
    }

    @Override
    public void exitBoolDcl(Tactic.BoolDclContext ctx) {

        String identifier = ctx.children.get(1).getText();
        String value = null;

        //Is there an assign?
        if(ctx.ASSIGN() != null){ //format: BOOL identifier (ASSIGN (boolStmt | functionCall | identifier))
            if(ctx.boolStmt() != null){ //format: INTEGER identifier ASSIGN boolStmt

                if(ctx.boolStmt().bool() != null){
                    value = ctx.boolStmt().bool().getText();
                }else if(ctx.boolStmt().identifier() != null) {
                    String otherIdentifier = ctx.identifier().get(1).getText();
                    VariableContainer varCon = getValueFromScope(otherIdentifier);

                    if (varCon == null) {
                        System.out.println("The requested variable has not been declared.");
                        throw new IllegalArgumentException();
                    }

                    if (varCon.getValue() == null) {
                        System.out.println("The requested variable has been declared but not assigned.");
                        throw new IllegalArgumentException();
                    }

                    if (varCon.getType() != VariableType.BOOL) {
                        System.out.println("The requested variable does exist, is assigned, but is not a boolean."); //TODO This should never happen: we check the value before assigning it.
                        throw new IllegalArgumentException();
                    }

                    value = TypeCheckerHelper.parseBool(varCon.getValue()).toString();
                } else if(ctx.boolStmt().boolOperaters() != null){

                    //TODO Parse bool statement

                } else {
                    throw new IllegalArgumentException(); //If this is throw, the grammar has changed
                }

            } else if(ctx.identifier().get(1) != null){ //format: BOOL identifier ASSIGN identifier
                //Get the second identifier from the statement and the matching variable
                String otherIdentifier = ctx.identifier().get(1).getText();
                VariableContainer varCon = getValueFromScope(otherIdentifier);

                if(varCon == null){
                    System.out.println("The requested variable has not been declared.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getValue() == null){
                    System.out.println("The requested variable has been declared but not assigned.");
                    throw new IllegalArgumentException();
                }

                if(varCon.getType() != VariableType.BOOL){
                    System.out.println("The requested variable does exist, is assigned, but is not a boolean."); //TODO This should never happen: we check the value before assigning it.
                    throw new IllegalArgumentException();
                }

                value = TypeCheckerHelper.parseBool(varCon.getValue()).toString();

            } else if(ctx.functionCall() != null) {  //format: BOOL identifier ASSIGN functionCall
                value = null; //TODO does we keep functions?
            }else{
                throw new IllegalArgumentException(); //If this is thrown, the grammar has been changed.
            }
        }else{ //format: BOOL identifier
            value = null;
        }

        addVariableToScope(new VariableContainer(identifier, value, VariableType.BOOL));
    }

    @Override
    public void exitStringDcl(Tactic.StringDclContext ctx) {
        super.exitStringDcl(ctx);
    }

    @Override
    public void exitGpDcl(Tactic.GpDclContext ctx) {
        //The GP declaration can only have one format: GamePiece identifier.
        String identifier = ctx.identifier(0).getText();
        addVariableToScope(new VariableContainer(identifier, "name:" + identifier + ",position:,size:,color:,label:,opacity:,shape:,", VariableType.GAMEPIECE));
    }

    @Override
    public void exitArrayDcl(Tactic.ArrayDclContext ctx) {
        super.exitArrayDcl(ctx);
    }

    @Override
    public void exitDotAssignment(Tactic.DotAssignmentContext ctx) {

        String identifier = ctx.dotStmt().identifier().get(0).getText();

        if(!hasBeenInitialized(identifier)){
            System.out.println("Dot assignment is used on a non-initialized variable.");
            throw new IllegalArgumentException();
        }

        VariableContainer variableBeingDotted = getValueFromScope(identifier);

        //This section is triggered when DotAssignment is used on a GamePiece
        if(variableBeingDotted.getType() == VariableType.GAMEPIECE){

            String identifierAfterDot = ctx.dotStmt().identifier().get(1).getText();

            //Parse identifierAfterDot to get the GP property
            GamePiece.GamePiecePropertyType gpPropType = TypeCheckerHelper.parseGamePiecePropertyType(identifierAfterDot);

            if(gpPropType == null){
                System.out.println("A GamePiece is being dotted with a non-GPProperty string");
                throw new IllegalArgumentException();
            }

            //Change the property in the GP (also removed citation-marks if needed)
            String newPropertyValue = trimCitations(ctx.value().getText());
            GamePiece gp = TypeCheckerHelper.parseGamePiece(getValueFromScope(identifier).getValue());
            gp.changeProperty(gpPropType, newPropertyValue);

            //Save the changed GamePiece
            String changedGpValue = gp.getGamePieceString();
            addVariableToScope(new VariableContainer(identifier, changedGpValue, VariableType.GAMEPIECE));
        }
    }

    // ARITHMETIC EXPRESSIONS ------------------------------



}
