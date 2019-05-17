package typeChecking;

import customListeners.VariableCollectorListener;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class BooleanParsingTests {

    @Test
    public void equal01(){
        parse("bool x; x = true == true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal02(){
        parse("bool x; x = false == false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void equal03(){
        parse("bool x; x = true == false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal04(){
        parse("bool x; x = false == true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal05(){
        parse("bool x; x = 5 == 3;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void equal06(){
        parse("bool x; x = 5 == 5;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lesser01(){
        parse("bool x; x = 4 > 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lesser02(){
        parse("bool x; x = 1 > 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greater01(){
        parse("bool x; x = 4 < 10;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greater02(){
        parse("bool x; x = 5 < 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void or01(){
        parse("bool x; x = true || true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void or02(){
        parse("bool x; x = false || false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void or03(){
        parse("bool x; x = true || false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void or04(){
        parse("bool x; x = false || true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void and01(){
        parse("bool x; x = true && true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void and02(){
        parse("bool x; x = false && false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void and03(){
        parse("bool x; x = true && false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void and04(){
        parse("bool x; x = false && true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    /*@Test
    public void not01(){
        parse("bool x; x = !true;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void not02(){
        parse("bool x; x = !false;;");

        String x = vlc.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }*/

    @Test
    public void notequal01(){
        parse("bool x; x = true != true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal02(){
        parse("bool x; x = false != false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal03(){
        parse("bool x; x = true != false;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal04(){
        parse("bool x; x = false != true;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal05(){
        parse("bool x; x = 2 != 5;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal06(){
        parse("bool x; x = 2.4 != 1.2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void notequal07(){
        parse("bool x; x = 2.4 != 2.4;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void notequal08(){
        parse("bool x; x = 2 != 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual01(){
        parse("bool x; x = 1 >= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual02(){
        parse("bool x; x = 1.3 >= 1.4;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual03(){
        parse("bool x; x = 2 >= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual04(){
        parse("bool x; x = 3.3 >= 2.1;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual05(){
        parse("bool x; x = 1.3 >= 2.1;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual06(){
        parse("bool x; x = 1 >= 13;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void greaterOrEqual07(){
        parse("bool x; x = 2.2 >= 2.2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual08(){
        parse("bool x; x = 3 >= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual09(){
        parse("bool x; x = 3.1 >= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void greaterOrEqual10(){
        parse("bool x; x = 3 >= 2.2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual01(){
        parse("bool x; x = 1 <= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual02(){
        parse("bool x; x = 1.3 <= 1.4;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual03(){
        parse("bool x; x = 2 <= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual04(){
        parse("bool x; x = 3.3 <= 2.1;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual05(){
        parse("bool x; x = 1.3 <= 2.1;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual06(){
        parse("bool x; x = 1 <= 13;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual07(){
        parse("bool x; x = 2.2 <= 2.2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertTrue(value);
    }

    @Test
    public void lessOrEqual08(){
        parse("bool x; x = 3 <= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual09(){
        parse("bool x; x = 3.1 <= 2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    @Test
    public void lessOrEqual10(){
        parse("bool x; x = 3 <= 2.2;;");

        String x = vcl.getValueFromIdentifier("x").getValue();

        if(x.compareTo("true") != 0 && x.compareTo("false") != 0)
            Assert.fail();

        boolean value = Boolean.parseBoolean(x);

        Assert.assertFalse(value);
    }

    //Assignments ----------------------------------------------------------------------------------------
    @Test
    public void assignment01(){
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
    public void assignment02(){
        parse("bool x; x = false;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test (expected = Exception.class)
    public void assignment03(){
        parse("bool x; x = 2;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test (expected = Exception.class)
    public void assignment04(){
        parse("bool x; x = 2.0;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test (expected = Exception.class)
    public void assignment05(){
        parse("bool x; x = \"test\";;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test (expected = Exception.class)
    public void assignment06(){
        parse("bool x; x = (2,2,3);;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }

    @Test (expected = Exception.class)
    public void assignment07(){
        parse("bool x; GamePiece gp; x = gp;;");

        VariableContainer varCon = vcl.getValueFromIdentifier("x");

        //Was it saved?
        Assert.assertNotNull(varCon);

        //Does it have the right value?
        Boolean x = TypeCheckerHelper.parseBool(varCon.getValue());
        Assert.assertNotNull(x);
        Assert.assertFalse(x);

        //Does it have the right type?
        Assert.assertTrue(varCon.getType() == VariableCollectorListener.VariableType.BOOL);
    }
}
