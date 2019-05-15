package typeChecking;

import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;
import org.junit.Test;

public class VectorArithmeticTests {

    private static VariableCollectorListener vlc;

    @Test
    public void add01(){
        parse("int i; i = (5,5,5) + (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(7, i.getX());
        Assert.assertEquals(7, i.getY());
        Assert.assertEquals(7, i.getZ());
    }

    @Test
    public void add02(){
        parse("int i; i = (5,5,5) + (2,2,2) + (3,3,3);;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.getX());
        Assert.assertEquals(10, i.getY());
        Assert.assertEquals(10, i.getZ());
    }

    @Test
    public void sub01(){
        parse("int i; i = (5,5,5) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(3, i.getX());
        Assert.assertEquals(3, i.getY());
        Assert.assertEquals(3, i.getZ());
    }

    @Test
    public void sub02(){
        parse("int i; i = (5,5,5) - (2,2,2) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(1, i.getX());
        Assert.assertEquals(1, i.getY());
        Assert.assertEquals(1, i.getZ());
    }

    @Test
    public void sub03(){
        parse("int i; int x; x = (1,1,1); i = (5,5,5) - x;;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.getX());
        Assert.assertEquals(4, i.getY());
        Assert.assertEquals(4, i.getZ());
    }

    @Test
    public void sub05(){
        parse("int i; int x; x = (1,1,1); i = (5,5,5) - x; i = i - x;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(3, i.getX());
        Assert.assertEquals(3, i.getY());
        Assert.assertEquals(3, i.getZ());
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
}
