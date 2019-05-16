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

public class ArrayParsingTests {

    private static VariableCollectorListener vlc;

    @Test
    public void add01(){
        parse("int[4] i;;");

        Vector i = TypeCheckerHelper.parseVector(vlc.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(7, i.getX());
        Assert.assertEquals(7, i.getY());
        Assert.assertEquals(7, i.getZ());
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
