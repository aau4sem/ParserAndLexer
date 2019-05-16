package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
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
        Assert.assertTrue(isVectorValuesEqual(array[0], new Vector(0,0,0)));
        Assert.assertTrue(isVectorValuesEqual(array[1], new Vector(0,0,0)));
        Assert.assertTrue(isVectorValuesEqual(array[2], new Vector(0,0,0)));
        Assert.assertTrue(isVectorValuesEqual(array[3], new Vector(0,0,0)));
    }

    @Test
    public void declaration04(){
        parse("bool[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());
        //TODO Test default values
    }

    @Test
    public void declaration05(){
        parse("string[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());
        //TODO Test default values
    }

    @Test
    public void declaration06(){
        parse("GamePiece[4] i;;");

        VariableContainer i = vlc.getArrayValueFromScope("i");

        Assert.assertNotNull(i);
        Assert.assertTrue(i.isArray());
        //TODO Test default values
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

    public static boolean isVectorValuesEqual(Vector one, Vector two){

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
