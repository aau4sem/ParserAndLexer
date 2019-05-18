package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;

public class BuildInFunctionChange implements BuildInFunction {

    public static String identifier = "Change";

    private GamePiece gp;
    private GamePiece.GamePiecePropertyType gpPropperty;
    private String thridArguemnt; //TODO rename //TODO Handle when implemented in the grammar
    private Integer time;

    public BuildInFunctionChange(GamePiece gp, GamePiece.GamePiecePropertyType gpPropperty, String thridArguemnt, Integer time) {
        this.gp = gp;
        this.gpPropperty = gpPropperty;
        this.thridArguemnt = thridArguemnt;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public GamePiece.GamePiecePropertyType getSecondArgument() {
        return gpPropperty;
    }

    public String getThridArguemnt() {
        return thridArguemnt;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer newTime) {
        this.time = newTime;
    }

    public String toKeyframe() {
        switch (this.gpPropperty) {
            case POSITION:

                String test[] = this.thridArguemnt.split("\\D+");
                int x = Integer.parseInt(test[1]);
                int y = Integer.parseInt(test[2]);

                return "left: " + x + ", top: " + y + ", duration: 1, delay: " + time;
            default:
                return "value: '" + thridArguemnt + "', duration: 1, delay: " + time;
        }
    }

    private boolean isVisible(Vector vector) {
        return vector.getZ() == 0;
    }

    public String getIdentifier() {
        return identifier;
    }
}
