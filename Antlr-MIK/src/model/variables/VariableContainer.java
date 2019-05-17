package model.variables;

import customListeners.VariableCollectorListener.VariableType;

/** This class is used to store variables. */
public class VariableContainer {

    private String identifier;
    private String value;
    private VariableType type;
    private boolean isArray = false;

    public VariableContainer(String identifier, String value, VariableType type) {
        this.identifier = identifier;
        this.value = value;
        this.type = type;
    }

    public VariableContainer(String identifier, String value, VariableType type, boolean isArray) {
        this.identifier = identifier;
        this.value = value;
        this.type = type;
        this.isArray = isArray;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getValue() {
        return value;
    }

    public void overwriteValue(String value) {
        this.value = value;
    }

    public VariableType getType() {
        return type;
    }

    public boolean isArray() {
        return isArray;
    }
}
