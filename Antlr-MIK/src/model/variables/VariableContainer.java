package model.variables;

import customListeners.VariableCollectorListener.VariableType;

/** This class is used to store variables. */
public class VariableContainer {

    private String identifier;
    private String value;
    private VariableType type;

    public VariableContainer(String identifier, String value, VariableType type) {
        this.identifier = identifier;
        this.value = value;
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getValue() {
        return value;
    }

    public VariableType getType() {
        return type;
    }
}
