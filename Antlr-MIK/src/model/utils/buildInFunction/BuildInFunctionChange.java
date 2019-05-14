package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public class BuildInFunctionChange implements BuildInFunction {

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
        // TODO - Create this - Format:
        // 'background-color': '#FFF', delay: 250

        switch (this.gpPropperty){
            case COLOR:
                return "'background-" + this.gpPropperty.getString().toLowerCase() + "': '" + this.thridArguemnt + "'";
        }

        return null;
    }
}
