package customListeners;

import model.utils.ArithmeticResultHolder;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;

import gen.*;

public class VariableCollectorListener extends TacticBaseListener {

    /** This class will collect and handle variables during parsing.
     * The idea is that during the pass, this class will contain a
     * model with the current state of variables, and other classes
     * and listeners will request this class for information regarding
     * variables. */

    /** This listener should overwrite all / implement all method
     * regarding declarations. */

    /** TODO / Throughts
     * Fields:
     *  - mainScope - Used when in the mainScope.
     *  - functionScope - Only contains one scope. Being used when
     *                    entering a function and will be reset when
     *                    exiting a function. Should be searched before
     *                    mainScope, at all times.
     *  - Scope currentScope - Used to keep track of the current scope.
     *
     * private methods:
     *  - findVariableFromIdentifier - Searches first the function scope
     *                    for a value matching the identifier, then the
     *                    mainScope. If non is found, return null.
     *
     * public methods:
     *  - .. - Used to request a value from an identifier. Will return
     *         null if value was not found.
     *  - getTypeFromIdentifier - Used to get a type from an identifier.
     *
     * Overwrites: (Everything regarding declarations and entering and exiting functions)
     * */

    /** Things to remember during implementation:
     * - Entering / exiting a scope. */

    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.ScopeType.MAIN_SCOPE);
    private VariableScopeData functionScope = new VariableScopeData(VariableScopeData.ScopeType.FUNCTION_SCOPE);

    private VariableScopeData.ScopeType currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;

    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}


    // PRIVATE METHODS ----------------------------------------------
    /** Used to add variables to the current scope.
     * @param type the type of the given variable.
     * @param varCon variable container, containing the value of the variable. */
    private void addVariableToScope(VariableType type, VariableContainer varCon){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE){
            mainScope.addVariable(varCon);
        }else{
            functionScope.addVariable(varCon);
        }
    }

    /** Used to get variables from the current scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    private VariableContainer getValueFromScope(String identifier){

        VariableContainer varCon = null;

        //Get VariableContainer from the current scope
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            varCon = mainScope.getVariable(identifier);
        else
            varCon = functionScope.getVariable(identifier);

        return varCon;
    }

    private String getValueFromArithmeticExpr(String todoTemp){
        return null;
    }

    // PUBLIC METHODS ------------------------------------------------

    /** Used to get a value from an identifier. */
    public VariableContainer getValueFromIdentifier(String identifier){
        return getValueFromScope(identifier);
    }

    /** Used to get a type from an identifier. */
    public VariableType getTypeFromIdentifier(){
        //TODO

        return null;
    }

    // OVERWRITES ----------------------------------------------------

    // Enter and exit function bodies:
    /** When entering a function, the current scope is changed. */
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
            }
            else if(ctx.identifier().get(1) != null){ //format: INTEGER identifier ASSIGN identifier
                String otherIdentifier = ctx.identifier().get(1).getText(); //Get the second identifier from the statement
                VariableContainer varCon = getValueFromScope(otherIdentifier);

                //value = getValueFromScope(otherIdentifier); //Get the value from

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
            } else if(ctx.arithExpr() != null) //format: INTEGER identifier ASSIGN arithExpr
                value = getValueFromArithmeticExpr(""); //TODO TEMP
            else
                throw new IllegalArgumentException(); //If this is thrown, the grammar has been changed.

        }else{ //format: INTEGER identifier
            value = null;
        }

        addVariableToScope(VariableType.INT, new VariableContainer(identifier, value, VariableType.INT));
    }

    @Override
    public void exitFloatDcl(Tactic.FloatDclContext ctx) {
        super.exitFloatDcl(ctx);
    }

    @Override
    public void exitVecDcl(Tactic.VecDclContext ctx) {
        super.exitVecDcl(ctx);
    }

    @Override
    public void exitBoolDcl(Tactic.BoolDclContext ctx) {
        super.exitBoolDcl(ctx);
    }

    @Override
    public void exitStringDcl(Tactic.StringDclContext ctx) {
        super.exitStringDcl(ctx);
    }

    /** The GP declaration can only have one format: GamePiece identifier.*/
    @Override
    public void exitGpDcl(Tactic.GpDclContext ctx) {
        String identifier = ctx.identifier().getText();
        addVariableToScope(VariableType.GAMEPIECE, new VariableContainer(identifier, null, VariableType.GAMEPIECE));
    }

    @Override
    public void exitArrayDcl(Tactic.ArrayDclContext ctx) {
        super.exitArrayDcl(ctx);
    }

    // Arithmetic expression evaluation

    @Override
    public void exitArithExpr(Tactic.ArithExprContext ctx) {
        ctx.addChild(new ArithmeticResultHolder());
    }
}
