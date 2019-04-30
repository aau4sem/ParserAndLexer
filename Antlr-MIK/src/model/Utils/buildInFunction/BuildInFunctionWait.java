package model.Utils.buildInFunction;

import model.dataTypes.GamePiece;

public class BuildInFunctionWait implements BuildInFunction {

    private GamePiece gp;
    private Number time;

    public BuildInFunctionWait(GamePiece gp, Number time) {
        this.gp = gp;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public Number getTime() {
        return time;
    }
}
