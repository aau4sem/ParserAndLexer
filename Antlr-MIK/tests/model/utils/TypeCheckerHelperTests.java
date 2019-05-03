package model.utils;

import model.dataTypes.Number;
import model.dataTypes.Vector;
import org.junit.*;

public class TypeCheckerHelperTests {

    @Test
    public void parseBool01(){
        String input = "true";
        Boolean output = TypeCheckerHelper.parseBool(input);
        Assert.assertNotNull(output);
        Assert.assertTrue(output);
    }

    @Test
    public void parseBool02(){
        String input = "false";
        Boolean output = TypeCheckerHelper.parseBool(input);
        Assert.assertNotNull(output);
        Assert.assertFalse(output);
    }

    @Test
    public void parseBool03(){
        String input = "tue";
        Boolean output = TypeCheckerHelper.parseBool(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseBool04(){
        String input = "";
        Boolean output = TypeCheckerHelper.parseBool(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseNumber01(){
        String input = "2";
        Number output = TypeCheckerHelper.parseNumber(input);
        Assert.assertNotNull(output);
        Assert.assertNull(output.getFloatValue());
        Assert.assertEquals(2, output.getIntValue().intValue());
    }

    @Test
    public void parseNumber02(){
        String input = "2.3";
        Number output = TypeCheckerHelper.parseNumber(input);
        Assert.assertNotNull(output);
        Assert.assertNull(output.getIntValue());
        Assert.assertEquals(2.3, output.getFloatValue(), 2);
    }

    @Test
    public void parseNumber03(){
        String input = "";
        Number output = TypeCheckerHelper.parseNumber(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseNumber04(){
        String input = "(3,2,4)";
        Number output = TypeCheckerHelper.parseNumber(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseInt01(){
        String input = "2";
        Integer output = TypeCheckerHelper.parseInt(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.intValue());
    }

    @Test
    public void parseInt02(){
        String input = "2.3";
        Integer output = TypeCheckerHelper.parseInt(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseInt03(){
        String input = "(3,2,4)";
        Integer output = TypeCheckerHelper.parseInt(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseFloat01(){
        String input = "2.4";
        Float output = TypeCheckerHelper.parseFloat(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(2.4, output.floatValue(),2);
    }

    @Test
    public void parseFloat02(){
        String input = "2";
        Float output = TypeCheckerHelper.parseFloat(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(2, output.floatValue(),2);
    }

    @Test
    public void parseFloat03(){
        String input = "(3,2,4)";
        Float output = TypeCheckerHelper.parseFloat(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseFloat04(){
        String input = "";
        Float output = TypeCheckerHelper.parseFloat(input);
        Assert.assertNull(output);
    }

    //TODO GamePiece parsing tests

    @Test
    public void parseVector01(){
        String input = "(1,4,2)";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(1, output.getX());
        Assert.assertEquals(4, output.getY());
        Assert.assertEquals(2, output.getZ());
    }

    @Test
    public void parseVector02(){
        String input = "(1,4)";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNotNull(output);
        Assert.assertEquals(1, output.getX());
        Assert.assertEquals(4, output.getY());
        Assert.assertEquals(-1, output.getZ());
    }

    @Test
    public void parseVector03(){
        String input = "";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector04(){
        String input = "2";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector05(){
        String input = "test";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector06(){
        String input = "2,3,2";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector07(){
        String input = "(2,3,2";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector08(){
        String input = "()";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }

    @Test
    public void parseVector09(){
        String input = "(2.0, 2.0)";
        Vector output = TypeCheckerHelper.parseVector(input);
        Assert.assertNull(output);
    }
}
