package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.dataTypes.Number;

public class BuildInFunctionMove implements BuildInFunction {

    public static String identifier = "Move";

    private GamePiece gp;
    private Vector vector;
    private Integer time;

    public BuildInFunctionMove(GamePiece gp, Vector vector, Integer time) {
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer newTime) {
        this.time = newTime;
    }

    public String toKeyframe() {
            return "left: " + vector.getX() + ", top: " + vector.getY() + ", duration: " + time;
        }

    public String getIdentifier() {
        return identifier;
    }
}
