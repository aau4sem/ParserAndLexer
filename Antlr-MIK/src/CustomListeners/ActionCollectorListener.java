package CustomListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.Utils.Argument;
import model.Utils.ArgumentGatherer;
import model.Utils.TypeCheckerHelper;
import model.Utils.buildInFunction.BuildInFunction;
import model.Utils.buildInFunction.BuildInFunctionChange;
import model.Utils.buildInFunction.BuildInFunctionWait;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
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
            if(arguments.get(0).getType() != Argument.ArguemntType.IDENTIFIER){
                System.out.println("The first argument of the Change-action call is not of type identifier.");
                throw new IllegalArgumentException();
            }

            //TODO When grammar is changed: Then this will be a unique category
            if(arguments.get(1).getType() != Argument.ArguemntType.STRING){
                System.out.println("The second argument of the Change-action call is not of type string.");
                throw new IllegalArgumentException();
            }

            //TODO When grammar is changed: Then this will be a unique category
            if(arguments.get(2).getType() != Argument.ArguemntType.STRING){
                System.out.println("The third argument of the Change-action call is not of type string.");
                throw new IllegalArgumentException();
            }

            if(arguments.get(3).getType() != Argument.ArguemntType.IDENTIFIER &&
                    arguments.get(3).getType() != Argument.ArguemntType.NUMBER){
                System.out.println("The fourth argument of the Change-action call is not of type identifier or number.");
                throw new IllegalArgumentException();
            }

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
            Number variableFourthArgNum = null;

            if(arguments.get(3).getType() == Argument.ArguemntType.IDENTIFIER){

                //Get value from identifier and try to parse
                VariableContainer2 variableConFourthArg = variableCollectorListener.getValueFromIdentifier(arguments.get(3).getValue());
                variableFourthArgNum = TypeCheckerHelper.parseNumber(variableConFourthArg.getValue());

            }else { //It is of type NUMBER
                variableFourthArgNum = TypeCheckerHelper.parseNumber(arguments.get(3).getValue());
            }

            //Did it parse?
            if(variableFourthArgNum == null)
                throw new IllegalArgumentException(); //Value was not an integer or float

            //Collect the function
            actionFunctions.add(new BuildInFunctionChange(variableFirstArg, secondArg, thirdArg, variableFourthArgNum));

        }else if(identifier.compareTo("Move") == 0) {
            //Parameters: GP, vector, number //TODO Might have changed

            if(ag.getNumberOfArguments() != 3){
                System.out.println("The Move-action call does not have the correct number of arguments.");
                throw new IllegalArgumentException();
            }

            //TODO Can the user declare a GP in the function call?
            if(arguments.get(0).getType() != Argument.ArguemntType.IDENTIFIER){
                System.out.println("The first argument of the Move-action call is not of type identifier.");
                throw new IllegalArgumentException();
            }

            if(arguments.get(1).getType() != Argument.ArguemntType.VECTOR){
                System.out.println("The second argument of the Move-action call is not of type vector.");
                throw new IllegalArgumentException();
            }

            if(arguments.get(2).getType() != Argument.ArguemntType.IDENTIFIER &&
                    arguments.get(2).getType() != Argument.ArguemntType.NUMBER){
                System.out.println("The third argument of the Move-action call is not of type identifier or number.");
                throw new IllegalArgumentException();
            }

            //TODO: Futher type checking
            //TODO: Collect

        }else if(identifier.compareTo("Wait") == 0){

            //Parameters: GP, number

            if(ag.getNumberOfArguments() != 2){
                System.out.println("The Wait-action call does not have the correct number of arguments.");
                throw new IllegalArgumentException();
            }

            //INITIAL TYPE CHECKING --------------------------------------------
            //TODO Can the user declare a GP in the function call?
            if(arguments.get(0).getType() != Argument.ArguemntType.IDENTIFIER){
                System.out.println("The first argument of the Wait-action call is not of type identifier.");
                throw new IllegalArgumentException();
            }

            if(arguments.get(1).getType() != Argument.ArguemntType.IDENTIFIER &&
                    arguments.get(1).getType() != Argument.ArguemntType.NUMBER){
                System.out.println("The second argument of the Wait-action call is not of type identifier or number.");
                throw new IllegalArgumentException();
            }

            //VALUE EVALUATION --------------------------------------------
            //FIRST ARGUMENT
            VariableContainer2 variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
            GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

            if(variableFirstArg == null)
                throw new IllegalArgumentException(); //The parsed variable was not a GP

            //SECOND ARGUMENT
            Number variableSecondArgNum = null;

            if(arguments.get(1).getType() == Argument.ArguemntType.IDENTIFIER){

                //Get value from identifier and try to parse
                VariableContainer2 variableConSecondArg = variableCollectorListener.getValueFromIdentifier(arguments.get(1).getValue());
                variableSecondArgNum = TypeCheckerHelper.parseNumber(variableConSecondArg.getValue());

            }else { //It is of type NUMBER
                variableSecondArgNum = TypeCheckerHelper.parseNumber(arguments.get(1).getValue());
            }

            //Did it parse?
            if(variableSecondArgNum == null)
                throw new IllegalArgumentException(); //Value was not an integer or float

            //Collect the function
            actionFunctions.add(new BuildInFunctionWait(variableFirstArg, variableSecondArgNum));

        }
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
}
