package typeChecking.listeners;

import org.junit.*;

import static testUtilities.TestUtils.bl;
import static testUtilities.TestUtils.parse;

public class BoardListenerTests {

    @Test
    public void overallTest01(){
        parse("Board = \"TestZero\";;");

        Assert.assertEquals("TestZero", bl.getBoardPath());
    }
}