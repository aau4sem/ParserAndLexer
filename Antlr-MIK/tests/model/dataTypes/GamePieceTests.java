package model.dataTypes;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class GamePieceTests {

    @Test
    public void getGamePieceString01(){
        GamePiece gp = new GamePiece();
        Assert.assertEquals("name:,position:,size:1.0,color:,label:,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString02(){
        GamePiece gp = new GamePiece();
        gp.setName("test");
        Assert.assertEquals("name:test,position:,size:1.0,color:,label:,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString03(){
        GamePiece gp = new GamePiece();
        gp.setPosition(new Vector(3, 2, 1));
        Assert.assertEquals("name:,position:(3,2,1),size:1.0,color:,label:,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString04(){
        GamePiece gp = new GamePiece();
        gp.setSize(6.4f);
        Assert.assertEquals("name:,position:,size:6.4,color:,label:,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString05(){
        GamePiece gp = new GamePiece();
        gp.setColor("RED");
        Assert.assertEquals("name:,position:,size:1.0,color:RED,label:,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString06(){
        GamePiece gp = new GamePiece();
        gp.setLabel("test");
        Assert.assertEquals("name:,position:,size:1.0,color:,label:test,opacity:1.0,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString07(){
        GamePiece gp = new GamePiece();
        gp.setOpacity(0.3f);
        Assert.assertEquals("name:,position:,size:1.0,color:,label:,opacity:0.3,shape:circle,", gp.getGamePieceString());
    }

    @Test
    public void getGamePieceString08(){
        GamePiece gp = new GamePiece();
        gp.setShape("square");
        Assert.assertEquals("name:,position:,size:1.0,color:,label:,opacity:1.0,shape:square,", gp.getGamePieceString());
    }

    @Test
    public void changeProperty01(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.NAME, "PlayerOne");
        Assert.assertEquals("PlayerOne", gp.getName());
    }

    @Test
    public void changeProperty02(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.POSITION, "(3,2,1)");
        Vector pos = gp.getPosition();
        Assert.assertEquals(3, pos.getX());
        Assert.assertEquals(2, pos.getY());
        Assert.assertEquals(1, pos.getZ());
    }

    @Test
    public void changeProperty03(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.SIZE, "2.3");
        Assert.assertEquals(2.3f, gp.getSize(), 2);
    }

    @Test
    public void changeProperty04(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.COLOR, "RED");
        Assert.assertEquals("RED", gp.getColor());
    }

    @Test
    public void changeProperty05(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.LABEL, "PlayerOne");
        Assert.assertEquals("PlayerOne", gp.getLabel());
    }

    @Test
    public void changeProperty06(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.OPACITY, "2.5");
        Assert.assertEquals(2.5f, gp.getOpacity(), 3);
    }

    @Test
    public void changeProperty07(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.SHAPE, "square");
        Assert.assertEquals("square", gp.getShape());
    }

    @Test
    public void changeProperty08(){
        GamePiece gp = new GamePiece();
        gp.changeProperty(GamePiece.GamePiecePropertyType.NAME, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.POSITION, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.SIZE, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.COLOR, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.LABEL, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.OPACITY, "");
        gp.changeProperty(GamePiece.GamePiecePropertyType.SHAPE, "");

        Assert.assertNull(gp.getPosition());
        Assert.assertEquals(1f, gp.getSize().floatValue(), 4);
        Assert.assertNull(gp.getColor());
        Assert.assertEquals("", gp.getLabel());
        Assert.assertEquals(1f, gp.getOpacity(), 4);
        Assert.assertEquals("circle", gp.getShape());
    }
}
