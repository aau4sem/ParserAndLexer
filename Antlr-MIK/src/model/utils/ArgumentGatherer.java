package model.utils;

import exceptions.GrammarHasChangedException;
import gen.Tactic;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

/** Used when collecting arguments of a procedure call.
 * It implements TerminalNode to gain the ability to be attached to nodes in the ParseTree. */
public class ArgumentGatherer implements TerminalNode {

    private ArrayList<Tactic.ValueContext> arguments = new ArrayList<>();

    public void addArgument(Tactic.ValueContext argument){
        arguments.add(argument);
    }

    public void addAllArguments(ArrayList<Tactic.ValueContext> list){
        arguments.addAll(list);
    }

    public ArrayList<Tactic.ValueContext> getList(){
        return new ArrayList<>(arguments);
    }

    /** Converts the ValueContext list to a list of Argument.
     * The Argument list is much cleaner and easier to use.
     * @return a list of Argument matching the current ValueContexts. */
    public ArrayList<Argument> getConvertedArgumentsList(){

        ArrayList<Argument> convertedArguments = new ArrayList<>();

        //Go though every ValueContext and convert them into an Argument
        for( Tactic.ValueContext vc : arguments){
            Argument arg;

            //Find the type of the argument
            if(vc.number() != null){ //The argument is a number
                if(vc.number().floatVal() != null)
                    arg = new Argument(vc.number().floatVal().getText(), Argument.ArgumentType.FLOAT);
                else if(vc.number().integer() != null)
                    arg = new Argument(vc.number().integer().getText(), Argument.ArgumentType.INTEGER);
                else
                    throw new GrammarHasChangedException("ConvertArguments");
            }else if(vc.identifier() != null){ //The argument is an identifier
                arg = new Argument(vc.identifier().getText(), Argument.ArgumentType.IDENTIFIER);
            }else if(vc.string() != null){ //The argument is a string
                String trimmedString = TypeCheckerHelper.parseString(vc.string().getText());
                arg = new Argument(trimmedString, Argument.ArgumentType.STRING);
            }else if(vc.vec() != null) { //The argument is a vector
                arg = new Argument(vc.vec().getText(), Argument.ArgumentType.VECTOR);
            }else if(vc.bool() != null){
                arg = new Argument(vc.bool().getText(), Argument.ArgumentType.BOOL);
            }else{
                throw new IllegalArgumentException();
            }

            convertedArguments.add(arg);
        }

        return convertedArguments;
    }

    // BELOW METHODS IS NOT USED BUT HAS TO BE IMPLEMENTED -------------------

    @Override
    public ParseTree getParent() {
        return null;
    }

    @Override
    public Object getPayload() {
        return null;
    }

    @Override
    public ParseTree getChild(int i) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public String toStringTree() {
        return null;
    }

    @Override
    public void setParent(RuleContext parent) {

    }

    @Override
    public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
        return null;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public String toStringTree(Parser parser) {
        return null;
    }

    @Override
    public Token getSymbol() {
        return null;
    }

    @Override
    public Interval getSourceInterval() {
        return null;
    }
}
