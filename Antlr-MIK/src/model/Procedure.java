package model;

import customListeners.VariableCollectorListener;
import exceptions.IllegalNumberOfArguments;
import gen.Tactic;
import model.utils.Argument;
import model.utils.Parameter;
import model.variables.VariableContainer;

import java.util.ArrayList;
import java.util.List;

public class Procedure {

    private ArrayList<Parameter> parameters;
    private ArrayList<Tactic.StmtContext> statements;
    private String prodecureName;
    private VariableCollectorListener vcl;

    public Procedure(ArrayList<Parameter> parameters, ArrayList<Tactic.StmtContext> statements, String procedureName, VariableCollectorListener vcl) {
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

        //TODO WHICH IS TO RUN, IF OR ELSE???

        //vcl.


        List<Tactic.StmtContext> condStatments = ctx.ifStmt().block().stmt();

        //throw new IllegalArgumentException(); //TODO BUG HERE


        runStmts(condStatments);

        vcl.exitCondStmt(ctx);
    }

    private void runStmts(List<Tactic.StmtContext> stmts){
        for(Tactic.StmtContext ctx : stmts) {

            if (ctx.children.get(0) instanceof Tactic.AssignmentContext) {
                vcl.exitAssignment((Tactic.AssignmentContext) ctx.children.get(0));
            } else if (ctx.children.get(0) instanceof Tactic.WhileStmtContext) {
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            } else if (ctx.children.get(0) instanceof Tactic.CondStmtContext) {
                runCondStmt((Tactic.CondStmtContext) ctx.children.get(0));
            } else if (ctx.children.get(0) instanceof Tactic.ProcedureCallContext) {
                vcl.exitProcedureCall((Tactic.ProcedureCallContext) ctx.children.get(0)); //TODO The current implementation does not support procedure calls inside other procedures.
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            } else if (ctx.children.get(0) instanceof Tactic.ArrayAssignContext) {
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            } else if (ctx.children.get(0) instanceof Tactic.DotAssignmentContext) {
                vcl.exitDotAssignment((Tactic.DotAssignmentContext) ctx.children.get(0));
                //throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            } else if (ctx.children.get(0) instanceof Tactic.DotStmtContext) {
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED //TODO This should not be in the grammar.
            } else
                throw new IllegalArgumentException(); //A context was not handled or grammar has changed
        }
    }

    /** @return true if the given identifier matches one of this procedures parameters. */
    public boolean isIdentifierMatchingAParamter(String identifier){

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

    public void addStatement(Tactic.StmtContext statement){
        statements.add(statement);
    }

    public void addAllStatments(List<Tactic.StmtContext> stmtContexts){
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
