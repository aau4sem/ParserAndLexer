package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.Argument;
import model.utils.ArgumentGatherer;
import model.utils.TypeCheckerHelper;
import model.utils.buildInFunction.BuildInFuctionMove;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionWait;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;
import model.variables.VariableContainer2;

import java.util.ArrayList;

/** The purpose of this call is to collect and store all action calls.
 * This is limited to function calls with the identifiers: Move, Change and Wait.
 * This call will also perform type checking for the parameters of the action function calls.*/
public class ActionCollectorListener extends TacticBaseListener {

    private ArrayList<BuildInFunction> actionFunctions = new ArrayList<>();

    private VariableCollectorListener variableCollectorListener;

    public ActionCollectorListener(VariableCollectorListener variableCollectorListener) {
        this.variableCollectorListener = variableCollectorListener;
    }

    @Override
    public void exitFunctionCall(Tactic.FunctionCallContext ctx) {

        String identifier = ctx.identifier().getText();
        //Get the argumentContext of the function call. and get the last child of that, which is the attached ArgumentGatherer.
        ArgumentGatherer ag = (ArgumentGatherer)((Tactic.ArgumentsContext) ctx.children.get(2)).children.get(ctx.children.get(2).getChildCount() -1);
        ArrayList<Argument> arguments = ag.getConvertedArgumentsList();

        if(identifier.compareTo("Change") == 0){
            //Parameters: GP, string, string, number //TODO Might have changed

            if(ag.getNumberOfArguments() != 4){
                System.out.println("The Change-action call does not have the correct number of arguments.");
                throw new IllegalArgumentException();
            }

            //INITIAL TYPE CHECKING --------------------------------------------
            //TODO Can the user declare a GP in the function call?
            typeCheckArgument(arguments.get(0), 1, "Change", Argument.ArguemntType.IDENTIFIER);

            //TODO When grammar is changed: Then this will be a unique category
            typeCheckArgument(arguments.get(1), 2, "Change", Argument.ArguemntType.STRING);

            //TODO When grammar is changed: Then this will be a unique category
            typeCheckArgument(arguments.get(2), 3, "Change", Argument.ArguemntType.STRING);

            typeCheckArgument(arguments.get(3), 4, "Change",
                    Argument.ArguemntType.IDENTIFIER, Argument.ArguemntType.NUMBER);

            //VALUE EVALUATION --------------------------------------------
            //FIRST ARGUMENT
            VariableContainer2 variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
            GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

            if(variableFirstArg == null)
                throw new IllegalArgumentException(); //The parsed variable was not a GP

            //SECOND ARGUMENT
            String secondArg = arguments.get(1).getValue();

            //THIRD ARGUMENT
            String thirdArg = arguments.get(2).getValue();

            //FOURTH ARGUMENT
            Number variableFourthArgNum = evalIdentifierOrNumberArgument(arguments.get(1));

            //Collect the function
            actionFunctions.add(new BuildInFunctionChange(variableFirstArg, secondArg, thirdArg, variableFourthArgNum));

        }else if(identifier.compareTo("Move") == 0) {
            //Parameters: GP, vector, number //TODO Might have changed

            if(ag.getNumberOfArguments() != 3){
                System.out.println("The Move-action call does not have the correct number of arguments.");
                throw new IllegalArgumentException();
            }

            //TODO Can the user declare a GP in the function call?
            typeCheckArgument(arguments.get(0), 1, "Move", Argument.ArguemntType.IDENTIFIER);

            typeCheckArgument(arguments.get(1), 2, "Move", Argument.ArguemntType.VECTOR);

            typeCheckArgument(arguments.get(2), 3, "Move",
                    Argument.ArguemntType.IDENTIFIER, Argument.ArguemntType.NUMBER);

            //VALUE EVALUATION --------------------------------------------
            //FIRST ARGUMENT
            VariableContainer2 variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
            GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

            if(variableFirstArg == null)
                throw new IllegalArgumentException(); //The parsed variable was not a GP

            //SECOND ARGUMENT
            Vector variableSecondArgVec = TypeCheckerHelper.parseVector(arguments.get(1).getValue());

            //THIRD ARGUMENT
            Number variableThirdArgNum = evalIdentifierOrNumberArgument(arguments.get(2));

            //Collect the function
            actionFunctions.add(new BuildInFuctionMove(variableFirstArg, variableSecondArgVec, variableThirdArgNum));

        }else if(identifier.compareTo("Wait") == 0){

            //Parameters: GP, number

            if(ag.getNumberOfArguments() != 2){
                System.out.println("The Wait-action call does not have the correct number of arguments.");
                throw new IllegalArgumentException();
            }

            //INITIAL TYPE CHECKING --------------------------------------------
            //TODO Can the user declare a GP in the function call?
            typeCheckArgument(arguments.get(0), 1, "Wait", Argument.ArguemntType.IDENTIFIER);

            typeCheckArgument(arguments.get(1), 2, "Wait",
                    Argument.ArguemntType.IDENTIFIER, Argument.ArguemntType.NUMBER);

            //VALUE EVALUATION --------------------------------------------
            //FIRST ARGUMENT
            VariableContainer2 variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
            GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

            if(variableFirstArg == null)
                throw new IllegalArgumentException(); //The parsed variable was not a GP

            //SECOND ARGUMENT
            Number variableSecondArgNum = evalIdentifierOrNumberArgument(arguments.get(1));

            //Collect the function
            actionFunctions.add(new BuildInFunctionWait(variableFirstArg, variableSecondArgNum));
        }
    }

    /** This method is used to check if an argument is of the right type.
     * Will throw an exception if this is not the case.
     * @param arg the Argument to be checked.
     * @param argumentNumber which number the argument is, in the function call.
     * @param functionName the name of the function which argument is being checked.
     * @param allowedType a given amount of ArgumentTypes which the given Argument has to be ONE of. */
    private void typeCheckArgument(Argument arg, int argumentNumber, String functionName, Argument.ArguemntType ... allowedType){

        boolean isArgumentRequestedType = false;

        for( Argument.ArguemntType type : allowedType)
            if(type == arg.getType())
                isArgumentRequestedType = true;

        if(!isArgumentRequestedType){

            //Generate error message
            StringBuilder sb = new StringBuilder();
            sb.append("The ").append(argumentNumber).append(" argument of the ")
                    .append(functionName).append("-action call is not of the type ");

            if(allowedType.length == 1)
                sb.append(allowedType[0].toString());
            else{
                for(int i = 0; i < allowedType.length -1; i++)
                    sb.append(allowedType[i].toString()).append(" or ");

                sb.append(allowedType[allowedType.length-1]).append(".");
            }

            System.out.println(sb.toString());
            throw new IllegalArgumentException();
        }
    }

    /** This method is used if an Argument can be either an IDENTIFIER or NUMBER.
     * @return a Number containing the parsed value. */
    private Number evalIdentifierOrNumberArgument(Argument arg){
        Number num = null;

        if(arg.getType() == Argument.ArguemntType.IDENTIFIER){

            //Get value from identifier and try to parse
            VariableContainer2 varCon = variableCollectorListener.getValueFromIdentifier(arg.getValue());
            num = TypeCheckerHelper.parseNumber(varCon.getValue());

        }else { //It is of type NUMBER
            num = TypeCheckerHelper.parseNumber(arg.getValue());
        }

        //Did it parse?
        if(num == null)
            throw new IllegalArgumentException(); //Value was not an integer or float

        return num;
    }

    /** //TODO: Improvement: This method could be moved to a more general parserListener.
     * This method is used to combine all arguments in a function call.
     * It uses that class ArgumentGatherer to collect and merge arguments while traversing
     * the tree for a given function call.
     * Method: This method is called every time an Argument node is exited. If it only has one child,
     * it is an end note with a value, here we create an instance of the ArgumentCollector with the current
     * nodes value, and attached to the current node. If the node being exited has three children,
     * an argument node, a comma node, and another argument node, we create a new ArgumentGatherer
     * from the two attached to the current nodes two argument children. Purpose: when exiting a
     * function call, we can then get the last child for that node, and it will be a ArgumentGatherer
     * containing all arguments for the function call. */
    @Override
    public void exitArguments(Tactic.ArgumentsContext ctx) {
        if (ctx.children.size() == 1) { //This is an end note. The child is a value
            ArgumentGatherer ag = new ArgumentGatherer();
            ag.addArgument((Tactic.ValueContext) ctx.children.get(0));
            ctx.addChild(ag);
        } else if (ctx.children.size() == 3) { //This is a node that has two arguments as children. The middle child is a comma.

            //Get the last child of the first node in this node: current(ctx).1.last
            ArgumentGatherer agFirstArgument = (ArgumentGatherer) ((Tactic.ArgumentsContext) ctx.children.get(0)).children.get(ctx.children.get(0).getChildCount() - 1);

            //Get the last child of the third node in this node: current(ctx).3.last
            ArgumentGatherer agSecondArgument = (ArgumentGatherer) ((Tactic.ArgumentsContext) ctx.children.get(2)).children.get(ctx.children.get(2).getChildCount() - 1);

            //Merge the arguments of the children and
            ArgumentGatherer mergedAg = new ArgumentGatherer();
            mergedAg.addAllArguments(agFirstArgument.getList());
            mergedAg.addAllArguments(agSecondArgument.getList());

            //Attach the merged ArgumentGatherer to the current node
            ctx.addChild(mergedAg);
        }
    }

    public ArrayList<BuildInFunction> getActionFunctions() {
        return actionFunctions;
    }
}
