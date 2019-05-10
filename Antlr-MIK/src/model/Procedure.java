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

    public Procedure(ArrayList<Parameter> parameters, ArrayList<Tactic.StmtContext> statements) {
        this.parameters = parameters;
        this.statements = statements;
    }

    public Procedure() {
        this(new ArrayList<>(), new ArrayList<>());
    }

    /** Executes the procedure.
     * @param vcl used for accessing variables in the main scope. */
    public void execute(ArrayList<Argument> givenArgumentValues, VariableCollectorListener vcl, String procedureName){ //TODO
        //TODO USE ALL THE OVERWRITTEN METHODS ALREADY CREATED!!!

        //Does the number of given arguments match the number of parameters
        if(givenArgumentValues.size() != parameters.size())
            throw new IllegalNumberOfArguments(parameters.size(), procedureName, givenArgumentValues.size());

        //Does the procedure has any statements?
        if(statements.size() == 0)
            return;

        //TODO Does the given input have the correct types


        //Add the parameters to the current scope
        for(int i = 0; i < parameters.size(); i++){
            vcl.addVariableToScope(new VariableContainer(parameters.get(i).getIdentifier(), givenArgumentValues.get(0).getValue(), parameters.get(i).getType()));
        }

        throw new IllegalArgumentException(); //TODO MISTAKE: when an identifier is passed, it can change name!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Run all statements
        for(Tactic.StmtContext ctx : statements){

            if(ctx.children.get(0) instanceof Tactic.AssignmentContext){
                vcl.exitAssignment((Tactic.AssignmentContext)ctx.children.get(0));
            }else if(ctx.children.get(0) instanceof Tactic.WhileStmtContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.CondStmtContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.ProcedureCallContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.ArrayAssignContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.DotAssignmentContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.DotStmtContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else if(ctx.children.get(0) instanceof Tactic.ArithExprContext){
                throw new IllegalArgumentException(); //TODO NOT IMPLEMENTED
            }else
                throw new IllegalArgumentException(); //A context was not handled or grammar has changed
        }
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
}
