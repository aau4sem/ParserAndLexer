package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class BooleanParsing {

    private static VariableCollectorListener vlc;

    @Test
    public void equal01(){
        parse("bool x = true == true;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal02(){

        parse("bool x = false == false;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal03(){

        parse("bool x = true == false;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal04(){

        parse("bool x = false == true;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lesser01(){

        parse("bool x = 4 > 2;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lesser02(){

        parse("bool x = 1 > 2;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greater01(){

        parse("bool x = 4 < 10;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greater02(){

        parse("bool x = 5 < 2;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 || x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
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
