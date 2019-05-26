package model;

import customListeners.VariableCollectorListener;
import exceptions.GrammarHasChangedException;
import gen.Tactic;
import model.utils.Parameter;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class Procedure {

    private ArrayList<Parameter> parameters;
    private ArrayList<Tactic.ProcedureStmtContext> statements;
    private String prodecureName;
    private VariableCollectorListener vcl;

    public Procedure(ArrayList<Parameter> parameters, ArrayList<Tactic.ProcedureStmtContext> statements, String procedureName, VariableCollectorListener vcl) {
        this.parameters = parameters;
        this.statements = statements;
        this.prodecureName = procedureName;
        this.vcl = vcl;
    }

    public Procedure(String prodecureName, VariableCollectorListener vcl) {
        this(new ArrayList<>(), new ArrayList<>(), prodecureName, vcl);
    }

    /** Executes the procedure. */
    public void execute(){

        //Run all statements
        runStmts(statements);
    }

    private void runCondStmt(Tactic.CondStmtContext ctx){

        vcl.enterCondStmt(ctx);

        boolean evaluatedBool = vcl.getBoolStmtResult(ctx.ifStmt().boolExpr());

        List<Tactic.StmtContext> condStmts = new ArrayList<>();

        if(evaluatedBool){
            condStmts = ctx.ifStmt().block().stmt();
        }else{
            if(ctx.elseStmt() != null)
                condStmts = ctx.elseStmt().block().stmt();
        }

        if(condStmts.size() == 0)
            return; //No statements to run

        for(Tactic.StmtContext stmtCtx : condStmts){

            if(stmtCtx.action() != null){
                System.out.println("You cannot make an action call inside a procedure!");
                throw new IllegalArgumentException();
            }


            if(ctx.children.get(0) instanceof Tactic.AssignmentContext){
                if(((Tactic.AssignmentContext)ctx.children.get(0)).assignmentRight().arithExpr() != null){

                    //TODO Manual work the children and call needed methods????
                    manualArithExprWalker(((Tactic.AssignmentContext)ctx.children.get(0)).assignmentRight().arithExpr());

                }

            }

            runStmt(ctx.children.get(0));
        }

        vcl.exitCondStmt(ctx);
    }

    private void runStmts(List<Tactic.ProcedureStmtContext> stmts){
        for(Tactic.ProcedureStmtContext ctx : stmts) {

            //TODO Does the stmt have arithmetics? If yes, start gathering
            if(ctx.children.get(0) instanceof Tactic.AssignmentContext){
                if(((Tactic.AssignmentContext)ctx.children.get(0)).assignmentRight().arithExpr() != null){

                    //TODO Manual work the children and call needed methods????
                    manualArithExprWalker(((Tactic.AssignmentContext)ctx.children.get(0)).assignmentRight().arithExpr());

                }

            }

            runStmt(ctx.children.get(0));
        }
    }

    public void runStmt(ParseTree ctx){
        if (ctx instanceof Tactic.AssignmentContext) {
            vcl.exitAssignment((Tactic.AssignmentContext) ctx);
        } else if (ctx instanceof Tactic.WhileStmtContext) {
            throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
        } else if (ctx instanceof Tactic.CondStmtContext) {
            runCondStmt((Tactic.CondStmtContext) ctx);
        } else if (ctx instanceof Tactic.ProcedureCallContext) {
            vcl.exitProcedureCall((Tactic.ProcedureCallContext) ctx); //TODO The current implementation does not support procedure calls inside other procedures.
            throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
        } else if (ctx instanceof Tactic.ArrayAssignContext) {
            throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
        } else if (ctx instanceof Tactic.DotAssignmentContext) {
            vcl.exitDotAssignment((Tactic.DotAssignmentContext) ctx);
            //throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
        } else if (ctx instanceof Tactic.DotStmtContext) {
            throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED //TODO This should not be in the grammar.
        } else
            throw new GrammarHasChangedException("StmtContext");
    }

    private void manualArithExprWalker(Tactic.ArithExprContext ctx){

        if(ctx.arithExprParent() != null){
            manualArithExprParentWalker(ctx.arithExprParent());
            vcl.exitArithExprParent(ctx.arithExprParent());
        }

        if(ctx.arithExprMiddle() != null){
            manualArithExprMiddleWalker(ctx.arithExprMiddle());
            vcl.exitArithExprMiddle(ctx.arithExprMiddle());
        }
    }

    private void manualArithExprParentWalker(Tactic.ArithExprParentContext ctx){
        if(ctx.arithExprRight() != null){
            manualArithExprRightWalker(ctx.arithExprRight());
            vcl.exitArithExprRight(ctx.arithExprRight());
        }

        for(Tactic.ArithExprParenthMiddleContext aemc : ctx.arithExprParenthMiddle()){
            manualArithExprParenthMiddleWalker(aemc);
            vcl.exitArithExprParenthMiddle(aemc);

        }

        for(Tactic.ArithExprBothContext aebc : ctx.arithExprBoth()){
            manualArithExprBothWalker(aebc);
            vcl.exitArithExprBoth(aebc);
        }

        if(ctx.arithExprLeft() != null){
            manualArithExprLeftWalker(ctx.arithExprLeft());
            vcl.exitArithExprLeft(ctx.arithExprLeft());
        }
    }

    private void manualArithExprMiddleWalker(Tactic.ArithExprMiddleContext ctx){
        vcl.exitArithExprMiddle(ctx);
    }

    private void manualArithExprParenthMiddleWalker(Tactic.ArithExprParenthMiddleContext ctx){
        manualArithExprWalker(ctx.arithExpr());
    }

    private void manualArithExprLeftWalker(Tactic.ArithExprLeftContext ctx){
        vcl.exitArithExprLeft(ctx);
    }

    private void manualArithExprRightWalker(Tactic.ArithExprRightContext ctx){
        vcl.exitArithExprRight(ctx);
    }

    private void manualArithExprBothWalker(Tactic.ArithExprBothContext ctx){
        vcl.exitArithExprBoth(ctx);
    }

    /** @return true if the given identifier matches one of this procedures parameters. */
    public boolean isIdentifierMatchingAParameter(String identifier){

        for(Parameter parameter : parameters){
            if(parameter.getIdentifier().compareTo(identifier) == 0)
                return true;
        }

        return false;
    }

    /** @return the number of the parameter matching the given identifier. */
    public int getNumberOfParameterFromIdentifier(String identifier){

        for(int i = 0; i < parameters.size(); i++){
            if(parameters.get(i).getIdentifier().compareTo(identifier) == 0)
                return i;
        }

        throw new IllegalArgumentException(); //The given identifier does not match any parameters
    }

    public void addArgument(Parameter parameter){
        parameters.add(parameter);
    }

    public void addStatement(Tactic.ProcedureStmtContext statement){
        statements.add(statement);
    }

    public void addAllStatments(List<Tactic.ProcedureStmtContext> stmtContexts){
        statements.addAll(stmtContexts);
    }

    public ArrayList<Parameter> getArguments() {
        return parameters;
    }

    public int getNumberOfParameters(){
        return parameters.size();
    }

    public String getProdecureName() {
        return prodecureName;
    }

    public int getNumberOfStatements(){
        return statements.size();
    }
}
