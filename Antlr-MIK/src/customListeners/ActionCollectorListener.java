package customListeners;

import exceptions.IllegalArgumentType;
import exceptions.IllegalNumberOfArguments;
import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.Argument;
import model.utils.ArgumentGatherer;
import model.utils.TypeCheckerHelper;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionWait;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;
import model.variables.VariableContainer;
import org.antlr.v4.runtime.CodePointBuffer;

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

    @Override
    public void exitAction(Tactic.ActionContext ctx) {

        if(variableCollectorListener.isInProcedureDefinition)
            return;

        if(variableCollectorListener.isTraversingWhileStmt)
            return;


        //FIRST ARGUMENT
        String firstArgIdentifier;

        if(ctx.changeAction() != null)
            firstArgIdentifier = ctx.changeAction().identifier().getText();
        else if(ctx.moveAction() != null)
            firstArgIdentifier = ctx.moveAction().identifier().getText();
        else if(ctx.waitAction() != null)
            firstArgIdentifier = ctx.waitAction().identifier().getText();
        else
            throw new IllegalArgumentException(); //Grammar has changed

        //Is the identifier evaluation to a GamePiece?
        VariableContainer firstArgVarCon = variableCollectorListener.getValueFromIdentifier(firstArgIdentifier);
        if(firstArgVarCon == null){
            System.out.println("The first argument to the action call is an identifier but it is not evaluating to a GamePiece.");
            throw new IllegalArgumentException();
        }

        GamePiece firstArgument = TypeCheckerHelper.parseGamePiece(firstArgVarCon.getValue());

        //LAST ARGUMENT
        String lastArgString;

        if(ctx.changeAction() != null)
            lastArgString = ctx.changeAction().integer().getText();
        else if(ctx.moveAction() != null)
            lastArgString = ctx.moveAction().integer().getText();
        else if(ctx.waitAction() != null)
            lastArgString = ctx.waitAction().integer().getText();
        else
            throw new IllegalArgumentException(); //Grammar has changed

        Integer lastArg = TypeCheckerHelper.parseInt(lastArgString);

        if(lastArg == null){
            System.out.println("The last argument of the action call is not a valid integer.");
            throw new IllegalArgumentException();
        }

        //Get the remaining of the arguments and collect action call
        if(ctx.changeAction() != null){

            //SECOND ARGUMENT
            String secondArgString = ctx.changeAction().string().getText();
            secondArgString = TypeCheckerHelper.parseString(secondArgString);
            if(TypeCheckerHelper.parseGamePiecePropertyType(secondArgString) == null){
                System.out.println("The second argument of the change action call ");
                throw new IllegalArgumentException();
            }

            GamePiece.GamePiecePropertyType secondArg = TypeCheckerHelper.parseGamePiecePropertyType(secondArgString);

            //THIRD ARGUMENT
            VariableContainer thirdArgVarCon;
            Tactic.ValueContext thirdArgValueContext = ctx.changeAction().value();
            if(thirdArgValueContext.identifier() != null){
                thirdArgVarCon = variableCollectorListener.getValueFromIdentifier(thirdArgValueContext.identifier().getText());

                if(thirdArgVarCon == null){
                    System.out.println("The requested variable has not been declared. Change action call, third argument.");
                    throw new IllegalArgumentException();
                }

            }else if(thirdArgValueContext.number() != null){
                if(thirdArgValueContext.number().integer() != null){
                    float temp = Float.parseFloat(thirdArgValueContext.number().integer().getText()); //Casting the value to float
                    thirdArgVarCon = new VariableContainer(null, String.valueOf(temp), VariableCollectorListener.VariableType.FLOAT);
                }else if(thirdArgValueContext.number().floatVal() != null){
                    thirdArgVarCon = new VariableContainer(null, thirdArgValueContext.number().floatVal().getText(), VariableCollectorListener.VariableType.FLOAT);
                }else
                    throw new IllegalArgumentException(); //Grammar has changed!
            }else if(thirdArgValueContext.bool() != null){
                System.out.println("The third argument of the change action call cannot be of type boolean.");
                throw new IllegalArgumentException();
            }else if(thirdArgValueContext.vec() != null){
                thirdArgVarCon = new VariableContainer(null, thirdArgValueContext.vec().getText(), VariableCollectorListener.VariableType.VEC);
            }else if(thirdArgValueContext.string() != null){
                String temp = TypeCheckerHelper.parseString(thirdArgValueContext.string().getText()); //Trim citations
                thirdArgVarCon = new VariableContainer(null, temp, VariableCollectorListener.VariableType.STRING);

            } else
                throw new IllegalArgumentException(); //Grammar has changed!

            //Check if the given third argument can be saved in the property given in the second argument
            boolean check = GamePiece.doesValueMatchPropertyType(secondArg, thirdArgVarCon);
            if(!check){
                System.out.println("The given type of the third argument in the change action call does not match the given property (second argument)");
                throw new IllegalArgumentException();
            }

            //Collect the argument
            actionFunctions.add(new BuildInFunctionChange(firstArgument, secondArg, thirdArgVarCon.getValue(), lastArg));

        }else if(ctx.moveAction() != null){

            //SECOND ARGUMENT
            String secondArgString = ctx.moveAction().vec().getText();
            Vector secondArg = TypeCheckerHelper.parseVector(secondArgString);

            if(secondArg == null){
                System.out.println("The second argument of a move action call is not a valid vector.");
                throw new IllegalArgumentException();
            }

            //Collect the argument
            actionFunctions.add(new BuildInFunctionMove(firstArgument, secondArg, lastArg));

        }else if(ctx.waitAction() != null){

            //Collect the argument
            actionFunctions.add(new BuildInFunctionWait(firstArgument, lastArg));

        }else
            throw new IllegalArgumentException(); //Grammar has been changed
    }

    /** Used to parse the type of the third argument of the change call.
     * This can be a different types based on the property type. */
    private void addChangeActionCall(GamePiece firstArg, GamePiece.GamePiecePropertyType secondArg, String thirdArg, Integer fourthArg){

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

    public static void checkGamePiecePropertyColorValue(String val){
        //Check if the given string is the RBG format: rgb(x,x,x)
        val = val.toLowerCase();

        if(val.length() < 5)
            return;

        if(val.substring(0, 4).compareTo("rgb(") == 0 && val.charAt(val.length() -1) == ')'){

            val = val.substring(4, val.length() -1); //This cuts of: "rbg(" and ")"

            String firstNumber = "";
            String secondNumber = "";
            String thirdNumber = "";
            int commaCounter = 0;

            for(char c : val.toCharArray()){

                if(c == ','){
                    commaCounter++;
                    continue;
                }

                if(commaCounter == 0)
                    firstNumber = firstNumber + c;
                else if(commaCounter == 1)
                    secondNumber = secondNumber + c;
                else if(commaCounter == 2)
                    thirdNumber = thirdNumber + c;
            }

            if(commaCounter > 2)
                throwException("The given RBG given as the color property of a GamePiece is not of the current format: rgb(x,x,x)");

            if(firstNumber.length() == 0 || secondNumber.length() == 0 || thirdNumber.length() == 0)
                throwException("The given RBG given as the color property of a GamePiece: one of the values are missing. format: rgb(x,x,x)");

            Integer firstInt = TypeCheckerHelper.parseInt(firstNumber);
            Integer secondInt = TypeCheckerHelper.parseInt(secondNumber);
            Integer thirdInt = TypeCheckerHelper.parseInt(thirdNumber);

            if(firstInt == null || secondInt == null || thirdInt == null)
                throwException("The given RBG given as the color property of a GamePiece: one of the values are not of the type integer. format: rgb(x,x,x)");
        }
    }

    private static void throwException(String msg){
        System.out.println(msg);
        throw new IllegalArgumentException();
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
