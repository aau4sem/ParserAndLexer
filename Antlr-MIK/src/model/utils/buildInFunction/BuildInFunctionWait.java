package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public class BuildInFunctionWait implements BuildInFunction {

    public static String identifier = "Wait";

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
        return "duration: " + time;
    }

    public String getIdentifier() {
        return identifier;
    }
}
