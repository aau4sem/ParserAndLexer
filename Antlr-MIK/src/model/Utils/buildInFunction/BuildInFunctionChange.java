package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public class BuildInFunctionChange implements BuildInFunction {

    private GamePiece gp;
    private GamePiece.GamePiecePropertyType gpPropperty;
    private String thridArguemnt; //TODO rename //TODO Handle when implemented in the grammar
    private Number time;

    public BuildInFunctionChange(GamePiece gp, GamePiece.GamePiecePropertyType gpPropperty, String thridArguemnt, Number time) {
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

    public Number getTime() {
        return time;
    }
}
