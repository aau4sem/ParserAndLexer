package TypeChecking;

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
        lexer = new TacticLexer(new ANTLRInputStream(
                "board_level[0] = \"TestZero\";" +
                "board_level[4] = \"TestFour\";" +
                "board_level[1] = \"TestOne\";"));
        parser = new Tactic(new CommonTokenStream(lexer));
        BoardListener bl = new BoardListener();
        parser.addParseListener(bl);
        parser.prog();
        Assert.assertEquals(0, parser.getNumberOfSyntaxErrors());

        Assert.assertEquals(5, bl.getBoardPaths().length);
        Assert.assertEquals("TestZero", bl.getBoardPaths()[0]);
        Assert.assertEquals("TestOne", bl.getBoardPaths()[1]);
        Assert.assertEquals("TestFour", bl.getBoardPaths()[4]);
        Assert.assertNull(bl.getBoardPaths()[2]);
    }
}
