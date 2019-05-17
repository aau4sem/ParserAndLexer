package typeChecking.listeners;

import org.junit.*;

import static testUtilities.TestUtils.bl;
import static testUtilities.TestUtils.parse;

public class BoardListenerTests {

    @Test
    public void assignment01(){
        parse("Board = \"TestZero\";;");

        Assert.assertEquals("TestZero", bl.getBoardPath());
    }

    @Test
    public void assignment02() {
        parse("Board = " + "\"" + "\\some\\path\\pictures1.jpg" + "\"" + ";;");

        Assert.assertEquals("\\some\\path\\pictures1.jpg", bl.getBoardPath());
    }

    @Test
    public void assignment03() {
        parse("Board = " + "\"" + "https://pbs.twimg.com/profile_images/1115659011330719744/FRmIw6uM.png" + "\"" + ";;");

        Assert.assertEquals("https://pbs.twimg.com/profile_images/1115659011330719744/FRmIw6uM.png", bl.getBoardPath());
    }
}