package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

/** This class is used to model and store information about the action-call Move. */
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

    public BuildInFunction clone(){
        return new BuildInFunctionMove(this.gp, this.vector, this.time);
    }
}
