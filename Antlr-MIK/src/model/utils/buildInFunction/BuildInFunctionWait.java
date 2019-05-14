package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public class BuildInFunctionWait implements BuildInFunction {

    private GamePiece gp;
    private Integer time;

    public BuildInFunctionWait(GamePiece gp, Integer time) {
        this.gp = gp;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer newTime) {
        this.time = newTime;
    }

    public String toKeyframe() {
        return "left: " + gp.getPosition().getX() + ", top: " + gp.getPosition().getY() + ", duration: " + time;
    }
}
