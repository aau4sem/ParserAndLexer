package typeChecking;

import customListeners.VariableCollectorListener;
import model.dataTypes.GamePiece;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import model.variables.VariableContainer;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.*;

public class ArrayParsingTests {

    @Test
    public void declaration01(){
        parse("int[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(1, array[3].intValue());
    }

    @Test
    public void declaration02(){
        parse("float[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(1f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void declaration03(){
        parse("vector[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Vector[] array = TypeCheckerHelper.parseVectorArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isVectorsValuesEqual(array[0], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[1], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[2], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[3], new Vector(0,0,0)));
    }

    @Test
    public void declaration04(){
        parse("bool[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Boolean[] array = TypeCheckerHelper.parseBooleanArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(array[0]);
        Assert.assertTrue(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertTrue(array[3]);
    }

    @Test
    public void declaration05(){
        parse("string[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        String[] array = TypeCheckerHelper.parseStringArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(array[0], "");
        Assert.assertEquals(array[1],"");
        Assert.assertEquals(array[2], "");
        Assert.assertEquals(array[3], "");
    }

    @Test
    public void declaration06(){
        parse("GamePiece[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isGamePiecesValuesEqual(array[0], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[1], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[2], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[3], new GamePiece()));
    }

    @Test
    public void assignment01(){
        parse("int[4] i; i[3] = 4;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(4, array[3].intValue());
    }

    @Test
    public void assignment02(){
        parse("float[4] i; i[2] = 2.3;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(2.3f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void assignment03(){
        parse("vector[4] i; i[2] = (5,5,5);;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Vector[] array = TypeCheckerHelper.parseVectorArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isVectorsValuesEqual(array[0], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[1], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[2], new Vector(5,5,5)));
        Assert.assertTrue(isVectorsValuesEqual(array[3], new Vector(0,0,0)));
    }

    @Test
    public void assignment04(){
        parse("bool[4] i; i[1] = false;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Boolean[] array = TypeCheckerHelper.parseBooleanArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(array[0]);
        Assert.assertFalse(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertTrue(array[3]);
    }

    @Test
    public void assignment05(){
        parse("string[4] i; i[1] = \"test\";;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        String[] array = TypeCheckerHelper.parseStringArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(array[0], "");
        Assert.assertEquals(array[1],"test");
        Assert.assertEquals(array[2], "");
        Assert.assertEquals(array[3], "");
    }

    @Test
    public void assignment06(){ //TODO LOTS OF TESTS!
        parse("GamePiece[4] i;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isGamePiecesValuesEqual(array[0], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[1], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[2], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[3], new GamePiece()));
    }

    @Test
    public void assignment07(){
        parse("float[4] i; i[2] = 2;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(2f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void assignment08(){
        parse("float[4] i; i[2] = 2.0 + 2.0;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(4f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void assignment09(){
        parse("bool[4] i; i[1] = 2 > 5;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Boolean[] array = TypeCheckerHelper.parseBooleanArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(array[0]);
        Assert.assertFalse(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertTrue(array[3]);
    }

    @Test
    public void assignment10(){
        parse("vector[4] i; i[2] = (5,5,5) + (5,5,5);;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Vector[] array = TypeCheckerHelper.parseVectorArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isVectorsValuesEqual(array[0], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[1], new Vector(0,0,0)));
        Assert.assertTrue(isVectorsValuesEqual(array[2], new Vector(10,10,10)));
        Assert.assertTrue(isVectorsValuesEqual(array[3], new Vector(0,0,0)));
    }

    @Test
    public void assignment11(){
        parse("int[4] i; int[1] x; x[0] = 10; i[3] = x[0];;");

        VariableContainer i = vcl.getArrayValueFromScope("i");
        VariableContainer x = vcl.getArrayValueFromScope("x");

        Assert.assertNotNull(i);
        Assert.assertNotNull(x);
        Assert.assertTrue(i.isArray());
        Assert.assertTrue(x.isArray());

        Integer[] array1 = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array1.length);
        Assert.assertEquals(1, array1[0].intValue());
        Assert.assertEquals(1, array1[1].intValue());
        Assert.assertEquals(1, array1[2].intValue());
        Assert.assertEquals(10, array1[3].intValue());

        Integer[] array2 = TypeCheckerHelper.parseIntegerArray(x.getValue());
        Assert.assertEquals(1, array2.length);
        Assert.assertEquals(10, array2[0].intValue());
    }

    @Test
    public void assignment12(){
        parse("int[4] i; i[3] = i.length;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(4, array[3].intValue());
    }

    @Test
    public void assignment13(){
        parse("int[4] i; int x; x = 10; i[3] = x;;");

        VariableContainer i = vcl.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check values
        Integer[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0].intValue());
        Assert.assertEquals(1, array[1].intValue());
        Assert.assertEquals(1, array[2].intValue());
        Assert.assertEquals(10, array[3].intValue());
    }

    @Test
    public void length01(){
        parse("int[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test
    public void length02(){
        parse("float[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test
    public void length03(){
        parse("vector[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test
    public void length04(){
        parse("bool[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test
    public void length05(){
        parse("string[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test
    public void length06(){
        parse("GamePiece[4] i; int x; x = i.length;;");

        VariableContainer x = vcl.getValueFromScope("x");

        Assert.assertNotNull(x);
        Assert.assertSame(x.getType(), VariableCollectorListener.VariableType.INT);

        Assert.assertEquals(4, TypeCheckerHelper.parseInt(x.getValue()).intValue());
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_int01(){
        parse("int[4] x; x[2] = 2.0;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_int02(){
        parse("int[4] x; x[2] = \"test\";;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_int03(){
        parse("int[4] x; x[2] = true;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_int04(){
        parse("int[4] x; GamePiece gp; x[2] = gp;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_int05(){
        parse("int[4] x; x[2] = (2,2,3);;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_float02(){
        parse("float[4] x; x[2] = \"test\";;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_float03(){
        parse("float[4] x; x[2] = true;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_float04(){
        parse("float[4] x; GamePiece gp; x[2] = gp;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_float05(){
        parse("float[4] x; x[2] = (2,2,3);;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_string01(){
        parse("string[4] x; x[2] = 1;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_string02(){
        parse("string[4] x; x[2] = 2.0;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_string03(){
        parse("string[4] x; x[2] = true;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_string04(){
        parse("string[4] x; GamePiece gp; x[2] = gp;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_string05(){
        parse("string[4] x; x[2] = (2,2,3);;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_boolean01(){
        parse("bool[4] x; x[2] = 1;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_boolean02(){
        parse("bool[4] x; x[2] = 2.0;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_boolean03(){
        parse("bool[4] x; x[2] = \"test\";;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_boolean04(){
        parse("bool[4] x; GamePiece gp; x[2] = gp;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_bool05(){
        parse("bool[4] x; x[2] = (2,2,3);;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_GamePiece01(){
        parse("GamePiece[4] x; x[2] = 1;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_GamePiece02(){
        parse("GamePiece[4] x; x[2] = 2.0;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_GamePiece03(){
        parse("GamePiece[4] x; x[2] = \"test\";;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_GamePiece04(){
        parse("GamePiece[4] x; x[2] = (2,3,3);;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_GamePiece05(){
        parse("GamePiece[4] x; x[2] = false;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_vector01(){
        parse("vector[4] x; x[2] = 1;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_vector02(){
        parse("vector[4] x; x[2] = 2.0;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_vector03(){
        parse("vector[4] x; x[2] = \"test\";;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_vector04(){
        parse("vector[4] x; GamePiece gp; x[2] = gp;;");
    }

    @Test (expected = Exception.class)
    public void faulty_assignment_vector05(){
        parse("vector[4] x; x[2] = true;;");
    }
}
