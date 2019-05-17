package typeChecking;

import model.dataTypes.GamePiece;
import model.utils.TypeCheckerHelper;

import model.utils.buildInFunction.BuildInFunctionChange;
import model.utils.buildInFunction.BuildInFunctionMove;
import model.utils.buildInFunction.BuildInFunctionWait;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.acl;
import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class ConditionalAndControlTests {

    // WHILE STMTS ----------------------------------------------------

    @Test
    public void while_condition01(){
        parse("int i; i = 0; while(true){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition02(){
        parse("int i; i = 0; while(false){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_condition03(){
        parse("int i; bool y; y = true; i = 0; while(y){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition04(){
        parse("int i; bool y; y = false; i = 0; while(y){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_condition05(){
        parse("int i; i = 0; while(2 == 2){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition06(){
        parse("int i; i = 0; while(2 == 3){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_condition07(){
        parse("int i; i = 0; while(2 != 4){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition08(){
        parse("int i; i = 0; while(2 != 2){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_condition09(){
        parse("int i; i = 0; while(true && true){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition10(){
        parse("int i; i = 0; while(true && false){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_condition11(){
        parse("int i; i = 0; while(false || true){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition12(){
        parse("int i; i = 0; while(true || false){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_condition13(){
        parse("int i; i = 0; while(false || false){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(0, i.intValue());
    }

    @Test
    public void while_general01(){
        parse("int i; i = 0; while(i < 5){ i = 5;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_block01(){
        parse("int i; GamePiece gp; i = 5; while(i > 4){ Move(gp, (2,2,3), 20); i = 4;};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionMove);
    }

    @Test
    public void while_block02(){
        parse("int i; GamePiece gp; i = 5; while(i > 4){ Change(gp, \"position\", (2,3,2), 20); i = 4;};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionChange);
    }

    @Test
    public void while_block03(){
        parse("int i; GamePiece gp; i = 5; while(i > 4){ Wait(gp, 20); i = 4;};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionWait);
    }

    @Test
    public void while_block04(){
        parse("int i; int[4] x; i = 5; while(i > 4){ i = x.length;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void while_block05(){
        parse("int i; int[4] x; i = 5; while(i > 4){ i = x.length; x[0] = 10;};;");

        VariableContainer x = vcl.getArrayValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertTrue(x.isArray());

        //Check default values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(x.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(10, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(1, array[3].intValue());
    }

    @Test
    public void while_block07(){
        parse("proc(){i = 4;};int i; i = 5; while(i > 4){proc();};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void while_block08(){
        //TODO notworking
        Assert.fail();
        parse("int i; i = 5; while(i > 4){if(true){i = 4;};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void while_block09(){
        //TODO notworking
        Assert.fail();
        parse("int i; i = 5; while(i > 4){if(true){i = 4;}else{i = 2};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void while_block10(){
        //TODO notworking
        Assert.fail();
        parse("int i; i = 5; while(i > 4){if(false){i = 4;}else{i = 2};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(2, i.intValue());
    }

    @Test
    public void while_block11(){
        parse("int i; i = 5; while(i > 4){while(i > 4){i = 4;};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void while_block12(){
        parse("int i; int x; x = 10; i = 5; while(i > 4){while(false){x = 4;}; i = 4;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());
        Integer x = Integer.parseInt(vcl.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(i);
        Assert.assertNotNull(x);
        Assert.assertEquals(4, i.intValue());
        Assert.assertEquals(10, x.intValue());
    }

    // IF STMTS -------------------------------------------------------

    @Test
    public void if01(){
        parse("int i; i = 5; if(true){i = 6;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.intValue());
    }

    @Test
    public void if02() {
        parse("int i; i = 5; if(false){i = 6;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void ifelse01(){
        parse("int i; i = 5; if(true){i = 6;}else{i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.intValue());
    }

    @Test
    public void ifelse02(){
        parse("int i; i = 5; if(false){i = 6;}else{i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void if_block01(){
        parse("int i; int[4] x; i = 5; if(true){i = x.length;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void if_block02(){
        parse("int x; int[4] i; x = 5; if(true){i[3] = x;};;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(5, array[3].intValue());
    }

    @Test
    public void if_block03(){
        parse("proc(){i = 10;}; int i; i = 5; if(true){proc();};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void if_block04(){
        parse("int i; i = 5; if(true){if(true){i = 10;};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void if_block05(){
        parse("int i; i = 5; if(true){if(false){i = 3;}else{i = 10;};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void if_block06(){
        parse("int i; i = 5; if(true){while(i > 4){i = 4;};};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.intValue());
    }

    @Test
    public void if_block07(){
        parse("int i; GamePiece gp; i = 5; if(true){Move(gp, (2,2,3), 20);};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionMove);
    }

    @Test
    public void if_block08(){
        parse("int i; GamePiece gp; i = 5; if(true){Change(gp, \"position\", (2,3,2), 20);};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionChange);
    }

    @Test
    public void if_block09(){
        parse("int i; GamePiece gp; i = 5; if(true){Wait(gp, 20); i = 4;};;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
        Assert.assertTrue(acl.getActionFunctions().get(0) instanceof BuildInFunctionWait);
    }
}
