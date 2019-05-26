package model.utils;

import customListeners.VariableCollectorListener;

/** This class is used to model and store an Argument from a procedure call. */
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

    /** @return the VariableType matching this class' ArgumentType. */
    public VariableCollectorListener.VariableType getMatchingVariableType(){
        switch (type){
            case STRING: return VariableCollectorListener.VariableType.STRING;
            case BOOL: return VariableCollectorListener.VariableType.BOOL;
            case VECTOR: return VariableCollectorListener.VariableType.VEC;
            case FLOAT: return VariableCollectorListener.VariableType.FLOAT;
            case INTEGER: return VariableCollectorListener.VariableType.INT;
        }

        System.out.println("Converting ArgumentType to VariableType: Identifier and GamePiece_Property cannot be converted.");
        throw new IllegalArgumentException();
    }
}