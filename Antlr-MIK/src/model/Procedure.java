package model;

import model.utils.Parameter;

import java.util.ArrayList;

public class Procedure {

    private ArrayList<Parameter> parameters;

    public Procedure(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Procedure() {
        this(new ArrayList<>());
    }

    public void addArgument(Parameter parameter){
        parameters.add(parameter);
    }

    public ArrayList<Parameter> getArguments() {
        return parameters;
    }
}
