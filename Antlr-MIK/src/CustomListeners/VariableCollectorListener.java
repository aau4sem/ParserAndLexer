package customListeners;

import gen.Tactic;
import gen.TacticBaseListener;
import model.dataTypes.GamePiece;
import model.utils.ArithmeticGatherer;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import model.variables.VariableScopeData;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;

/** This class will collect and handle variables during parsing.
 * The idea is that during the pass, this class will contain a
 * model with the current state of variables, and other classes
 * and listeners will request this class for information regarding
 * variables. */
public class VariableCollectorListener extends TacticBaseListener {

    //Two variableScopeData to keep track of variable declarations in the main and function scope
    private VariableScopeData mainScope = new VariableScopeData(VariableScopeData.ScopeType.MAIN_SCOPE);
    private VariableScopeData procedureScope = new VariableScopeData(VariableScopeData.ScopeType.PROCEDURE_SCOPE); //TODO Should be used to store the parameters when entering a procedure call?

    //Keeps track of which scope the parsing/tree walk currently is in
    private VariableScopeData.ScopeType currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;

    //All supported variable types
    public enum VariableType { INT, FLOAT, VEC, BOOL, STRING, GAMEPIECE}

    // CORE METHODS -----------------------------------------------------------

    /** Used to add variables to the current scope.
     * @param varCon variable container, containing the value and information of the variable. */
    private void addVariableToScope(VariableContainer varCon){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE){
            mainScope.addVariable(varCon);
        }else{
            procedureScope.addVariable(varCon);
        }
    }

    /** used to overwrite a value of a variable in the current scope.
     * @param val the new value that will be used to overwrite the old one.
     * @param identifier the identifier of the variable to overwrite. */
    private void overwriteValueOfVariable(String identifier, String val){
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            mainScope.overwriteValueOfVariable(identifier, val);
        else
            procedureScope.overwriteValueOfVariable(identifier, val);
    }

    /** Used to get variables from the current scope. If the current scope
     * is procedure scope, and ff the variable is not found in the function
     * scope, it will then search the main scope.
     * @param identifier the identifier of the requested variable.
     * @return the value of the variable. */
    private VariableContainer getValueFromScope(String identifier){

        VariableContainer varCon;

        //Get VariableContainer from the current scope
        if(currentScope == VariableScopeData.ScopeType.MAIN_SCOPE)
            varCon = mainScope.getVariable(identifier);
        else{
            varCon = procedureScope.getVariable(identifier);
            if(varCon == null)
                varCon = mainScope.getVariable(identifier);
        }

        return varCon;
    }

    /** Used to get a value from an identifier. */
    public VariableContainer getValueFromIdentifier(String identifier){
        return getValueFromScope(identifier);
    }

    /** @return true if the given identifier is found in the current scope or an above scope. */
    private boolean hasBeenInitialized(String identifier){
        return getValueFromScope(identifier) != null;
    }

    /** Used to check if an identifier is declared, assigned and has the correct type.
     * Will throw an exceptions of any of the three cases does not pass.
     * @param identifier the identifier for the value to check.
     * @param requestedType the type the value should have.
     * @return a variableContainer holding the value matching the given identifier. */
    public VariableContainer identifierToValueCheck(String identifier, VariableCollectorListener.VariableType requestedType){

        VariableContainer varCon = getValueFromScope(identifier);

        if(varCon == null){
            System.out.println("The requested variable has not been declared.");
            throw new IllegalArgumentException();
        }

        if(varCon.getValue() == null){
            System.out.println("The requested variable has been declared but not assigned.");
            throw new IllegalArgumentException();
        }

        if(varCon.getType() != requestedType){
            System.out.println("The requested variable does exist, is assigned, but is not of the right type."); //TODO This should never happen: we check the value before assigning it.
            throw new IllegalArgumentException();
        }

        return varCon;
    }

    // UTILITIES -----------------------------------------------------------------

    /** @return all GamePieces instantiated. */
    public ArrayList<GamePiece> getAllGamePieces(){

        ArrayList<GamePiece> allGamePieces = new ArrayList<>();

        for( VariableContainer varCon : mainScope.getAllVariablesOfType(VariableCollectorListener.VariableType.GAMEPIECE))
            allGamePieces.add(TypeCheckerHelper.parseGamePiece(varCon.getValue()));

        return allGamePieces;
    }

    // OVERWRITES ----------------------------------------------------

    //TODO ASSIGNMENT FROM VariableCollectorListener


    @Override
    public void enterProcedureCall(Tactic.ProcedureCallContext ctx) {
        this.currentScope = VariableScopeData.ScopeType.PROCEDURE_SCOPE;
    }

    @Override
    public void exitProcedureCall(Tactic.ProcedureCallContext ctx) {
        this.currentScope = VariableScopeData.ScopeType.MAIN_SCOPE;
    }

    //TODO ALL DCLS FROM VariableCollectorListener

    @Override //TODO Does this work?
    public void exitDotAssignment(Tactic.DotAssignmentContext ctx) {

        String identifier = ctx.dotStmt().identifier().get(0).getText();

        if(!hasBeenInitialized(identifier)){
            System.out.println("Dot assignment is used on a non-initialized variable.");
            throw new IllegalArgumentException();
        }

        VariableContainer variableBeingDotted = getValueFromScope(identifier);

        //This section is triggered when DotAssignment is used on a GamePiece
        if(variableBeingDotted.getType() == VariableCollectorListener.VariableType.GAMEPIECE){

            String identifierAfterDot = ctx.dotStmt().identifier().get(1).getText();

            //Parse identifierAfterDot to get the GP property
            GamePiece.GamePiecePropertyType gpPropType = TypeCheckerHelper.parseGamePiecePropertyType(identifierAfterDot);

            if(gpPropType == null){
                System.out.println("A GamePiece is being dotted with a non-GPProperty string");
                throw new IllegalArgumentException();
            }

            //Change the property in the GP (also removed citation-marks if needed)
            String newPropertyValue = TypeCheckerHelper.parseString(ctx.value().getText()); //Trim citations
            GamePiece gp = TypeCheckerHelper.parseGamePiece(getValueFromScope(identifier).getValue());
            gp.changeProperty(gpPropType, newPropertyValue);

            //Save the changed GamePiece
            String changedGpValue = gp.getGamePieceString();
            addVariableToScope(new VariableContainer(identifier, changedGpValue, VariableCollectorListener.VariableType.GAMEPIECE));
        }
    }

    // ARITHMETIC EXPRESSIONS ------------------------------

    private float getArithmeticResult(Tactic.ArithExprContext ctx){

        if(ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)  instanceof ArithmeticGatherer)
            return (float)((ArithmeticGatherer) ctx.children.get(0).getChild(ctx.children.get(0).getChildCount() -1)).getResult();

        //This should never happen. If it does, the arithmetic expression
        //parsing (below functions) did not go ad expected.
        throw new IllegalArgumentException();
    }

    @Override
    public void exitArithExprParent(Tactic.ArithExprParentContext ctx) {

        //Get all arithmeticGatherers from the children
        ArrayList<ArithmeticGatherer> ags = new ArrayList<>();

        for (ParseTree child : ctx.children)
            ags.add((ArithmeticGatherer) child.getChild(child.getChildCount() -1));

        //Put together the final ag with the final equation
        ArithmeticGatherer finalAG = new ArithmeticGatherer();
        for (ArithmeticGatherer ag : ags)
            finalAG.addValue(ag.getEquation());

        ctx.addChild(finalAG);
    }

    @Override
    public void exitArithExprParenthMiddle(Tactic.ArithExprParenthMiddleContext ctx) {

        ArithmeticGatherer ag = new ArithmeticGatherer();
        ag.addValue("(");
        ag.addValue(((ArithmeticGatherer)ctx.arithExpr().children.get(0).getChild(ctx.arithExpr().children.get(0).getChildCount() -1)).getEquation());
        ag.addValue(")");

        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprMiddle(Tactic.ArithExprMiddleContext ctx) {

        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprRight(Tactic.ArithExprRightContext ctx) {
        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprLeft(Tactic.ArithExprLeftContext ctx) {
        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    @Override
    public void exitArithExprBoth(Tactic.ArithExprBothContext ctx) {
        ArithmeticGatherer ag = new ArithmeticGatherer();
        getAllArithmeticEndNodes(ag, ctx.children);

        //Attach ArithmeticGatherer to the current node as a child
        ctx.addChild(ag);
    }

    /** Fills the given ArithmeticGatherer with the values of children in the given list.
     * @param nodes the list of children found in: arithExprMiddle, arithExprRight, arithExprBoth and arithExprLeft.*/
    private void getAllArithmeticEndNodes(ArithmeticGatherer ag, List<ParseTree> nodes){
        for (ParseTree node : nodes) {
            if (node instanceof Tactic.NumberContext) {
                ag.addValue(node.getText());
            } else if (node instanceof Tactic.ArithActionContext) {
                ag.addValue(node.getText());
            } else if (node instanceof Tactic.IdentifierContext) {

                VariableContainer varCon = getValueFromIdentifier(node.getText());

                if(varCon == null)
                    throw new IllegalArgumentException(); //The variable has not been initialized

                if(varCon.getType() != VariableCollectorListener.VariableType.INT && varCon.getType() != VariableCollectorListener.VariableType.FLOAT)
                    throw new IllegalArgumentException(); //Not the correct type

                ag.addValue(varCon.getValue());
            } else {
                throw new IllegalArgumentException(); //Grammar has changed
            }
        }
    }
}
