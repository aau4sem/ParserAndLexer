package model.utils;

import customListeners.VariableCollectorListener;

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
