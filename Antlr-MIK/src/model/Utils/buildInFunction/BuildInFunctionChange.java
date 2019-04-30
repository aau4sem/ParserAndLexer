package model.Utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;

public class BuildInFunctionChange implements BuildInFunction {

    private GamePiece gp;
    private String secondArgument; //TODO rename
    private String thridArguemnt; //TODO rename
    private Number time; //TODO How to handle??

    public BuildInFunctionChange(GamePiece gp, String secondArgument, String thridArguemnt, Number time) {
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

    public Number getTime() {
        return time;
    }
}
