package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;

/** This class has the responsibility of keeping all data regarding the board. */
public class BoardListener extends TacticBaseListener {

    private String boardPath = "";
    public static String boardKeyword = "Board";

    private VariableCollectorListener vcl;

    public BoardListener(VariableCollectorListener vcl) {
        this.vcl = vcl;
    }

    /** This method will recognize only calls that will effect the board,
     * and save the given data.*/
    @Override
    public void exitAssignment(Tactic.AssignmentContext ctx) {

        String identifier = ctx.identifier().getText();

        if(identifier.compareTo(boardKeyword) == 0){ //format: identifier = "string";

            if(ctx.assignmentRight().value() != null){
                if(ctx.assignmentRight().value().string() != null){
                    boardPath = TypeCheckerHelper.parseString(ctx.assignmentRight().value().getText());
                }else
                    throw new IllegalArgumentException(); //The assignment is a value but not a string
            }else
                throw new IllegalArgumentException(); //Not a value assignment for board path
        }
    }

    public String getBoardPath() {
        return boardPath;
    }

    @Override
    public void enterCondStmt(Tactic.CondStmtContext ctx) {
    }
}
