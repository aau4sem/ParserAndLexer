package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.TypeCheckerHelper;

/** This class has the responsibility of keeping and collecting all data regarding the board. */
public class BoardListener extends TacticBaseListener {

    private String boardPath = "";
    private static String boardKeyword = "Board";

    /** This method will recognize only calls that will effect the board,
     * and save the given string.*/
    @Override
    public void exitAssignment(Tactic.AssignmentContext ctx) {

        String identifier = ctx.identifier().getText();

        if(identifier.compareTo(boardKeyword) == 0){ //format: identifier = "string";

            if(ctx.assignmentRight().value() != null){
                if(ctx.assignmentRight().value().string() != null){
                    boardPath = TypeCheckerHelper.parseString(ctx.assignmentRight().value().getText());
                }else{
                    System.out.println("Board path assignment: The assigned value is not a string.");
                    throw new IllegalArgumentException();
                }
            }else{
                System.out.println("A board assignment is not being assigned the correct value. Should be Board = \"string\"");
                throw new IllegalArgumentException();
            }
        }
    }

    public String getBoardPath() {
        return boardPath;
    }

    @Override
    public void enterCondStmt(Tactic.CondStmtContext ctx) {
    }
}
