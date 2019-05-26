package model.utils;

import customListeners.VariableCollectorListener;

/** Used to model and store information of a parameter for a procedure definition. */
public class Parameter {

    private VariableCollectorListener.VariableType type;
    private String identifier;

    public Parameter(VariableCollectorListener.VariableType type, String identifier) {
        this.type = type;
        this.identifier = identifier;
    }

    public VariableCollectorListener.VariableType getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }
}
