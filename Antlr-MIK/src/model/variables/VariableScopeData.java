package model.variables;

import customListeners.VariableCollectorListener;

import java.util.ArrayList;
import java.util.HashMap;

/** This class will contain information of the main scope. */
public class VariableScopeData {

    //A map that maps identifiers of variables to a container that hold their value.
    private HashMap<String, VariableContainer> variables = new HashMap<>();

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

    /** Overwrites the value of the variable matching the given identifier.
     * @param identifier the identifier of the value to overwrite.
     * @param val the new value to overwrite with. */
    public void overwriteValueOfVariable(String identifier, String val){
        VariableContainer varCon = variables.get(identifier);
        varCon.overwriteValue(val);
        variables.put(identifier, varCon);
    }

    /** Used to get a variable from this scope. Returns null
     * if the quested variable does not exist.  */
    public VariableContainer getVariable(String identifier){
        return variables.get(identifier);
    }
}
