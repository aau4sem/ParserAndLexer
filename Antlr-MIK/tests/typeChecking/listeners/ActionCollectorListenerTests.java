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
                "Wait(three, 1); Wait(three, 3); Change(one, \"label\",\"test\", 2);;"));
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
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"label\",\"test\", 2);;"));
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
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"name\",\"test\", 2);;"));
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
    public void change03(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"position\",(2,3,2), 2);;"));
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
    public void change04(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"size\",2.0, 2);;"));
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
    public void change05(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"color\",\"RED\", 2);;"));
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
    public void change06(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"shape\",\"square\", 2);;"));
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
    public void change07(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"color\",\"rgb(3,2,3,4)\", 2);;"));
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
    public void change08(){
        lexer = new TacticLexer(new ANTLRInputStream("GamePiece one; Change(one, \"color\",\"rgb(3,2,3)\", 2);;"));
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
