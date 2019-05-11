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
    public void execute(){ //TODO


        //Add the parameters to the current scope //TODO Not needed when using new ProcedureScopeData
        //for(int i = 0; i < parameters.size(); i++){
        //    vcl.addVariableToScope(new VariableContainer(parameters.get(i).getIdentifier(), givenArgumentValues.get(0).getValue(), parameters.get(i).getType()));
        //}

        //Run all statements //TODO USE ALL THE OVERWRITTEN METHODS ALREADY CREATED!!!
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
