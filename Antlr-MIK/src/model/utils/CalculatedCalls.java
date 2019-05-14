package model.utils;

import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFuctionMove;
import model.utils.buildInFunction.BuildInFunction;

import java.util.ArrayList;

public class CalculatedCalls {
    public static ArrayList<BuildInFunction> calculate(ArrayList<BuildInFunction> actionCalls, ArrayList<GamePiece> gamePieces){
        ArrayList<BuildInFunction> calculatedCalls = new ArrayList<>();

        for (GamePiece piece : gamePieces){
            ArrayList<BuildInFunction> temp = new ArrayList<>();

            for (BuildInFunction call : actionCalls){
                if (call.getGp().getName().compareTo(piece.getName()) == 0) {
                    temp.add(call);
                }
            }

            BuildInFunction previous = null;

            for (BuildInFunction action : temp){
                if (action instanceof BuildInFuctionMove){
                    if (previous == null){
                        previous = action;
                        calculatedCalls.add(action);
                    } else {
                        //((BuildInFuctionMove) action).setTime(action.getTime() - previous.getTime());
                    }
                }
            }
        }


        return null;
    }
}
