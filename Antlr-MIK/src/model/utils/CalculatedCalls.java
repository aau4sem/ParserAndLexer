package model.utils;

import model.dataTypes.GamePiece;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunctionWait;

import java.util.ArrayList;

// TODO: Måske findes der en liiiiiidt nemmere metode end at have tre for each løkker.

/**
 * This class is used to calculate the duration of actions in order to correspond to the AnimeJS library.
 */
public class CalculatedCalls {

    /**
     * This method calculates every action to a duration based on the previous actions time and its own.'
     * To calculate the duration the formula: (previous_action_time - current_action_time = duration) is used.
     *
     * @param allActions A list of all actions.
     * @param gamePieces A list of all GamePieces.
     * @return A list of all actions in which the time has been changed to a duration accordingly.
     */
    public static ArrayList<BuildInFunction> calculate(ArrayList<BuildInFunction> allActions, ArrayList<GamePiece> gamePieces) {
        // A list is created in which all calculated actions will be added to.
        ArrayList<BuildInFunction> calculatedActions = new ArrayList<>();

        /* An action is associated with a GamePiece, therefore in order to find the previous action we need to
           iterate through GamePieces one at a time. */
        for (GamePiece piece : gamePieces) {
            // A temporary list is created in which all actions of a GamePiece is added.
            ArrayList<BuildInFunction> gamepieceActions = new ArrayList<>();

            for (BuildInFunction action : allActions) {
                if (action.getGp().getName().compareTo(piece.getName()) == 0) {
                    gamepieceActions.add(action);
                }
            }

            /* A number of null variables are created and used to determine if there has been a previous action */
            BuildInFunction previousMoveOrPosition = null;
            BuildInFunction previousChangeColor = null;
            BuildInFunction previousChangeSize = null;
            BuildInFunction previousChangeOpacity = null;

            for (BuildInFunction action : gamepieceActions) {
                // In case there is no previous action it will keep the same time as its duration, hence the default value.
                int changeTime = action.getTime();

                /* Some actions are required to be compared to each other, which is why the many if statements that has similar code. */

                if (action instanceof BuildInFunctionMove || action instanceof BuildInFunctionWait || (action instanceof BuildInFunctionChange && (((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.POSITION))) {
                    // Check if the current action is the first one. If it's not we calculate the duration.
                    if (isPrevious(previousMoveOrPosition)) {
                        changeTime = action.getTime() - previousMoveOrPosition.getTime();
                    }

                    /* We create a copy of the action to use for next iteration. Then the time of the action is changed
                       to the duration calculated and added to the list of calculated actions. */
                    previousMoveOrPosition = action.clone();
                    action.setTime(changeTime);
                    calculatedActions.add(action);
                }

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.COLOR) {
                    if (isPrevious(previousChangeColor)) {
                        changeTime = action.getTime() - previousChangeColor.getTime();
                    }

                    previousChangeColor = action.clone();
                    action.setTime(changeTime);
                    calculatedActions.add(action);
                }

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.SIZE) {
                    if (isPrevious(previousChangeSize)) {
                        changeTime = action.getTime() - previousChangeSize.getTime();
                    }

                    previousChangeSize = action.clone();
                    action.setTime(changeTime);
                    calculatedActions.add(action);
                }

                if (action instanceof BuildInFunctionChange && ((BuildInFunctionChange) action).getSecondArgument() == GamePiece.GamePiecePropertyType.OPACITY) {
                    if (isPrevious(previousChangeOpacity)) {
                        changeTime = action.getTime() - previousChangeOpacity.getTime();
                    }

                    previousChangeOpacity = action.clone();
                    action.setTime(changeTime);
                    calculatedActions.add(action);
                }
            }
        }

        return calculatedActions;
    }

    private static boolean isPrevious(BuildInFunction previous) {
        return previous != null;
    }
}
