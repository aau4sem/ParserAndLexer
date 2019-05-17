package typeChecking.listeners;

import customListeners.VariableCollectorListener;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.*;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class VariableCollectorListenerTests {
    @Test
    public void intDcl01(){
        parse("int x; x = 5;;");

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
        parse("int x; x = 5; x = 6;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void intDcl03(){
        parse("int x; int i; x = 5; i = x;;");

        VariableContainer varConI = vcl.getValueFromIdentifier("i");
        VariableContainer varConX = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varConI);
        Assert.assertNotNull(varConX);

        //Does it have the right value?
        Assert.assertEquals(5, Integer.parseInt(varConI.getValue()));
        Assert.assertEquals(5, Integer.parseInt(varConX.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varConI.getType() == VariableCollectorListener.VariableType.INT);
        Assert.assertTrue(varConX.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void intDcl04(){
        parse("int x; x = 5 + 5;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(10, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void intDcl05(){
        parse("int x; x = -5;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(-5, Integer.parseInt(varCon.getValue()));

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void floatDcl01(){
        parse("float x; x = 5.3;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(5.3, Float.parseFloat(varCon.getValue()), 10);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void floatDcl02(){
        parse("float x; x = 5.3; x = 6.3;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6.3, Float.parseFloat(varCon.getValue()), 10);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void floatDcl03(){
        parse("float x; int i; x = 5.5; i = x;;");

        VariableContainer varConI = vcl.getValueFromIdentifier("i");
        VariableContainer varConX = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varConI);
        Assert.assertNotNull(varConX);

        //Does it have the right value?
        Assert.assertEquals(5.5, Float.parseFloat(varConI.getValue()), 10);
        Assert.assertEquals(5.5, Float.parseFloat(varConX.getValue()), 10);

        //Does it have the right type?
        Assert.assertTrue(varConI.getType() == VariableCollectorListener.VariableType.INT);
        Assert.assertTrue(varConX.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void floatDcl04(){
        parse("float x; x = 5.5 + 5.5;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(11, Float.parseFloat(varCon.getValue()), 10);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void floatDcl05(){
        parse("float x; x = -5.3;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(-5.3, Float.parseFloat(varCon.getValue()), 10);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void vectorDcl01(){
        parse("vector x; x = (2,3,4);;");

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
        parse("vector x; x = (22,3);;");

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
        parse("vector x; x = (2.2,3.3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNull(vec);
    }

    @Test
    public void vectorDcl04(){
        parse("vector x; x = (-2,-3,-4);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(-2, vec.getX());
        Assert.assertEquals(-3, vec.getY());
        Assert.assertEquals(-4, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void boolDcl01(){
        parse("bool x; x = true;;");

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
        parse("string x; x = \"test\";;");

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
        parse("GamePiece x;;");

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
        parse("int x; float x; x = 6.0;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Float.parseFloat(varCon.getValue()), 2);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void mixedDcl02(){
        parse("int x; float x; x = 3 + 3;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Assert.assertEquals(6, Float.parseFloat(varCon.getValue()), 2);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.FLOAT);
    }

    @Test (expected = IllegalArgumentException.class)
    public void faulty01(){
        parse("int x; x = (2,3,1);;");
    }

    @Test (expected = IllegalArgumentException.class)
    public void faulty02(){
        parse("int x; x = true;;");
    }

    @Test (expected = IllegalArgumentException.class)
    public void faulty03(){
        parse("int x; x = \"test\";;");
    }

    @Test (expected = IllegalArgumentException.class)
    public void faulty04(){
        parse("vector x; x = 2;;");
    }
}
