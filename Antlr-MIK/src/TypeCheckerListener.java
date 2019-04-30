import gen.*;
import model.Utils.Argument;
import model.Utils.TypeCheckerHelper;
import model.Utils.buildInFunction.BuildInFuctionMove;
import model.Utils.buildInFunction.BuildInFunction;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckerListener extends TacticBaseListener {

    /** Collection for variables (Should contain information of scope (function or not), collection for functions. */

    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.Scope.MAIN_SCOPE);
    private ArrayList<VariableScopeData> functionScopes = new ArrayList<>(); //Contains all scopes for declared functions
    private ArrayList<BuildInFunction> buildInFunctionCalls = new ArrayList<>();

    //Used to track which scope we currently are in
    private VariableScopeData.Scope currentScope = VariableScopeData.Scope.MAIN_SCOPE;

    /** Used to add variables to scopes.
     * @param functionName should be null, if the variable is in main scope.*/
    public void addVariable(VariableContainer varCon, VariableScopeData.Scope scope, String functionName){

        //Is the variable already declared?


        if(scope == VariableScopeData.Scope.MAIN_SCOPE){

            mainScope.addVariable(varCon);

        }else{
            //Find the scope for the function...



            //TODO WHEN ENTERING FUCTION DECLARATION.. add function scope... so at this point, the scope for the function will always have been created.


        }
    }

    /** Used to add a variable to the main scope. */
    public void addVariable(VariableContainer varCon){

        if (varCon == null)
            throw new IllegalArgumentException(); //TODO Handle exception: something went wrong in the declaration

        if(currentScope == VariableScopeData.Scope.MAIN_SCOPE){
            addVariable(varCon, VariableScopeData.Scope.MAIN_SCOPE, null);

        }else{
            //TODO
        }
    }

    @Override
    public void exitIntDcl(Tactic.IntDclContext ctx) {

        // number | arithExpr | identifier

        VariableContainer varCon = null;

        if(ctx.arithExpr() != null){
            System.out.println("ARITHMETIC");

            //TODO At this point... we have to have decorated the tree.. we need to be able to just pull the value of the arithmetic expression

            //varCon = new VariableContainer(ctx.)
        }else if(ctx.number() != null){ //example: int x = 5;
            System.out.println("NUMBER");

            varCon = new VariableContainer(Integer.parseInt(ctx.number().getText()));

        }else if(ctx.identifier(1) != null){ //example: int x = y + 5;
            System.out.println("IDENTIFIER");

            //TODO At this point... we have to have decorated
        }

        //Add variableContainer to scope / map
        addVariable(varCon);
    }

    @Override
    public void enterFunctionDef(Tactic.FunctionDefContext ctx) {
        this.currentScope = VariableScopeData.Scope.FUNCTION_SCOPE;
    }

    @Override
    public void exitFunctionDef(Tactic.FunctionDefContext ctx) {
        this.currentScope = VariableScopeData.Scope.MAIN_SCOPE;
    }

    /*
    @Override
    public void exitFunction(Tactic.FunctionContext ctx) {

        String identifier = ctx.identifier().getText();
        ArrayList<Argument> arguments = getArguments(ctx); //Get the arguments of the function call
        //System.out.println("Number of arguements: " + arguments.size());

        if(identifier.compareTo("Change") == 0){
            //Parameters: GP, string, string, time

            if(arguments.size() != 4)
                throw new IllegalArgumentException(); //TODO Handle exception: THERE SHOULD ONLY BE 4 ARGUMENTS!!

            //TODO Type check the arguments


        }else if(identifier.compareTo("Move") == 0) {
            //Parameters: GP, vector, int


            if(arguments.size() != 3)
                throw new IllegalArgumentException(); //TODO Handle exception: THERE SHOULD ONLY BE 3 ARGUMENTS!!

            //TODO Type check the arguments

            //Type checking ---------------------------
            //First argument
            GamePiece firstArguement = null;
            if(arguments.get(0).getType() == Argument.ArguemntType.STRING)
                throw new IllegalArgumentException(); //TODO Handle
            else if(arguments.get(0).getType() == Argument.ArguemntType.IDENTIFIER){
                //TODO Handle
            } else {
                throw new IllegalArgumentException(); //TODO Handle: argument was a value, but not the correct type.
            }

            //Second argument
            Vector secondArgument = null;
            if(arguments.get(1).getType() == Argument.ArguemntType.STRING)
                throw new IllegalArgumentException(); //TODO Handle
            else if(arguments.get(1).getType() == Argument.ArguemntType.IDENTIFIER){
                //TODO Handle
            } else {
                secondArgument = TypeCheckerHelper.parseVector(arguments.get(1).getValue());
                if(secondArgument == null)
                    throw new IllegalArgumentException(); //TODO Handle: argument was a value, but not the correct type.
            }

            //Third arguement
            Integer thirdArgument = null;
            if(arguments.get(2).getType() == Argument.ArguemntType.STRING)
                throw new IllegalArgumentException(); //TODO Handle
            else if(arguments.get(2).getType() == Argument.ArguemntType.IDENTIFIER){
                //TODO Handle
            } else {
                thirdArgument = TypeCheckerHelper.parseInt(arguments.get(2).getValue());
                if(thirdArgument == null)
                    throw new IllegalArgumentException(); //TODO Handle: argument was a value, but not the correct type.
            }

            //Did all arguments pass correctly?
            if(firstArguement == null || secondArgument == null || thirdArgument == null)
                throw new IllegalArgumentException(); //TODO Can this ever happen?

            //Collect the build-in function
            buildInFunctionCalls.add(new BuildInFuctionMove(firstArguement, secondArgument, thirdArgument));


        }else if(identifier.compareTo("Wait") == 0){

            //TODO

        }else{
            //Todo: handle other function calls.
            System.out.println("function arguements: " + arguments.size());
        }

    }*/

    /** Used to get a list of all arguments given the top most argument. (Used when handling function calls)
     * @param ctx the top most argument of a function call.
     * @return a complete list of arguments from the given node. */
    /*private ArrayList<Argument> getArguments(Tactic.FunctionContext ctx){

        if(ctx.arguments() == null) //Is there any arguments?
            return new ArrayList<>();

        //This one could be avoided..
        /*
        if(ctx.children.size() == 1){
            ArrayList<Argument> arguments = new ArrayList<>();
            arguments.add(new Argument())

            return arguments;
        } //COMMENT SLUT


        //List<ParseTree> tree = ctx.children;

        //Tactic.ArgumentsContext atx = ctx.arguments();

        System.out.println("THIS: " + ctx.arguments().arguments().size());

        return getArgumentsHelper(ctx.arguments().arguments(), new ArrayList<>());
    }*/

    /** See description of method that calls this.*/
    /*private ArrayList<Argument> getArgumentsHelper(List<Tactic.ArgumentsContext> ctx, ArrayList<Argument> collectedArguments){

        //if(ctx.isEmpty()){
         //   return collectedArguments;
        //}

        //if(ctx.get(0) == null)
        //    System.out.println("FAIL!!");

        //System.out.println("Number of ctx " + ctx.size());
        //TODO BUG: Not working when only ONE arguement!!

        if(ctx.size() == 2){ //Does the current argument have to children, then this is a set of arguments

            if(ctx.get(0).identifier() != null)
                collectedArguments.add(new Argument(ctx.get(0).identifier().getText(), Argument.ArguemntType.IDENTIFIER));
            else if(ctx.get(0).string() != null)
                collectedArguments.add(new Argument(ctx.get(0).string().getText(), Argument.ArguemntType.STRING));
            else if(ctx.get(0).value() != null)
                collectedArguments.add(new Argument(ctx.get(0).value().getText(), Argument.ArguemntType.VALUE));
            else if(ctx.get(0).vec() != null)
                collectedArguments.add(new Argument(ctx.get(0).vec().getText(), Argument.ArguemntType.VECTOR));
            else
                collectedArguments = getArgumentsHelper(ctx.get(0).arguments(), collectedArguments); //The argument is another pair of arguments

            if(ctx.get(1).identifier() != null)
                collectedArguments.add(new Argument(ctx.get(1).identifier().getText(), Argument.ArguemntType.IDENTIFIER));
            else if(ctx.get(1).string() != null)
                collectedArguments.add(new Argument(ctx.get(1).string().getText(), Argument.ArguemntType.STRING));
            else if(ctx.get(1).value() != null)
                collectedArguments.add(new Argument(ctx.get(1).value().getText(), Argument.ArguemntType.VALUE));
            else if(ctx.get(1).vec() != null)
                collectedArguments.add(new Argument(ctx.get(1).vec().getText(), Argument.ArguemntType.VECTOR));
            else
                collectedArguments = getArgumentsHelper(ctx.get(1).arguments(), collectedArguments); //The argument is another pair of arguments

            return collectedArguments;

        }else { //There is only one child, so this is a single argument
            if(ctx.get(0).identifier() != null)
                collectedArguments.add(new Argument(ctx.get(0).identifier().getText(), Argument.ArguemntType.IDENTIFIER));
            else if(ctx.get(0).string() != null)
                collectedArguments.add(new Argument(ctx.get(0).string().getText(), Argument.ArguemntType.STRING));
            else if(ctx.get(0).value() != null)
                collectedArguments.add(new Argument(ctx.get(0).vec().getText(), Argument.ArguemntType.VALUE));
            else if(ctx.get(0).vec() != null)
                collectedArguments.add(new Argument(ctx.get(0).value().getText(), Argument.ArguemntType.VECTOR));
            else
                throw new IllegalArgumentException(); //This should not happen!
        }

        return collectedArguments;
    }*/


}
