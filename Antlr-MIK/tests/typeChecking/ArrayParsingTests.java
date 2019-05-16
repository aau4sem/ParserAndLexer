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

public class ArrayParsingTests {

    private static VariableCollectorListener vlc;

    @Test
    public void declaration01(){
        parse("int[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        int[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0]);
        Assert.assertEquals(1, array[1]);
        Assert.assertEquals(1, array[2]);
        Assert.assertEquals(1, array[3]);
    }

    @Test
    public void declaration02(){
        parse("float[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(1f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void declaration03(){
        parse("vector[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
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

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        boolean[] array = TypeCheckerHelper.parseBooleanArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(array[0]);
        Assert.assertTrue(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertTrue(array[3]);
    }

    @Test
    public void declaration05(){
        parse("string[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
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

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isGamePiecesValuesEqual(array[0], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[1], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[2], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[3], new GamePiece()));
    }

    @Test
    public void assignment01(){
        parse("int[4] i; i[2] = 4;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        int[] array = TypeCheckerHelper.parseIntegerArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1, array[0]);
        Assert.assertEquals(1, array[1]);
        Assert.assertEquals(4, array[2]);
        Assert.assertEquals(1, array[3]);
    }

    @Test
    public void assignment02(){
        parse("float[4] i; i[2] = 2.3;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        float[] array = TypeCheckerHelper.parseFloatArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertEquals(1f, array[0], 10);
        Assert.assertEquals(1f, array[1], 10);
        Assert.assertEquals(2.3f, array[2], 10);
        Assert.assertEquals(1f, array[3], 10);
    }

    @Test
    public void assignment03(){
        parse("vector[4] i; i[2] = (5,5,5);;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
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

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        boolean[] array = TypeCheckerHelper.parseBooleanArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(array[0]);
        Assert.assertFalse(array[1]);
        Assert.assertTrue(array[2]);
        Assert.assertTrue(array[3]);
    }

    @Test
    public void assignment05(){
        parse("string[4] i; i[1] = \"test\";;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
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

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());

        //Check default values
        GamePiece[] array = TypeCheckerHelper.parseGamePieceArray(i.getValue());
        Assert.assertEquals(4, array.length);
        Assert.assertTrue(isGamePiecesValuesEqual(array[0], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[1], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[2], new GamePiece()));
        Assert.assertTrue(isGamePiecesValuesEqual(array[3], new GamePiece()));
    }

    /** Parses the given input and the results can be found in the field. */
    public static void parse(String input){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream(input));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        vlc = new VariableCollectorListener();
        parser.addParseListener(vlc);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

    private static boolean isGamePiecesValuesEqual(GamePiece one, GamePiece two){

        boolean result = true;

        if(one.getName().compareTo(two.getName()) != 0)
            result = false;
        else if(!isVectorsValuesEqual(one.getPosition(), two.getPosition()))
            result = false;
        else if(one.getSize() != two.getSize())
            result = false;
        else if(one.getColor().compareTo(two.getColor()) != 0)
            result = false;
        else if(one.getLabel().compareTo(two.getLabel()) != 0)
            result = false;
        else if(one.getOpacity() != two.getOpacity())
            result = false;

        return result;
    }

    public static boolean isVectorsValuesEqual(Vector one, Vector two){

        boolean result = true;

        if(one.getX() != two.getX())
            result = false;

        if(one.getY() != two.getY())
            result = false;

        if(one.getZ() != two.getZ())
            result = false;

        return result;
    }
}
