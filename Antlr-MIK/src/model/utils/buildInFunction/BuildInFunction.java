package model.utils.buildInFunction;

import model.dataTypes.GamePiece;
import model.dataTypes.Number;

public interface BuildInFunction {

    GamePiece getGp();
    Integer getTime();
    String toKeyframe();
    void setTime(Integer time);
    String getIdentifier();
}
