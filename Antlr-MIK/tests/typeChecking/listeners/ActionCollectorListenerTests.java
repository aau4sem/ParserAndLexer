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
                "move(one, (2,3,4), 2); wait(one, 6); move(two, (2,3,4), 2); move(two, (2,3,5), 6);" +
                "wait(three, 1); wait(three, 3); change(one, \"label\",\"test\", 2);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        ActionCollectorListener acl = new ActionCollectorListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        Assert.assertEquals(7, acl.getActionFunctions().size());
    }

    @Test
    public void change01(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; change(one, \"label\",\"test\", 2);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        ActionCollectorListener acl = new ActionCollectorListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change02(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; change(one, \"label\",\"test\", 2);"));
        parser = new Tactic(new CommonTokenStream(lexer));
        VariableCollectorListener vcl = new VariableCollectorListener();
        ActionCollectorListener acl = new ActionCollectorListener(vcl);
        parser.addParseListener(vcl);
        parser.addParseListener(acl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }
}
