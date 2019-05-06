package typeChecking.listeners;

import customListeners.VariableCollectorListener;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;
import gen.*;

public class VariableCollectorListenerTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @Test
    public void intDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("int x = 5;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(5, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void intDcl02(){
        lexer = new TacticLexer(new ANTLRInputStream("int x = 5; x = 6;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    /** Overwrite value*/
    @Test
    public void intDcl03(){
        lexer = new TacticLexer(new ANTLRInputStream("int x = 5; int x = 6;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void intDcl04(){
        lexer = new TacticLexer(new ANTLRInputStream("int x = 5; int i = x;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("i");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(5, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void floatDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("float x = 5.3;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(5.3, Float.parseFloat(varCon.getValue()),4);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void floatDcl02(){
        lexer = new TacticLexer(new ANTLRInputStream("float x = 5.3; float y = x;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("y");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(5.3, Float.parseFloat(varCon.getValue()),4);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void vectorDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("vector x = (2,3,4);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(2, vec.getX());
        Assert.assertEquals(3, vec.getY());
        Assert.assertEquals(4, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void vectorDcl02(){
        lexer = new TacticLexer(new ANTLRInputStream("vector x = (22,3);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(22, vec.getX());
        Assert.assertEquals(3, vec.getY());
        Assert.assertEquals(-1, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void vectorDcl03(){
        lexer = new TacticLexer(new ANTLRInputStream("vector x = (2.2,3.3);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(2.2, vec.getX());
        Assert.assertEquals(3.3, vec.getY());
        Assert.assertEquals(-1, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void boolDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("bool x = true;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertTrue(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test
    public void stringDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("string x = \"test\";"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        String x = varCon.getValue();
        Assert.assertNotNull(x);
        Assert.assertEquals("test", x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.STRING);
    }

    @Test
    public void gamePieceDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece x;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        GamePiece x = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(x);
        //Assert.assertEquals("test", x); //TODO assert propperties

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.GAMEPIECE);
    }

    @Test
    public void mixedDcl01(){
        lexer = new TacticLexer(new ANTLRInputStream("int x = 5; float x = 6.0;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Float.parseFloat(varCon.getValue()), 2);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }
}
