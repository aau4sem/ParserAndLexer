package model.utils;

import gen.Tactic;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;

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

    public int getNumberOfArguments(){
        return arguments.size();
    }

    /** @return a list of Argument. This list is a lot easier to use and much more clean.*/
    public ArrayList<Argument> getConvertedArgumentsList(){

        ArrayList<Argument> convertedArguments = new ArrayList<>();

        for( Tactic.ValueContext vc : arguments){

            Argument arg = null;

            if(vc.number() != null){
                arg = new Argument(vc.number().getText(), Argument.ArguemntType.NUMBER);
            }else if(vc.identifier() != null){
                arg = new Argument(vc.identifier().getText(), Argument.ArguemntType.IDENTIFIER);
            }else if(vc.string() != null){
                //The substring is taken to avoid saving the "" around the string
                arg = new Argument(vc.string().getText().substring(1, vc.string().getText().length()-1), Argument.ArguemntType.STRING);
            }else if(vc.vec() != null){
                arg = new Argument(vc.vec().getText(), Argument.ArguemntType.VECTOR);
            }else{
                throw new IllegalArgumentException();
            }

            convertedArguments.add(arg);
        }

        return convertedArguments;
    }




    // NOT USED BUT HAS TO BE IMPLEMENTED ---------------------- //TODO Maybe fix in some way? UnImplementedException?

    @Override
    public Token getSymbol() {
        return null;
    }

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
    public Interval getSourceInterval() {
        return null;
    }
}
