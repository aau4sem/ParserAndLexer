package model.variables;

import customListeners.VariableCollectorListener.VariableType;
import model.dataTypes.Array;
import model.utils.TypeCheckerHelper;

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

    public int getLengthOfarray(){
        if(!isArray){
            System.out.println("You are requesting the length of a variable that is not an array.");
            throw new IllegalArgumentException();
        }

        switch (type){
            case INT: return TypeCheckerHelper.parseIntegerArray(this.getValue()).length;
            case VEC: return TypeCheckerHelper.parseVectorArray(this.getValue()).length;
            case GAMEPIECE: return TypeCheckerHelper.parseGamePieceArray(this.getValue()).length;
            case FLOAT: return TypeCheckerHelper.parseFloatArray(this.getValue()).length;
            case BOOL: return TypeCheckerHelper.parseBooleanArray(this.getValue()).length;
            case STRING: return TypeCheckerHelper.parseStringArray(this.getValue()).length;
        }

        System.out.println("Code has changed. Should not be throw!");
        throw new IllegalArgumentException();
    }
}
