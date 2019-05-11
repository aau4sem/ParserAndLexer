package typeChecking;

import customListeners.ActionCollectorListener;
import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class ProcedureTests {

    private static VariableCollectorListener vlc;
    private static ActionCollectorListener acl;

    @Test
    public void assignment01(){
        parse("proc(){}; int i; i = 5;;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment02(){
        parse("proc(){i = 5;}; int i; proc();;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment03(){
        parse("proc(int x){x = 5;}; int i; proc(i);;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment04(){
        parse("test(int a){a = 10;}; int a; a = 8; test(7);;");

        Integer a = Integer.parseInt(vlc.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void assignment05(){
        parse("test(int a){a = 5;}; int a; a = 8; test(a);;");

        Integer a = Integer.parseInt(vlc.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(5, a.intValue());
    }

    @Test
    public void assignment06(){
        parse("test(int a){a = 10;}; int a; a = 8; test(7); test(7);;");

        Integer a = Integer.parseInt(vlc.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void baseTest01(){
        parse("test(){}; int a; a = 8; test();;");

        Integer a = Integer.parseInt(vlc.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void baseTest02(){
        parse("timesTwo(int x){x = x * 2;}; int a; a = 1; timesTwo(a); timesTwo(a);;");

        Integer a = Integer.parseInt(vlc.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(4, a.intValue());
    }



    /** Parses the given input and the results can be found in the field. */
    public static void parse(String input){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream(input));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        vlc = new VariableCollectorListener();
        acl = new ActionCollectorListener(vlc);
        parser.addParseListener(vlc);
        parser.addParseListener(acl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }
}
