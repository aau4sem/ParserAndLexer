package model.utils;

public class Argument {

    public enum ArgumentType { IDENTIFIER, INTEGER, FLOAT, BOOL, STRING, VECTOR, GAMEPIECE_PROPERTY}

    private String value;
    private ArgumentType type;

    public Argument(String value, ArgumentType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public ArgumentType getType() {
        return type;
    }
}
