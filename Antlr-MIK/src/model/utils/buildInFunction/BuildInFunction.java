package model.utils.buildInFunction;

import model.dataTypes.GamePiece;

/** This interface is implemented by the three classes modeling the three action calls.*/
public interface BuildInFunction {

    GamePiece getGp();
    Integer getTime();
    String toKeyframe();
    void setTime(Integer time); //TODO Remove? Ali?
    BuildInFunction clone();
    String getIdentifier();
}
