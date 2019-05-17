package typeChecking.listeners;

import org.junit.*;

import static testUtilities.TestUtils.acl;
import static testUtilities.TestUtils.parse;

public class ActionCollectorListenerTests {

    @Test
    public void overallTest01(){
        parse("GamePiece one; GamePiece two; GamePiece three;" +
                "Move(one, (2,3,4), 2); Wait(one, 6); Move(two, (2,3,4), 2); Move(two, (2,3,5), 6);" +
                "Wait(three, 1); Wait(three, 3); Change(one, \"label\",\"test\", 2);;");

        Assert.assertEquals(7, acl.getActionFunctions().size());
    }

    @Test
    public void change01(){
        parse("GamePiece one; Change(one, \"label\",\"test\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change02(){
        parse("GamePiece one; Change(one, \"name\",\"test\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change03(){
        parse("GamePiece one; Change(one, \"position\",(2,3,2), 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change04(){
        parse("GamePiece one; Change(one, \"size\",2.0, 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change05(){
        parse("GamePiece one; Change(one, \"color\",\"RED\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change06(){
        parse("GamePiece one; Change(one, \"shape\",\"square\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change07(){
        parse("GamePiece one; Change(one, \"color\",\"rgb(3,2,3,4)\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void change08(){
        parse("GamePiece one; Change(one, \"color\",\"rgb(3,2,3)\", 2);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }
}
