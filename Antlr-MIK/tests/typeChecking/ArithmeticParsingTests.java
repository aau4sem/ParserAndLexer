package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class ArithmeticParsingTests {

    private static VariableCollectorListener vlc;

    @Test
    public void mixedCalculation01(){
        parse("int i; i = (5 + 5) * 2;;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(20, i.intValue());
    }

    @Test
    public void mixedCalculation02(){
        parse("int i; i = (5 + 5) * (2 + 2);;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(40, i.intValue());
    }

    @Test
    public void mixedCalculation03(){
        parse("int x; int i; x = 2; i = (5 + 5) * x;;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(20, i.intValue());
    }

    @Test
    public void mixedCalculation04(){
        parse("int i; i = (5 + 5) * 2 * 2;;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(40, i.intValue());
    }

    @Test
    public void mixedCalculation05(){
        parse("int i; i = 5 + 5 * 2;;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(15, i.intValue());
    }

    @Test
    public void addition01(){
        parse("int x; x = 2 + 2;;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(4, x.intValue());
    }

    @Test
    public void addition02(){
        parse("float x; x = 2.5 + 2.5;;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(5f, x, 4);
    }

    @Test
    public void subtraction01(){
        parse("int x; x = 2 - 2;;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0, x.intValue());
    }

    @Test
    public void subtraction02(){
        parse("float x; x = 2.5 - 2.5;;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0f, x, 4);
    }

    @Test
    public void division01(){
        parse("float x; x = 2 / 2;;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1f, x, 4);
    }

    @Test
    public void multiply01(){
        parse("int x; x = 2 * 2;;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(4, x.intValue());
    }

    @Test
    public void multiply02(){
        parse("float x; x = 0.5 * 2;;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1f, x, 4);
    }

    //@Test currently not supported
    public void mod01(){
        parse("int x; x = 4 % 3;;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1, x.intValue());
    }

    @Test
    public void arithExpr01(){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i; int x; i = 3; x = 2 + 3 * 1 - (2 + 2) * (2 + 2 * 2) + i;;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(-16, TypeCheckerHelper.parseInt(varCon.getValue()).intValue());
    }

    @Test
    public void selfAddition01(){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i; i = 2; i = i * 2;;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("i");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(4, TypeCheckerHelper.parseInt(varCon.getValue()).intValue());
    }

    @Test
    public void selfAddition02(){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i; i = 2; i = i * 2.3;;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("i");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(4, TypeCheckerHelper.parseInt(varCon.getValue()).intValue());
    }

    @Test
    public void selfAddition03(){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream("int i; i = 0; i = i + 1; i = i + 1;;"));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("i");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(2, TypeCheckerHelper.parseInt(varCon.getValue()).intValue());
    }

    /** Parses the given input and the results can be found in the field. */
    public static void parse(String input){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream(input));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        vlc = new VariableCollectorListener();
        parser.addParseListener(vlc);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }
}
