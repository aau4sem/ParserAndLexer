package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class BooleanParsingTests {

    private static VariableCollectorListener vlc;

    @Test
    public void equal01(){
        parse("bool x; x = true == true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal02(){
        parse("bool x; x = false == false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal03(){
        parse("bool x; x = true == false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal04(){
        parse("bool x; x = false == true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal05(){
        parse("bool x; x = 5 == 3;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal06(){
        parse("bool x; x = 5 == 5;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lesser01(){
        parse("bool x; x = 4 > 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lesser02(){
        parse("bool x; x = 1 > 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greater01(){
        parse("bool x; x = 4 < 10;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greater02(){
        parse("bool x; x = 5 < 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void or01(){
        parse("bool x; x = true || true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void or02(){
        parse("bool x; x = false || false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void or03(){
        parse("bool x; x = true || false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void or04(){
        parse("bool x; x = false || true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void and01(){
        parse("bool x; x = true && true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void and02(){
        parse("bool x; x = false && false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void and03(){
        parse("bool x; x = true && false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void and04(){
        parse("bool x; x = false && true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    /*@Test
    public void not01(){
        parse("bool x; x = !true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void not02(){
        parse("bool x; x = !false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }*/

    @Test
    public void notequal01(){
        parse("bool x; x = true != true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal02(){
        parse("bool x; x = false != false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal03(){
        parse("bool x; x = true != false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal04(){
        parse("bool x; x = false != true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal05(){
        parse("bool x; x = 2 != 5;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal06(){
        parse("bool x; x = 2.4 != 1.2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal07(){
        parse("bool x; x = 2.4 != 2.4;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal08(){
        parse("bool x; x = 2 != 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual01(){
        parse("bool x; x = 1 >= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual02(){
        parse("bool x; x = 1.3 >= 1.4;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual03(){
        parse("bool x; x = 2 >= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual04(){
        parse("bool x; x = 3.3 >= 2.1;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual05(){
        parse("bool x; x = 1.3 >= 2.1;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual06(){
        parse("bool x; x = 1 >= 13;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual07(){
        parse("bool x; x = 2.2 >= 2.2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual08(){
        parse("bool x; x = 3 >= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual09(){
        parse("bool x; x = 3.1 >= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual10(){
        parse("bool x; x = 3 >= 2.2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual01(){
        parse("bool x; x = 1 <= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual02(){
        parse("bool x; x = 1.3 <= 1.4;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual03(){
        parse("bool x; x = 2 <= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual04(){
        parse("bool x; x = 3.3 <= 2.1;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual05(){
        parse("bool x; x = 1.3 <= 2.1;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual06(){
        parse("bool x; x = 1 <= 13;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual07(){
        parse("bool x; x = 2.2 <= 2.2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual08(){
        parse("bool x; x = 3 <= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual09(){
        parse("bool x; x = 3.1 <= 2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual10(){
        parse("bool x; x = 3 <= 2.2;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
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
