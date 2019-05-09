package model;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import model.utils.Argument;
import model.utils.Parameter;

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

    /** executes the procedure.
     * @param vcl used for accessing variables in the main scope. */
    public void execute(ArrayList<Argument> arguments, VariableCollectorListener vcl){ //TODO
        //TODO USE ALL THE OVERWRITTEN METHODS ALREADY CREATED!!!
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
