package customListeners;

import exceptions.IllegalArgumentType;
import exceptions.IllegalNumberOfArguments;
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
import model.variables.VariableContainer;

import java.util.ArrayList;

/** The purpose of this call is to collect and store all action calls.
 * This is limited to function calls with the identifiers: move, change and wait.
 * This class will also perform type checking for the parameters of the action function calls.*/
public class ActionCollectorListener extends TacticBaseListener {

    private ArrayList<BuildInFunction> actionFunctions = new ArrayList<>();
    private VariableCollectorListener variableCollectorListener;

    /**@param variableCollectorListener is used for getting variables from identifiers used in function calls. */
    public ActionCollectorListener(VariableCollectorListener variableCollectorListener) {
        this.variableCollectorListener = variableCollectorListener;
    }

    /** This method will only detect function calls with the prefix/identifier: wait, change or move. */
    @Override
    public void exitProcedureCall(Tactic.ProcedureCallContext ctx) {

        if(variableCollectorListener.isInProcedureDefinition)
            return;

        //System.out.println(ctx.children.get(0).getText());
        String identifier = ctx.identifier().getText();

        if(identifier.compareTo(BuildInFunctionChange.identifier) == 0 || identifier.compareTo(BuildInFuctionMove.identifier) == 0 ||identifier.compareTo(BuildInFunctionWait.identifier) == 0){
            //Get the argumentContext of the function call, and get the last child of that, which is the attached ArgumentGatherer.
            ArgumentGatherer ag = (ArgumentGatherer)((Tactic.ArgumentsContext) ctx.children.get(2)).children.get(ctx.children.get(2).getChildCount() -1);
            ArrayList<Argument> arguments = ag.getConvertedArgumentsList();

            if(identifier.compareTo(BuildInFunctionChange.identifier) == 0){
                //Parameters: GP, string, string, number

                if(ag.getNumberOfArguments() != 4)
                    throw new IllegalNumberOfArguments(4, identifier, ag.getNumberOfArguments());

                //INITIAL TYPE CHECKING --------------------------------------------
                typeCheckArgument(arguments.get(0), 1, identifier, Argument.ArgumentType.IDENTIFIER);

                if(TypeCheckerHelper.parseGamePiecePropertyType(arguments.get(1).getValue()) == null)
                    throw new IllegalArgumentType(2, identifier, Argument.ArgumentType.GAMEPIECE_PROPERTY);

                typeCheckArgument(arguments.get(2), 3, identifier, Argument.ArgumentType.STRING,
                        Argument.ArgumentType.IDENTIFIER, Argument.ArgumentType.INTEGER, Argument.ArgumentType.FLOAT,
                        Argument.ArgumentType.VECTOR);

                typeCheckArgument(arguments.get(3), 4, identifier,
                        Argument.ArgumentType.IDENTIFIER, Argument.ArgumentType.INTEGER, Argument.ArgumentType.FLOAT);

                //VALUE EVALUATION --------------------------------------------
                //FIRST ARGUMENT
                VariableContainer variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
                GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

                if(variableFirstArg == null) //Was the parsed variable a GP?
                    throw new IllegalArgumentType(1, identifier, "GamePiece");

                //SECOND ARGUMENT //Make sure that the value matches the property
                GamePiece.GamePiecePropertyType secondArg = TypeCheckerHelper.parseGamePiecePropertyType(arguments.get(1).getValue());

                //THIRD ARGUMENT
                String thirdArg = arguments.get(2).getValue();

                //FOURTH ARGUMENT
                Number fourthArg = evalIdentifierOrNumberArgument(arguments.get(3), 3, identifier);

                //Collect the function //This function is used because of the third argument - it can be multiple types
                addChangeActionCall(variableFirstArg, secondArg, thirdArg, fourthArg);

            }else if(identifier.compareTo(BuildInFuctionMove.identifier) == 0) {
                //Parameters: GP, vector, number

                if(ag.getNumberOfArguments() != 3)
                    throw new IllegalNumberOfArguments(3, identifier, ag.getNumberOfArguments());

                typeCheckArgument(arguments.get(0), 1, identifier, Argument.ArgumentType.IDENTIFIER);

                typeCheckArgument(arguments.get(1), 2, identifier, Argument.ArgumentType.VECTOR);

                typeCheckArgument(arguments.get(2), 3, identifier,
                        Argument.ArgumentType.IDENTIFIER, Argument.ArgumentType.FLOAT, Argument.ArgumentType.INTEGER);

                //VALUE EVALUATION --------------------------------------------
                //FIRST ARGUMENT
                VariableContainer variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
                GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

                if(variableFirstArg == null) //Was the parsed variable a GP?
                    throw new IllegalArgumentType(1, identifier, "GamePiece");

                //SECOND ARGUMENT
                Vector variableSecondArgVec = TypeCheckerHelper.parseVector(arguments.get(1).getValue());

                //THIRD ARGUMENT
                Number variableThirdArgNum = evalIdentifierOrNumberArgument(arguments.get(2), 2, identifier);

                //Collect the function
                actionFunctions.add(new BuildInFuctionMove(variableFirstArg, variableSecondArgVec, variableThirdArgNum));

            }else if(identifier.compareTo(BuildInFunctionWait.identifier) == 0){
                //Parameters: GP, number

                if(ag.getNumberOfArguments() != 2)
                    throw new IllegalNumberOfArguments(2, identifier, ag.getNumberOfArguments());

                //INITIAL TYPE CHECKING --------------------------------------------
                typeCheckArgument(arguments.get(0), 1, identifier, Argument.ArgumentType.IDENTIFIER);

                typeCheckArgument(arguments.get(1), 2, identifier,
                        Argument.ArgumentType.IDENTIFIER, Argument.ArgumentType.FLOAT, Argument.ArgumentType.INTEGER);

                //VALUE EVALUATION --------------------------------------------
                //FIRST ARGUMENT
                VariableContainer variableConFirstArg = variableCollectorListener.getValueFromIdentifier(arguments.get(0).getValue());
                GamePiece variableFirstArg = TypeCheckerHelper.parseGamePiece(variableConFirstArg.getValue());

                if(variableFirstArg == null) //Was the parsed variable a GP?
                    throw new IllegalArgumentType(1, identifier, "GamePiece");

                //SECOND ARGUMENT
                Number variableSecondArgNum = evalIdentifierOrNumberArgument(arguments.get(1), 1, identifier);

                //Collect the function
                actionFunctions.add(new BuildInFunctionWait(variableFirstArg, variableSecondArgNum));
            }
        }
    }

    /** Used to parse the type of the third argument of the change call.
     * This can be a different types based on the property type. */
    private void addChangeActionCall(GamePiece firstArg, GamePiece.GamePiecePropertyType secondArg, String thirdArg, Number fourthArg){

        if(secondArg == GamePiece.GamePiecePropertyType.POSITION){
            if(TypeCheckerHelper.parseVector(thirdArg) == null)
                throw new IllegalArgumentType(3, BuildInFunctionChange.identifier, Argument.ArgumentType.VECTOR);
        }else if(secondArg == GamePiece.GamePiecePropertyType.SIZE){
            if(TypeCheckerHelper.parseFloat(thirdArg) == null)
                throw new IllegalArgumentType(3, BuildInFunctionChange.identifier, "float");
        }else if(secondArg == GamePiece.GamePiecePropertyType.OPACITY){
            if(TypeCheckerHelper.parseFloat(thirdArg) == null)
                throw new IllegalArgumentType(3, BuildInFunctionChange.identifier, "float");
        }

        actionFunctions.add(new BuildInFunctionChange(firstArg, secondArg, thirdArg, fourthArg));
    }

    /** This method is used to check if an argument is of the right type.
     * Will throw an exception if this is not the case.
     * @param arg the Argument to be checked.
     * @param argumentNumber which number the argument is, in the function call.
     * @param functionName the name of the function which argument is being checked.
     * @param allowedType a given amount of ArgumentTypes which the given Argument has to be ONE of. */
    private void typeCheckArgument(Argument arg, int argumentNumber, String functionName, Argument.ArgumentType... allowedType){

        boolean isArgumentRequestedType = false;

        for( Argument.ArgumentType type : allowedType)
            if(type == arg.getType())
                isArgumentRequestedType = true;

        //Did the check fail: is the argument of the requested type?
        if(!isArgumentRequestedType){
            throw new IllegalArgumentType(argumentNumber, functionName, allowedType);
        }
    }

    /** This method is used if an Argument can be either an IDENTIFIER or NUMBER.
     * @return a Number containing the parsed value. */
    private Number evalIdentifierOrNumberArgument(Argument arg, int numberOfArguments, String functionName){
        Number num;

        if(arg.getType() == Argument.ArgumentType.IDENTIFIER){

            //Get value from identifier and try to parse
            VariableContainer varCon = variableCollectorListener.getValueFromIdentifier(arg.getValue());
            num = TypeCheckerHelper.parseNumber(varCon.getValue());

        }else { //It is of type NUMBER
            num = TypeCheckerHelper.parseNumber(arg.getValue());
        }

        //Did it parse?
        if(num == null) // Was the value of type integer or float
            throw new IllegalArgumentType(numberOfArguments + 1, functionName, "integer or float");

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

        if(variableCollectorListener.isInProcedureDefinition)
            return;

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
