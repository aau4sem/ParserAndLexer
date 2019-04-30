package CustomListeners;

import model.variables.VariableContainer2;
import model.variables.VariableScopeData2;

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

    private VariableScopeData2 mainScope = new VariableScopeData2(VariableScopeData2.ScopeType.MAIN_SCOPE);
    private VariableScopeData2 functionScope = new VariableScopeData2(VariableScopeData2.ScopeType.FUNCTION_SCOPE);

    private VariableScopeData2.ScopeType currentScope = VariableScopeData2.ScopeType.MAIN_SCOPE;

    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}


    // PRIVATE METHODS ----------------------------------------------
    /** Used to add variables to the current scope.
     * @param type the type of the given variable.
     * @param varCon variable container, containing the value of the variable. */
    private void addVariableToScope(VariableType type, VariableContainer2 varCon){
        if(currentScope == VariableScopeData2.ScopeType.MAIN_SCOPE){
            mainScope.addVariable(varCon);
        }else{
            functionScope.addVariable(varCon);
        }
    }


    // PUBLIC METHODS ------------------------------------------------

    /** Used to get a value from an identifier. */
    /*public T getValueFromIdentifier(){
        //TODO
    }*/

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
        this.currentScope = VariableScopeData2.ScopeType.FUNCTION_SCOPE;
    }

    /** When exiting a function definition the scope is changed back to MAIN_SCOPE,
     * and the saved variables for the function scope is removed. */
    @Override
    public void exitFunctionDef(Tactic.FunctionDefContext ctx) {
        this.currentScope = VariableScopeData2.ScopeType.MAIN_SCOPE;
        //Reset the function scope
        this.functionScope = new VariableScopeData2(VariableScopeData2.ScopeType.FUNCTION_SCOPE);
    }

    // Declarations:
    @Override
    public void exitIntDcl(Tactic.IntDclContext ctx) {
        String identifier = ctx.identifier().toString();
        //number | arithExpr | identifier

        String value;

        //Is there an assign?
        if(ctx.ASSIGN() != null){ //format: INTEGER identifier ASSIGN (number | arithExpr | identifier)
            if(ctx.number() != null)
                value = ctx.number().getText();
            else if(ctx.identifier().get(1) != null)
                value = ctx.identifier().get(1).getText();
            //else if(ctx.arithExpr().) //TODO
            else
                throw new IllegalArgumentException();


        }else{ //format: INTEGER identifier
            value = null;
        }

        addVariableToScope(VariableType.INT, new VariableContainer2(identifier, value, VariableType.INT));
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

    @Override
    public void exitGpDcl(Tactic.GpDclContext ctx) {
        super.exitGpDcl(ctx);
    }

    @Override
    public void exitArrayDcl(Tactic.ArrayDclContext ctx) {
        super.exitArrayDcl(ctx);
    }
}
