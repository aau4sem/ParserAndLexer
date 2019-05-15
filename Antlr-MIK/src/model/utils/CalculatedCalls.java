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

        for (GamePiece piece : gamePieces){
            ArrayList<BuildInFunction> temp = new ArrayList<>();

            for (BuildInFunction moveCall : actionCalls){
                if (moveCall.getGp().getName().compareTo(piece.getName()) == 0) {
                    temp.add(moveCall);
                }
            }

            BuildInFunction previousMove = null;
            BuildInFunction previousChangeColor = null;
            BuildInFunction previousChangeSize = null;

            for (BuildInFunction action : temp){
                int changeTime = action.getTime();

                if (action instanceof BuildInFuctionMove){
                    if (isPrevious(previousMove)){
                        changeTime = action.getTime() - previousMove.getTime();
                    }
                    calculatedCalls.add(new BuildInFuctionMove(action.getGp(), ((BuildInFuctionMove) action).getVector(), changeTime));
                    previousMove = action;
                }

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.COLOR){
                    if (isPrevious(previousChangeColor)){
                        changeTime = action.getTime() - previousChangeColor.getTime();
                    }
                    calculatedCalls.add(new BuildInFunctionChange(action.getGp(), ((BuildInFunctionChange) action).getSecondArgument(), ((BuildInFunctionChange) action).getThridArguemnt(), changeTime));
                    previousChangeColor = action;
                }

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.SIZE){
                    if (isPrevious(previousChangeSize)){
                        changeTime = action.getTime() - previousChangeSize.getTime();
                    }
                    calculatedCalls.add(new BuildInFunctionChange(action.getGp(), ((BuildInFunctionChange) action).getSecondArgument(), ((BuildInFunctionChange) action).getThridArguemnt(), changeTime));
                    previousChangeSize = action;
                }
            }
        }

        return calculatedCalls;
    }

    private static boolean isPrevious (BuildInFunction previous){
        return previous != null;
    }
}
