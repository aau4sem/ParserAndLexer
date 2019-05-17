package typeChecking.listeners;

import customListeners.VariableCollectorListener;
import model.variables.VariableContainer;
import org.junit.*;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class VariableCollectorListenerTests {

    //Declarations ---------------------------------------------------------------------------------------
    @Test
    public void declaration_int01(){
        parse("int x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.INT);
    }

    @Test
    public void declaration_float01(){
        parse("float x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.FLOAT);
    }

    @Test
    public void declaration_vector01(){
        parse("vector x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void declaration_bool01(){
        parse("bool x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.BOOL);
    }

    @Test
    public void declaration_string01(){
        parse("string x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.STRING);
    }

    @Test
    public void declaration_GamePiece01(){
        parse("GamePiece x;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right type?
        Assert.assertSame(varCon.getType(), VariableCollectorListener.VariableType.GAMEPIECE);
    }

    //Array declarations is tested in: ArrayParsingTests

    @Test
    public void assignment_int01(){
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
    public void assignment_int02(){
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
    public void assignment_int03(){
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
    public void assignment_int04(){
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
    public void assignment_float01(){
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
    public void assignment_float02(){
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
    public void assignment_float03(){
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
    public void assignment_float04(){
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
    public void assignment_string01(){
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

    @Test (expected = IllegalArgumentException.class)
    public void faulty05(){
        parse("int x; vector i; i = x.position;;");
    }
}
