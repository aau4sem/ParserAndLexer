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

/** This class is used when evaluating an arithmetic expression. */
public class ArithmeticGatherer implements TerminalNode {

    private ArrayList<Tactic.NumberContext> values = new ArrayList<>();

    private StringBuilder equation = new StringBuilder();

    public void addValue(String val){
        equation.append(val);
    }

    public String getEquation(){
        return equation.toString();
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
    public Token getSymbol() {
        return null;
    }

    @Override
    public Interval getSourceInterval() {
        return null;
    }
}
