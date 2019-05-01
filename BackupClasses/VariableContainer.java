package model.variables;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

public class VariableContainer {

    /** This call will be used to store ONE variable, with the necessary data. It can only*/

    private String identifier;

    private Integer intVal;
    private Float floatVal;
    private String stringVal;
    private Boolean boolVal;
    private Vector vectorVal;
    private GamePiece gamePieceVal;
    //ARray?

    public VariableContainer(Integer intVal) {
        this.intVal = intVal;
    }

    public VariableContainer(Float floatVal) {
        this.floatVal = floatVal;
    }

    public VariableContainer(String stringVal) {
        this.stringVal = stringVal;
    }

    public VariableContainer(Boolean boolVal) {
        this.boolVal = boolVal;
    }

    public VariableContainer(Vector vectorVal) {
        this.vectorVal = vectorVal;
    }

    public VariableContainer(GamePiece gamePieceVal) {
        this.gamePieceVal = gamePieceVal;
    }

    public String getIdentifier() {
        return identifier;
    }
}
