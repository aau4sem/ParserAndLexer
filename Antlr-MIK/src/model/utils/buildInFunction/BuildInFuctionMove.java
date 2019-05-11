package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.dataTypes.Number;

public class BuildInFuctionMove implements BuildInFunction {

    private GamePiece gp;
    private Vector vector;
    private Number time;

    public BuildInFuctionMove(GamePiece gp, Vector vector, Number time) {
        this.gp = gp;
        this.vector = vector;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public Vector getVector() {
        return vector;
    }

    public Number getTime() {
        return time;
    }
}
