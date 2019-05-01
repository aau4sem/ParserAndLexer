package model.variables;

import java.util.HashMap;

//Is the variable in a function (which) or in the main scope
public class VariableScopeData {

    public enum Scope {MAIN_SCOPE, FUNCTION_SCOPE; }

    private Scope scope;
    private String function = null; //TODO should contain information of the functions if in FunctionScope

    private HashMap<String, VariableContainer> variables = new HashMap<>();

    public VariableScopeData(Scope scope) {
        this.scope = scope;
    }

    /** Adds a variable to the Map. //TODO should be expanded. */
    public void addVariable(VariableContainer varCon){
        variables.put(varCon.getIdentifier(), varCon);
    }
}
