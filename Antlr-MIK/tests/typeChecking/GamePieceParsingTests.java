package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class GamePieceParsingTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @Test
    public void propertyDefaultValues01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp;;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertNull(gp.getPosition());
        Assert.assertEquals(1f, gp.getSize().floatValue(), 4);
        Assert.assertNull(gp.getColor());
        Assert.assertEquals("", gp.getLabel());
        Assert.assertEquals(1f, gp.getOpacity(), 4);
        Assert.assertEquals("circle", gp.getShape());
    }

    @Test
    public void propertyChangeVector01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.position = (2,3,1);;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Vector position = gp.getPosition();
        Assert.assertNotNull(position);

        Assert.assertEquals(2, position.getX());
        Assert.assertEquals(3, position.getY());
        Assert.assertEquals(1, position.getZ());
    }

    @Test
    public void propertyChangeSize01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.size = 2.56;;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals(2.56f, gp.getSize().floatValue(), 4);
    }

    @Test
    public void propertyChangeColor01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.color = \"RED\";;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("RED", gp.getColor());
    }

    @Test
    public void propertyChangeLabel01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.label = \"PlayerOne\";;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("PlayerOne", gp.getLabel());
    }

    @Test
    public void propertyChangeOpacity01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.opacity = 0.3;;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals(0.3f, gp.getOpacity(), 3);
    }

    @Test
    public void propertyChangeShape01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece gp; gp.shape = \"Square\";;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        parser.addParseListener(vcl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("Square", gp.getShape());
    }
}
