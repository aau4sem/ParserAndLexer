package model.Utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;

public class BuildInFunctionChange {

    private GamePiece gp;
    private String secondArgument; //TODO rename
    private String thridArguemnt; //TODO rename
    private String time; //TODO How to handle??

    public BuildInFunctionChange(GamePiece gp, String secondArgument, String thridArguemnt, String time) {
        this.gp = gp;
        this.secondArgument = secondArgument;
        this.thridArguemnt = thridArguemnt;
        this.time = time;
    }

    public GamePiece getGp() {
        return gp;
    }

    public String getSecondArgument() {
        return secondArgument;
    }

    public String getThridArguemnt() {
        return thridArguemnt;
    }

    public String getTime() {
        return time;
    }
}
