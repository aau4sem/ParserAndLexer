package model.Utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

public class BuildInFuctionMove implements BuildInFunction {

    private GamePiece gp;
    private Vector vector;
    private Integer integer;

    public BuildInFuctionMove(GamePiece gp, Vector vector, Integer integer) {
        this.gp = gp;
        this.vector = vector;
        this.integer = integer;
    }

    public GamePiece getGp() {
        return gp;
    }

    public Vector getVector() {
        return vector;
    }

    public Integer getInteger() {
        return integer;
    }
}
