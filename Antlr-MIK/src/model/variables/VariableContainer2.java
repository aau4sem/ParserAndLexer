package model.variables;

import CustomListeners.VariableCollectorListener.VariableType;

/** This class is used to store variables. */
public class VariableContainer2 {

    private String identifier;
    private String value; //TODO Can it be saved like this?
    private VariableType type;

    public VariableContainer2(String identifier, String value, VariableType type) {
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
