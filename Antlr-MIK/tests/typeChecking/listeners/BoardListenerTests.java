package typeChecking.listeners;

import customListeners.BoardListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.*;
import gen.*;

public class BoardListenerTests {

    private static TacticLexer lexer;
    private static Tactic parser;

    @Test
    public void overallTest01(){
        lexer = new TacticLexer(new ANTLRInputStream("Board = \"TestZero\";;"));
        parser = new Tactic(new CommonTokenStream(lexer));
        BoardListener bl = new BoardListener();
        parser.addParseListener(bl);
        parser.prog();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
        Assert.assertEquals("TestZero", bl.getBoardPath());
    }

    @Test
    public void overallTest02(){
        lexer = new TacticLexer(new ANTLRInputStream(";"));
        parser = new Tactic(new CommonTokenStream(lexer));
        BoardListener bl = new BoardListener();
        parser.addParseListener(bl);
        parser.prog();

        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());
        Assert.assertEquals("", bl.getBoardPath());
    }
}