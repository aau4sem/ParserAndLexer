package customListeners;

import exceptions.GrammarHasChangedException;
import exceptions.IllegalArgumentTypeException;
import gen.Tactic;
import gen.TacticBaseListener;
import model.utils.Argument;
import model.utils.TypeCheckerHelper;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunction;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionWait;
import model.dataTypes.GamePiece;
import model.dataTypes.Number;
import model.dataTypes.Vector;
import model.variables.VariableContainer;

import java.util.ArrayList;

/** The purpose of this class is to collect and store all action calls.
 * Action-calls have their own grammar rule called action, so this is overwritten.
 * This class will also perform type checking and evaluating for the parameters of the action function calls.*/
public class ActionCollectorListener extends TacticBaseListener {

    private ArrayList<BuildInFunction> collectedActionCalls;
    private VariableCollectorListener variableCollectorListener;

    /**@param variableCollectorListener is used for resolving variables from identifiers used in action calls. */
    public ActionCollectorListener(VariableCollectorListener variableCollectorListener) {
        this.variableCollectorListener = variableCollectorListener;
        this.collectedActionCalls = new ArrayList<>();
    }

    @Override
    public void exitAction(Tactic.ActionContext ctx) {

        if(!variableCollectorListener.mayThisStmtRun())
            return;

        if(variableCollectorListener.isTraversingWhileStmt)
            return;

        //Action-call identifier
        String firstArgIdentifier;

        if(ctx.changeAction() != null) {
            firstArgIdentifier = ctx.changeAction().identifier().getText();
        } else if(ctx.moveAction() != null) {
            firstArgIdentifier = ctx.moveAction().identifier().getText();
        } else if(ctx.waitAction() != null) {
            firstArgIdentifier = ctx.waitAction().identifier().getText();
        } else {
            throw new GrammarHasChangedException("exitAction");
        }

        //FIRST ARGUMENT
        //Is the identifier evaluation to a GamePiece?
        VariableContainer firstArgVarCon = variableCollectorListener.getValueFromIdentifier(firstArgIdentifier);
        if(firstArgVarCon == null)
            throw new IllegalArgumentTypeException(1, "Action-call", "GamePiece");

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
            throw new GrammarHasChangedException("exitAction");

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
            if(TypeCheckerHelper.parseGamePiecePropertyType(secondArgString) == null)
                throw new IllegalArgumentTypeException(2, "Change-action-call", "GamePiece property");

            GamePiece.GamePiecePropertyType secondArg = TypeCheckerHelper.parseGamePiecePropertyType(secondArgString);

            //THIRD ARGUMENT
            VariableContainer thirdArgVarCon;
            Tactic.ValueContext thirdArgValueContext = ctx.changeAction().value();
            if(thirdArgValueContext.identifier() != null){
                thirdArgVarCon = variableCollectorListener.getValueFromIdentifier(thirdArgValueContext.identifier().getText());

                if(thirdArgVarCon == null){
                    throw new IllegalArgumentTypeException("The requested variable has not been declared. Change action call, third argument.");
                }

            }else if(thirdArgValueContext.number() != null){
                if(thirdArgValueContext.number().integer() != null){
                    float temp = Float.parseFloat(thirdArgValueContext.number().integer().getText()); //Casting the value to float
                    thirdArgVarCon = new VariableContainer(null, String.valueOf(temp), VariableCollectorListener.VariableType.FLOAT);
                }else if(thirdArgValueContext.number().floatVal() != null){
                    thirdArgVarCon = new VariableContainer(null, thirdArgValueContext.number().floatVal().getText(), VariableCollectorListener.VariableType.FLOAT);
                }else
                    throw new GrammarHasChangedException("NumberContext");
            }else if(thirdArgValueContext.bool() != null){
                throw new IllegalArgumentTypeException("The third argument of the change action call cannot be of type boolean.");
            }else if(thirdArgValueContext.vec() != null){
                thirdArgVarCon = new VariableContainer(null, thirdArgValueContext.vec().getText(), VariableCollectorListener.VariableType.VEC);
            }else if(thirdArgValueContext.string() != null){
                String temp = TypeCheckerHelper.parseString(thirdArgValueContext.string().getText()); //Trim citations
                thirdArgVarCon = new VariableContainer(null, temp, VariableCollectorListener.VariableType.STRING);

            } else
                throw new GrammarHasChangedException("exitAction");

            //Check if the given third argument can be saved in the property given in the second argument
            boolean check = GamePiece.doesValueMatchPropertyType(secondArg, thirdArgVarCon);
            if(!check){
                throw new IllegalArgumentTypeException("The given type of the third argument in the change action call does not match the given property (second argument)");
            }

            //Collect the argument
            collectedActionCalls.add(new BuildInFunctionChange(firstArgument, secondArg, thirdArgVarCon.getValue(), lastArg));

        }else if(ctx.moveAction() != null){

            //SECOND ARGUMENT
            String secondArgString = ctx.moveAction().vec().getText();
            Vector secondArg = TypeCheckerHelper.parseVector(secondArgString);

            if(secondArg == null)
                throw new IllegalArgumentTypeException("The second argument of a move action call is not a valid vector.");

            //Collect the argument
            collectedActionCalls.add(new BuildInFunctionMove(firstArgument, secondArg, lastArg));

        }else if(ctx.waitAction() != null){

            //Collect the argument
            collectedActionCalls.add(new BuildInFunctionWait(firstArgument, lastArg));

        }else
            throw new IllegalArgumentException(); //Grammar has been changed
    }

    /** Used to parse the type of the third argument of the change call.
     * This can be a different types based on the property type. */ //TODO Delete? This does not seem to be nessesary?
    private void addChangeActionCall(GamePiece firstArg, GamePiece.GamePiecePropertyType secondArg, String thirdArg, Integer fourthArg){

        if(secondArg == GamePiece.GamePiecePropertyType.POSITION){
            if(TypeCheckerHelper.parseVector(thirdArg) == null)
                throw new IllegalArgumentTypeException(3, BuildInFunctionChange.identifier, Argument.ArgumentType.VECTOR);
        }else if(secondArg == GamePiece.GamePiecePropertyType.SIZE){
            if(TypeCheckerHelper.parseFloat(thirdArg) == null)
                throw new IllegalArgumentTypeException(3, BuildInFunctionChange.identifier, "float");
        }else if(secondArg == GamePiece.GamePiecePropertyType.OPACITY){
            if(TypeCheckerHelper.parseFloat(thirdArg) == null)
                throw new IllegalArgumentTypeException(3, BuildInFunctionChange.identifier, "float");
        }

        collectedActionCalls.add(new BuildInFunctionChange(firstArg, secondArg, thirdArg, fourthArg));
    }

    /** //TODO */
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
                throw new IllegalArgumentException("The given RBG given as the color property of a GamePiece is not of the current format: rgb(x,x,x)");

            if(firstNumber.length() == 0 || secondNumber.length() == 0 || thirdNumber.length() == 0)
                throw new IllegalArgumentException("The given RBG given as the color property of a GamePiece: one of the values are missing. format: rgb(x,x,x)");

            Integer firstInt = TypeCheckerHelper.parseInt(firstNumber);
            Integer secondInt = TypeCheckerHelper.parseInt(secondNumber);
            Integer thirdInt = TypeCheckerHelper.parseInt(thirdNumber);

            if(firstInt == null || secondInt == null || thirdInt == null)
                throw new IllegalArgumentException("The given RBG given as the color property of a GamePiece: one of the values are not of the type integer. format: rgb(x,x,x)");
        }
    }

    public ArrayList<BuildInFunction> getCollectedActionCalls() {
        return collectedActionCalls;
    }

    @Override
    public void enterCondStmt(Tactic.CondStmtContext ctx) {
    }
}
