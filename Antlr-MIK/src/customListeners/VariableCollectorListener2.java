package customListeners;

import gen.TacticBaseListener;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;

/** This class will collect and handle variables during parsing.
 * The idea is that during the pass, this class will contain a
 * model with the current state of variables, and other classes
 * and listeners will request this class for information regarding
 * variables. */
public class VariableCollectorListener2 extends TacticBaseListener {

    //Two variableScopeData to keep track of variable declarations in the main and function scope
    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.ScopeType.MAIN_SCOPE);
    private VariableScopeData procedureScope = new VariableScopeData(VariableScopeData.ScopeType.PROCEDURE_SCOPE); //TODO Should be used to store the parameters when entering a procedure call?

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
            procedureScope.addVariable(varCon);
        }
    }

    /** used to overwrite a value of a variable in the current scope.
     * @param val the new value that will be used to overwrite the old one.
     * @param identifier the identifier of the variable to overwrite. */
    private void overwriteValueOfVariable(String identifier, String val){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            mainScope.overwriteValueOfVariable(identifier, val);
        else
            procedureScope.overwriteValueOfVariable(identifier, val);
    }

    /** Used to get variables from the current scope. If the current scope
     * is procedure scope, and ff the variable is not found in the function
     * scope, it will then search the main scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    private VariableContainer getValueFromScope(String identifier){

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


}
