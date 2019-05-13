package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public interface BuildInFunction {

    public GamePiece getGp();
    public Number getTime();
    public String toKeyframe();

}
