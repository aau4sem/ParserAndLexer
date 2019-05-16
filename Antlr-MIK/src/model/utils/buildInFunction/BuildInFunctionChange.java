package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

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
        // TODO - Create this - Format:
        // 'background-color': '#FFF', delay: 250
        // value: 'rgb(0,0,255)', duration: 1, delay: 750
/*
        switch (this.gpPropperty) {
            case COLOR:
                return "value: '" + getThridArguemnt() + "', duration: 1, delay: " + getTime();
            case SIZE:
                return "value: '" + getThridArguemnt() + "', duration: 1, delay: " + getTime();
        }
        */
        return "value: '" + getThridArguemnt() + "', duration: 1, delay: " + getTime();
    }

    public String getIdentifier() {
        return identifier;
    }
}
