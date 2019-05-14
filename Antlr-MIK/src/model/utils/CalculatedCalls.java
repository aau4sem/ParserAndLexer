package model.utils;

import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFuctionMove;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;

import java.util.ArrayList;

// TODO: Måske findes der en liiiiiidt nemmere metode end at have tre for each løkker.

public class CalculatedCalls {
    public static ArrayList<BuildInFunction> calculate(ArrayList<BuildInFunction> actionCalls, ArrayList<GamePiece> gamePieces) {
        ArrayList<BuildInFunction> calculatedCalls = new ArrayList<>();

        for (GamePiece piece : gamePieces) {
            ArrayList<BuildInFunction> temp = new ArrayList<>();

            for (BuildInFunction call : actionCalls) {
                if (call.getGp().getName().compareTo(piece.getName()) == 0) {
                    temp.add(call);
                }
            }

            BuildInFunction previous = null;

            for (BuildInFunction action : temp) {
                int changetime = action.getTime();

                if (previous != null) {
                    changetime = action.getTime() - previous.getTime();
                }

                if(action instanceof BuildInFuctionMove)
                    calculatedCalls.add(new BuildInFuctionMove(action.getGp(), ((BuildInFuctionMove) action).getVector(), changetime));

                if(action instanceof BuildInFunctionChange)
                    calculatedCalls.add(new BuildInFunctionChange(action.getGp(), ((BuildInFunctionChange) action).getSecondArgument(), ((BuildInFunctionChange) action).getThridArguemnt(), changetime));

                previous = action;
            }
        }


        return calculatedCalls;
    }
}
