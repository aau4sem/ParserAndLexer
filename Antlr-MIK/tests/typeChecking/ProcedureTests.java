package typeChecking;

import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunctionWait;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;
import testUtilities.TestUtils;

import static testUtilities.TestUtils.acl;
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

        Assert.fail();
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
    public void statement_condStmt03(){
        parse("proc(bool x){if(x){i = 10;}else{i = 0;};}; int i; i = 5; proc(false);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void statement_condStmt04(){
        parse("proc(bool x){if(x){i = 10;}else{i = 0;};}; int i; i = 5; proc(true);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void statement_condStmt05(){
        parse("proc(bool x){if(x){i = 10;}else{i = 0; i = 3; i = i * 2;};}; int i; i = 5; proc(false);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.intValue());
    }

    @Test
    public void statement_whileStmt01(){
        parse("proc(bool x){while(x){i = 10; x = false;};}; int i; i = 5; proc(true);;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void statement_action01(){
        parse("proc(){Move(gp, (2,2,3), 20);}; GamePiece gp; proc();;");

        Assert.assertEquals(1, acl.getCollectedActionCalls().size());
        Assert.assertTrue(acl.getCollectedActionCalls().get(0) instanceof BuildInFunctionMove);
    }

    @Test
    public void statement_action02(){
        parse("proc(){Change(gp, \"position\", (2,3,2), 20);}; GamePiece gp; proc();;");

        Assert.assertEquals(1, acl.getCollectedActionCalls().size());
        Assert.assertTrue(acl.getCollectedActionCalls().get(0) instanceof BuildInFunctionChange);
    }

    @Test
    public void statement_action03(){
        parse("proc(){Wait(gp, 20);}; GamePiece gp; proc();;");

        Assert.assertEquals(1, acl.getCollectedActionCalls().size());
        Assert.assertTrue(acl.getCollectedActionCalls().get(0) instanceof BuildInFunctionWait);
    }

    @Test
    public void statement_assignment01(){
        parse("test(){a = 5;}; int a; test();;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(5, a.intValue());
    }

    @Test
    public void parameter01(){
        parse("test(int x){ x = 5;}; int a; test(a);;");

        Integer a = Integer.parseInt(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(5, a.intValue());
    }

    @Test
    public void parameter02(){
        parse("test(float x){ x = 5.5;}; float a; test(a);;");

        Float a = Float.parseFloat(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertEquals(5.5, a, 10);
    }

    @Test
    public void parameter03(){
        parse("test(bool x){ x = true;}; bool a; a = false; test(a);;");

        Boolean a = Boolean.parseBoolean(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertTrue(a);
    }

    @Test
    public void parameter04(){
        parse("test(String x){ x = \"test\";}; string a; a = \"temp\"; test(a);;");

        String a = vcl.getValueFromIdentifier("a").getValue();

        Assert.assertNotNull(a);
        Assert.assertEquals(a, "test");
    }

    @Test
    public void parameter05(){
        parse("test(GamePiece x){ x.position = (4,4,4);}; GamePiece a; test(a);;");

        GamePiece a = TypeCheckerHelper.parseGamePiece(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertTrue(TestUtils.isVectorsValuesEqual(a.getPosition(), new Vector(4,4,4)));
    }

    @Test
    public void parameter06(){
        parse("test(vector x){ x = (4,4,4);}; vector a; test(a);;");

        Vector a = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("a").getValue());

        Assert.assertNotNull(a);
        Assert.assertTrue(TestUtils.isVectorsValuesEqual(a, new Vector(4,4,4)));
    }

    @Test
    public void parameter07(){
        parse("test(int[] x){x[3] = 5;}; int[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(a.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(5, array[3].intValue());
    }

    @Test
    public void parameter08(){
        parse("test(float[] x){ x[3] = 5.5;}; float[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        Float[] array = TypeCheckerHelper.parseFloatArray(a.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0], 10);
        Assert.assertEquals(1, array[1], 10);
        Assert.assertEquals(1, array[2], 10);
        Assert.assertEquals(5.5, array[3], 10);
    }

    @Test
    public void parameter09(){
        parse("test(bool[] x){ x[3] = true;}; bool[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        Boolean[] array = TypeCheckerHelper.parseBooleanArray(a.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue( array[0]);
        Assert.assertTrue(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertFalse(array[3]);
    }

    @Test
    public void parameter10(){
        parse("test(String[] x){ x[3] = \"test\";}; string[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        String[] array = TypeCheckerHelper.parseStringArray(a.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals("", array[0]);
        Assert.assertEquals("", array[1]);
        Assert.assertEquals("", array[2]);
        Assert.assertEquals("test", array[3]);
    }

    @Test
    public void parameter11(){
        parse("test(GamePiece[] x){ x[3].position = (4,4,4);}; GamePiece[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(a.getValue());
        Assert.assertEquals(4, array.length);
        TestUtils.isVectorsValuesEqual(new Vector(4,4,4), array[3].getPosition());
    }

    @Test
    public void parameter12(){
        parse("test(vector[] x){ x[3] = (4,4,4);}; vector[4] a; test(a);;");

        VariableContainer a = vcl.getArrayValueFromScope("a");

        Assert.assertNotNull(a);
        Assert.assertTrue(a.isArray());

        //Check values
        Vector[] array = TypeCheckerHelper.parseVectorArray(a.getValue());
        Assert.assertEquals(4, array.length);
        TestUtils.isVectorsValuesEqual(new Vector(0,0,0), array[0]);
        TestUtils.isVectorsValuesEqual(new Vector(0,0,0), array[1]);
        TestUtils.isVectorsValuesEqual(new Vector(0,0,0), array[2]);
        TestUtils.isVectorsValuesEqual(new Vector(4,4,4), array[3]);
    }

    @Test
    public void parameter13(){
        parse("test(String a, int b, float c, vector d, GamePiece e, bool f)" +
                "{a = \"test\"; b = 10; c = 6.5; d = (2,3,3); e.position (5,5,2); f = false;}; " +
                "string aa; int bb; float cc; vector dd; GamePiece ee; bool ff;" +
                "test(aa, bb, cc, dd, ee, ff);;");

        String aa = vcl.getValueFromIdentifier("aa").getValue();
        Integer bb = TypeCheckerHelper.parseInt(vcl.getValueFromIdentifier("bb").getValue());
        Float cc = TypeCheckerHelper.parseFloat(vcl.getValueFromIdentifier("cc").getValue());
        Vector dd = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("dd").getValue());
        GamePiece ee = TypeCheckerHelper.parseGamePiece(vcl.getValueFromIdentifier("ee").getValue());
        Boolean ff = TypeCheckerHelper.parseBool(vcl.getValueFromIdentifier("ff").getValue());

        Assert.assertNotNull(aa);
        Assert.assertNotNull(bb);
        Assert.assertNotNull(cc);
        Assert.assertNotNull(dd);
        Assert.assertNotNull(ee);
        Assert.assertNotNull(ff);

        Assert.assertEquals("test", aa);
        Assert.assertEquals(10, bb.intValue());
        Assert.assertEquals(6.5, cc, 10);
        Assert.assertTrue(TestUtils.isVectorsValuesEqual(new Vector(2,3,3), dd));
        Assert.assertTrue(TestUtils.isVectorsValuesEqual(new Vector(5,5,2), ee.getPosition()));
        Assert.assertFalse(ff);
    }
}
