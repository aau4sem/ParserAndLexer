package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

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

    public String toKeyframe() {
        return "left: " + gp.getPosition().getX() + ", top: " + gp.getPosition().getY() + ", duration: " + time.getIntValue();
    }
}
