package typeChecking;

import customListeners.VariableCollectorListener;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class VectorParsingTests {

    @Test
    public void assignment01(){
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
    public void assignment02(){
        parse("vector x; x = (22,3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(22, vec.getX());
        Assert.assertEquals(3, vec.getY());
        Assert.assertEquals(0, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    /*@Test //float vectors are currently not supported
    public void vectorDcl03(){
        parse("vector x; x = (2.2,3.3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNull(vec);
    }*/

    @Test
    public void assignment04(){
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
    public void assignment05(){
        parse("vector x; x = (-2,-3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(-2, vec.getX());
        Assert.assertEquals(-3, vec.getY());
        Assert.assertEquals(0, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment06(){
        parse("vector x; vector y; y = (2,3,1); x = y;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(2, vec.getX());
        Assert.assertEquals(3, vec.getY());
        Assert.assertEquals(1, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment07(){
        parse("vector x; vector y; y = (2,3); x = y;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(2, vec.getX());
        Assert.assertEquals(3, vec.getY());
        Assert.assertEquals(0, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment08(){
        parse("vector x; x = (2 + 2, 1, 3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(4, vec.getX());
        Assert.assertEquals(1, vec.getY());
        Assert.assertEquals(3, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment09(){
        parse("vector x; int y; y = 2; x = (2 + y, 1, 3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(4, vec.getX());
        Assert.assertEquals(1, vec.getY());
        Assert.assertEquals(3, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment10(){
        parse("vector x; int y; y = 2; x = (2 + y + (3 * 3) - 2, 1, 3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(11, vec.getX());
        Assert.assertEquals(1, vec.getY());
        Assert.assertEquals(3, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void assignment11(){
        parse("int i; vector x; i = 4; x = (i, 1, 3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Vector vec = TypeCheckerHelper.parseVector(varCon.getValue());
        Assert.assertNotNull(vec);
        Assert.assertEquals(4, vec.getX());
        Assert.assertEquals(1, vec.getY());
        Assert.assertEquals(3, vec.getZ());

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.VEC);
    }

    @Test
    public void add01(){
        parse("vector i; i = (5,5,5) + (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(7, i.getX());
        Assert.assertEquals(7, i.getY());
        Assert.assertEquals(7, i.getZ());
    }

    @Test
    public void add02(){
        parse("vector i; i = (5,5,5) + (2,2,2) + (3,3,3);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.getX());
        Assert.assertEquals(10, i.getY());
        Assert.assertEquals(10, i.getZ());
    }

    @Test
    public void add03(){
        parse("vector i; vector x; x = (1,1,1); i = (5,5,5) - x; i = i + x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.getX());
        Assert.assertEquals(5, i.getY());
        Assert.assertEquals(5, i.getZ());
    }

    @Test
    public void add04(){
        parse("vector i; vector x; vector y; x = (1,1,1); y = (5,5,5); i = y + x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(6, i.getX());
        Assert.assertEquals(6, i.getY());
        Assert.assertEquals(6, i.getZ());
    }

    @Test
    public void sub01(){
        parse("vector i; i = (5,5,5) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(3, i.getX());
        Assert.assertEquals(3, i.getY());
        Assert.assertEquals(3, i.getZ());
    }

    @Test
    public void sub02(){
        parse("vector i; i = (5,5,5) - (2,2,2) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(1, i.getX());
        Assert.assertEquals(1, i.getY());
        Assert.assertEquals(1, i.getZ());
    }

    @Test
    public void sub03(){
        parse("vector i; vector x; x = (1,1,1); i = (5,5,5) - x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.getX());
        Assert.assertEquals(4, i.getY());
        Assert.assertEquals(4, i.getZ());
    }

    @Test
    public void sub05(){
        parse("vector i; vector y; vector x; x = (1,1,1); y = (5,5,5); i = y - x;;");
        //parse("vector i; vector x; x = (1,1,1); i = (5,5,5) - x; i = i - x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.getX());
        Assert.assertEquals(4, i.getY());
        Assert.assertEquals(4, i.getZ());
    }

    @Test (expected = Exception.class)
    public void faulty01(){
        parse("vector x; x = \"test\";");
    }

    @Test (expected = Exception.class)
    public void faulty02(){
        parse("vector x; x = 2;");
    }

    @Test (expected = Exception.class)
    public void faulty03(){
        parse("vector x; x = 2.3;");
    }

    @Test (expected = Exception.class)
    public void faulty04(){
        parse("vector x; GamePiece y; x = y;;");
    }
}
