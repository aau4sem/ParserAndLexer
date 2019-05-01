package model.variables;

import java.util.HashMap;

/** This class will contain information of variables for a given scope. */
public class VariableScopeData {

    public enum ScopeType {MAIN_SCOPE, FUNCTION_SCOPE }

    private ScopeType type;
    private String functionIdentifier = null; //TODO Is this needed?

    //A map that maps identifiers of variables to a container that hold their value.
    private HashMap<String, VariableContainer> variables = new HashMap<>();

    public VariableScopeData(ScopeType type) {
        this.type = type;
    }

    public VariableScopeData(ScopeType type, String functionIdentifier) {
        this.type = type;
        this.functionIdentifier = functionIdentifier;
    }

    /** Used to add a variable to this scope. */
    public void addVariable(VariableContainer varCon){
        variables.put(varCon.getIdentifier(), varCon);
    }

    /** Used to get a variable from this scope. Returns null
     * if the quested variable does not exist.  */
    public VariableContainer getVariable(String identifier){
        return variables.get(identifier);
    }

    public ScopeType getType() {
        return type;
    }

    public String getFunctionIdentifier() {
        return functionIdentifier;
    }
}
