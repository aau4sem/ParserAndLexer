package typeChecking;

import model.dataTypes.GamePiece;
import model.utils.TypeCheckerHelper;

import org.junit.Assert;
import org.junit.Test;

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
        parse("int i; i = 5; while(false){ Move(gp, (2,2,3), 20);};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_block02(){
        parse("int i; i = 5; while(false){ Change(gp, \"position\", (2,3,2), 20);};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_block03(){
        parse("int i; i = 5; while(false){ Wait(gp, 20);};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    //TODO All stmts

    //@Test //Endless loop
    public void while_general02(){
        parse("int i; i = 5; while(true){ i = 6;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.intValue());
    }

    @Test
    public void while_general03(){
        parse("int i; i = 5; while(false){ i = 6;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_general04(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void while_stmt_dotAssignment01(){
        parse("GamePiece gp; int i; i = 0; while(i < 1){i = 2; gp.label = \"test\";};;");

        GamePiece gp = TypeCheckerHelper.parseGamePiece(vcl.getValueFromIdentifier("gp").getValue());

        Assert.assertNotNull(gp);
        Assert.assertEquals(0, gp.getLabel().compareTo("test"));
    }

    @Test //TODO arrays are not yet implemented
    public void while_stmt_arrayAssignment01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void while_stmt_procedureCall01(){
        parse("proc(){i = 5;}; int i; i = 0; while(i < 3){ proc();};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    public void while_stmt_procedureCall02(){
        parse("proc(x){x = x + 1;}; int x; int i; i = 0; x = 0; while(i < 3){ i = i + 1; proc(x);};;");

        Integer x = Integer.parseInt(vcl.getValueFromIdentifier("x").getValue());
        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(x);
        Assert.assertNotNull(i);
        Assert.assertEquals(3, x.intValue());
        Assert.assertEquals(3, i.intValue());
    }

    @Test
    public void while_stmt_condStmt01(){
        parse("int i; int x; i = 0; x = 0; while(i < 1){i = i + 1; if(true){x = 1;};};;");

        Integer x = Integer.parseInt(vcl.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1, x.intValue());
    }

    @Test
    public void while_stmt_condStmt02(){
        parse("int i; int x; i = 0; x = 0; while(i < 1){i = i + 1; if(false){x = 1;};};;");

        Integer x = Integer.parseInt(vcl.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0, x.intValue());
    }

    @Test //TODO
    public void while_stmt_whileStmt01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test //TODO
    public void while_stmt_assignment01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test //TODO
    public void while_stmt_action01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
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
    public void ifThenElse01(){
        parse("testTODO");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }
}
