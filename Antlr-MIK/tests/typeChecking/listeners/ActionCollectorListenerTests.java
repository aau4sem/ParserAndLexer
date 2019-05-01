package typeChecking.listeners;

import customListeners.ActionCollectorListener;
import customListeners.VariableCollectorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;
import gen.*;

public class ActionCollectorListenerTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @Test
    public void overallTest01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; GamePiece two; GamePiece three;" +
                "Move(one, (2,3,4), 2); Wait(one, 6); Move(two, (2,3,4), 2); Move(two, (2,3,5), 6);" +
                "Wait(three, 1); Wait(three, 3);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        ActionCollectorListener acl = new ActionCollectorListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        Assert.assertEquals(6, acl.getActionFunctions().size());
    }
}
