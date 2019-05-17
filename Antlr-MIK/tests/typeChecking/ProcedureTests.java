package typeChecking;

import model.dataTypes.GamePiece;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class ProcedureTests {

    @Test
    public void assignment01(){
        parse("proc(){}; int i; i = 5;;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment02(){
        parse("proc(){i = 5;}; int i; proc();;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment03(){
        parse("proc(int x){x = 5;}; int i; proc(i);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void assignment04(){
        parse("test(int a){a = 10;}; int a; a = 8; test(7);;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void assignment05(){
        parse("test(int a){a = 5;}; int a; a = 8; test(a);;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(5, a.intValue());
    }

    @Test
    public void assignment06(){
        parse("test(int a){a = 10;}; int a; a = 8; test(7); test(7);;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void baseTest01(){
        parse("test(){}; int a; a = 8; test();;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(8, a.intValue());
    }

    @Test
    public void baseTest02(){
        parse("timesTwo(int x){x = x * 2;}; int a; a = 1; timesTwo(a); timesTwo(a);;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(4, a.intValue());
    }

    @Test
    public void statement_dotAssignment01(){
        parse("proc(GamePiece gp){gp.label = \"TestLabel\";}; GamePiece a; proc(a);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("a");
        Assert.assertNotNull(varCon);
        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertEquals("TestLabel", gp.getLabel());
    }

    @Test
    public void statement_arrayAssignment01(){
        parse("proc(){i[0] = 2;}; int[2] i; proc(i);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("i");
        Assert.assertNotNull(varCon);

        //TODO Create asserts when array is implemented in compiler
    }

    @Test
    public void statement_condStmt01(){
        parse("proc(bool x){if(x){i = 10;};}; int i; i = 5; proc(true);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }


    @Test
    public void statement_condStmt02(){
        parse("proc(bool x){if(x){i = 10;};}; int i; i = 5; proc(false);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void statement_whileStmt01(){
        parse("proc(bool x){while(x){i = 10; x = false;};}; int i; i = 5; proc(true);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }
}
