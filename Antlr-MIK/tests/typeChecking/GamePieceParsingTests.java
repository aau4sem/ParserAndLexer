package typeChecking;

import gen.Tactic;
import gen.TacticLexer;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class GamePieceParsingTests {

    @Test
    public void propertyDefaultValues01(){
        parse("GamePiece gp;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals(0,gp.getPosition().getX());
        Assert.assertEquals(0,gp.getPosition().getY());
        Assert.assertEquals(0,gp.getPosition().getZ());
        Assert.assertEquals(1f, gp.getSize().floatValue(), 4);
        Assert.assertEquals("red", gp.getColor());
        Assert.assertEquals("", gp.getLabel());
        Assert.assertEquals(1f, gp.getOpacity(), 4);
        Assert.assertEquals("circle", gp.getShape());
    }

    @Test
    public void propertyChangeVector01(){
        parse("GamePiece gp; gp.position = (2,3,1);;");

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
        parse("GamePiece gp; gp.size = 2.56;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals(2.56f, gp.getSize().floatValue(), 4);
    }

    @Test
    public void propertyChangeColor01(){
        parse("GamePiece gp; gp.color = \"RED\";;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("RED", gp.getColor());
    }

    @Test
    public void propertyChangeColor02(){
        parse("GamePiece gp; gp.color = \"rgb(3,2,3)\";;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("rgb(3,2,3)", gp.getColor());
    }

    @Test(expected = IllegalArgumentException.class)
    public void propertyChangeColor03(){
        parse("GamePiece gp; gp.color = \"rgb(3,2,3,4)\";;");

        Assert.fail();
    }

    @Test
    public void propertyChangeLabel01(){
        parse("GamePiece gp; gp.label = \"PlayerOne\";;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("PlayerOne", gp.getLabel());
    }

    @Test
    public void propertyChangeOpacity01(){
        parse("GamePiece gp; gp.opacity = 0.3;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals(0.3f, gp.getOpacity(), 3);
    }

    @Test
    public void propertyChangeShape01(){
        parse("GamePiece gp; gp.shape = \"Square\";;");

        VariableContainer varCon = vcl.getValueFromIdentifier("gp");
        Assert.assertNotNull(varCon);

        GamePiece gp = TypeCheckerHelper.parseGamePiece(varCon.getValue());
        Assert.assertNotNull(gp);

        Assert.assertEquals("Square", gp.getShape());
    }
}
