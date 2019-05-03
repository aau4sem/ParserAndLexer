package model.variables;

import customListeners.VariableCollectorListener;

import java.util.ArrayList;
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

    /** @return all variables of the given type.*/
    public ArrayList<VariableContainer> getAllVariablesOfType(VariableCollectorListener.VariableType type){

        ArrayList<VariableContainer> collectedVariables = new ArrayList<>();

        for(VariableContainer varCon : variables.values())
            if(varCon.getType() == type)
                collectedVariables.add(varCon);
        return collectedVariables;
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
