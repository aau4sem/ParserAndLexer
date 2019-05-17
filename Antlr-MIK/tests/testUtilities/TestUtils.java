package testUtilities;

import customListeners.ActionCollectorListener;
import customListeners.BoardListener;
import customListeners.VariableCollectorListener;
import gen.Tactic;
import gen.TacticLexer;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Assert;

public class TestUtils {

    public static VariableCollectorListener vcl;
    public static ActionCollectorListener acl;
    public static BoardListener bl;

    /** Parses the given input and the results can be found in the field. */
    public static void parse(String input){
        TacticLexer lexer = new TacticLexer(new ANTLRInputStream(input));
        Tactic parser = new Tactic(new CommonTokenStream(lexer));
        vcl = new VariableCollectorListener();
        acl = new ActionCollectorListener(vcl);
        bl = new BoardListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.addParseListener(bl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
    }
}
