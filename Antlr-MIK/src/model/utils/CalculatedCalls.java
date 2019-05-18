package model.utils;

import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunctionWait;

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
            BuildInFunction previousChangeOpacity = null;

            for (BuildInFunction action : temp){
                int changeTime = action.getTime();

                if (action instanceof BuildInFunctionMove || action instanceof BuildInFunctionWait || (action instanceof BuildInFunctionChange && (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.POSITION))){
                    if (isPrevious(previousMove)){
                        changeTime = action.getTime() - previousMove.getTime();
                    }

                    if (action instanceof BuildInFunctionMove){
                        calculatedCalls.add(new BuildInFunctionMove(action.getGp(), ((BuildInFunctionMove) action).getVector(), changeTime));
                    } else if (action instanceof BuildInFunctionWait){
                        calculatedCalls.add(new BuildInFunctionWait(action.getGp(), changeTime));
                    } else if (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.POSITION){
                        calculatedCalls.add(new BuildInFunctionChange(action.getGp(), ((BuildInFunctionChange) action).getSecondArgument(), ((BuildInFunctionChange) action).getThridArguemnt(), changeTime));
                    }

                    if (!(action instanceof BuildInFunctionChange)){
                        previousMove = action;
                    }
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

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.OPACITY){
                    if (isPrevious(previousChangeOpacity)){
                        changeTime = action.getTime() - previousChangeOpacity.getTime();
                    }
                    calculatedCalls.add(new BuildInFunctionChange(action.getGp(), ((BuildInFunctionChange) action).getSecondArgument(), ((BuildInFunctionChange) action).getThridArguemnt(), changeTime));
                    previousChangeOpacity = action;
                }
            }
        }

        return calculatedCalls;
    }

    private static boolean isPrevious (BuildInFunction previous){
        return previous != null;
    }
}
