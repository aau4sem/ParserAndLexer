package model.variables;

import exceptions.IllegalNumberOfArgumentsException;
import model.Procedure;
import model.utils.Argument;

import java.util.ArrayList;

public class ProcedureScopeData {

    private VariableScopeData mainScope;
    private Procedure currentProcedure = null;
    private ArrayList<Argument> givenArguments = new ArrayList<>();

    public ProcedureScopeData(VariableScopeData mainScope) {
        this.mainScope = mainScope;
    }

    public void reset(){
        currentProcedure = null;
        givenArguments = new ArrayList<>();
    }

    /** Used to get a variable from this scope. Returns null
     * if the quested variable does not exist.  */
    public VariableContainer getVariable(String identifier){

        /*
        //Is the given identifier matching one of the parameters?
            //Yes, is the given argument matching that parameter an identifier
                //Yes, return the variable from the mainscope
                return mainScope.getVariable(identifier);
                //No, return the matching argument as a variable container, with the type of the parameter
            //No, return null;
            return null;*/



        //Is the given identifier matching one of the parameters?
        if(currentProcedure.isIdentifierMatchingAParamter(identifier)){

            //Get the given argument matching the identifier
            Argument argumentMatchingIdentifier = givenArguments.get(currentProcedure.getNumberOfParameterFromIdentifier(identifier));

            //Is the given argument matching that parameter an identifier
            if(argumentMatchingIdentifier.getType() == Argument.ArgumentType.IDENTIFIER) {
                //Return variable from main scope matching the resolved identifier
                return mainScope.getVariable(argumentMatchingIdentifier.getValue());
            }else if(argumentMatchingIdentifier.getType() == Argument.ArgumentType.GAMEPIECE_PROPERTY){
                throw new IllegalArgumentException(); //Should not happen
            }else{
                //Return the matching argument as a variable container, with the type of the parameter
                return new VariableContainer(identifier, argumentMatchingIdentifier.getValue(), argumentMatchingIdentifier.getMatchingVariableType());
            }
        }else
            return null;
    }

    public void execute(){

        //Does the number of given arguments match the number of parameters
        if(givenArguments.size() != currentProcedure.getNumberOfParameters())
            throw new IllegalNumberOfArgumentsException(currentProcedure.getNumberOfParameters(), currentProcedure.getProdecureName(), givenArguments.size());

        //Does the procedure have any statements?
        if(currentProcedure.getNumberOfStatements() == 0)
            return;

        //TODO Does the given input have the correct types

        currentProcedure.execute();
    }

    public void overwriteValueOfVariable(String identifier, String val){
        VariableContainer varCon = getVariable(identifier);
        varCon.overwriteValue(val);
        //TODO DOES THIS WORK!?!?!?
    }

    public void setCurrentProcedure(Procedure currentProcedure) {
        this.currentProcedure = currentProcedure;
    }

    public void setGivenArguments(ArrayList<Argument> givenArguments) {
        this.givenArguments = givenArguments;
    }
}
