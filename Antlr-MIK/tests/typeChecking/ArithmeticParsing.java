package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class ArithmeticParsing {

    private static VariableCollectorListener vlc;

    @Test
    public void addition01(){
        parse("int x = 2 + 2;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(4, x.intValue());
    }

    @Test
    public void addition02(){
        parse("float x = 2.5 + 2.5;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(5f, x, 4);
    }

    @Test
    public void subtraction01(){
        parse("int x = 2 - 2;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0, x.intValue());
    }

    @Test
    public void subtraction02(){
        parse("float x = 2.5 - 2.5;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0f, x, 4);
    }

    @Test
    public void division01(){
        parse("float x = 2 / 2;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1f, x, 4);
    }

    @Test
    public void multiply01(){
        parse("int x = 2 * 2;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(4, x.intValue());
    }

    @Test
    public void multiply02(){
        parse("float x = 0.5 * 2;");

        Float x = Float.parseFloat(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1f, x, 4);
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
