package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.dataTypes.GamePiece;
import model.utils.TypeCheckerHelper;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class ConditionalAndControlTests {

    private static VariableCollectorListener vlc;

    @Test
    public void while_general01(){
        parse("int i; i = 0; while(i < 5){ i = 5;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    //@Test //Endless loop
    public void while_general02(){
        parse("int i; i = 5; while(true){ i = 6;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.intValue());
    }

    @Test
    public void while_general03(){
        parse("int i; i = 5; while(false){ i = 6;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_general04(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void while_stmt_dotAssignment01(){
        parse("GamePiece gp; int i; i = 0; while(i < 1){i = 2; gp.label = \"test\";};;");

        GamePiece gp = TypeCheckerHelper.parseGamePiece(vlc.getValueFromIdentifier("gp").getValue());

        Assert.assertNotNull(gp);
        Assert.assertEquals(0, gp.getLabel().compareTo("test"));
    }

    @Test //TODO arrays are not yet implemented
    public void while_stmt_arrayAssignment01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test
    public void while_stmt_procedureCall01(){
        parse("proc(){i = 5;}; int i; i = 0; while(i < 3){ proc();};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void while_stmt_procedureCall02(){
        parse("proc(x){x = x + 1;}; int x; int i; i = 0; x = 0; while(i < 3){ i = i + 1; proc(x);};;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());
        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(x);
        Assert.assertNotNull(i);
        Assert.assertEquals(3, x.intValue());
        Assert.assertEquals(3, i.intValue());
    }

    @Test
    public void while_stmt_condStmt01(){
        parse("int i; int x; i = 0; x = 0; while(i < 1){i = i + 1; if(true){x = 1;};};;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(1, x.intValue());
    }

    @Test
    public void while_stmt_condStmt02(){
        parse("int i; int x; i = 0; x = 0; while(i < 1){i = i + 1; if(false){x = 1;};};;");

        Integer x = Integer.parseInt(vlc.getValueFromIdentifier("x").getValue());

        Assert.assertNotNull(x);
        Assert.assertEquals(0, x.intValue());
    }

    @Test //TODO
    public void while_stmt_whileStmt01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test //TODO
    public void while_stmt_assignment01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }

    @Test //TODO
    public void while_stmt_action01(){
        parse("int i; i = 0; while(i < 10){ i = 2; i = i + 2; i = 10;};;");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.intValue());
    }


    @Test
    public void ifThenElse01(){
        parse("testTODO");

        Integer i = Integer.parseInt(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
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
