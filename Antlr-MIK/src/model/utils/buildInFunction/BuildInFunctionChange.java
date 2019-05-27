package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

/** This class is used to model and store information about the action-call Change. */
public class BuildInFunctionChange implements BuildInFunction {

    public static String identifier = "Change";

    private GamePiece gp;
    private GamePiece.GamePiecePropertyType gpProperty;
    private String thirdArgument;
    private Integer time;

    public BuildInFunctionChange(GamePiece gp, GamePiece.GamePiecePropertyType gpProperty, String thirdArgument, Integer time) {
        this.gp = gp;
        this.gpProperty = gpProperty;
        this.thirdArgument = thirdArgument;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public GamePiece.GamePiecePropertyType getSecondArgument() {
        return gpProperty;
    }

    public String getThirdArgument() {
        return thirdArgument;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer newTime) {
        this.time = newTime;
    }

    public String toKeyframe() {
        switch (this.gpProperty) {
            case POSITION:

                String test[] = this.thirdArgument.split("\\D+");
                int x = Integer.parseInt(test[1]);
                int y = Integer.parseInt(test[2]);

                return "left: " + x + ", top: " + y + ", duration: 1, delay: " + time;
            default:
                return "value: '" + thirdArgument + "', duration: 1, delay: " + time;
        }
    }

    private boolean isVisible(Vector vector) {
        return vector.getZ() == 0;
    }

    public String getIdentifier() {
        return identifier;
    }

    public BuildInFunction clone(){
        return new BuildInFunctionChange(this.gp, this.gpProperty, this.thirdArgument, this.time);
    }
}