package model.Utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;

public class BuildInFunctionChange implements BuildInFunction {

    private GamePiece gp;
    private String secondArgument; //TODO rename //TODO Handle when implemented in the grammar
    private String thridArguemnt; //TODO rename //TODO Handle when implemented in the grammar
    private Number time;

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
