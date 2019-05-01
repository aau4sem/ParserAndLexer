package model.utils;

public class Argument {

    public enum ArguemntType { IDENTIFIER, NUMBER, BOOL, STRING, VECTOR}

    private String value;
    private ArguemntType type;

    public Argument(String value, ArguemntType type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public ArguemntType getType() {
        return type;
    }
}
