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

    @Test
    public void move01(){
        parse("GamePiece one; Move(one, (2,3,4), 10);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void move02(){
        parse("GamePiece one; Move(one, (2,3), 10);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test
    public void wait01(){
        parse("GamePiece one; Wait(one, 10);;");

        Assert.assertEquals(1, acl.getActionFunctions().size());
    }

    @Test (expected = Exception.class)
    public void move_faulty01(){
        parse("GamePiece one; Move(2, (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty02(){
        parse("GamePiece one; Move(\"test\", (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty03(){
        parse("GamePiece one; Move(2.0, (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty04(){
        parse("GamePiece one; Move((2,3,3), (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty05(){
        parse("GamePiece one; Move((2,3), (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty06(){
        parse("GamePiece one; Move((true, (2,3), 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty07(){
        parse("GamePiece one; Move(gp, 1, 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty08(){
        parse("GamePiece one; Move(gp, 1.0, 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty09(){
        parse("GamePiece one; Move(gp, \"test\", 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty10(){
        parse("GamePiece one; Move(gp, true, 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty11(){
        parse("GamePiece one; Move(gp, gp, 10);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty12(){
        parse("GamePiece one; Move(gp, (1,1,1), true);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty13(){
        parse("GamePiece one; Move(gp, (1,1,1), 10.3);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty14(){
        parse("GamePiece one; Move(gp, (1,1,1), gp);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty15(){
        parse("GamePiece one; Move(gp, (1,1,1), i);;");
    }

    @Test (expected = Exception.class)
    public void move_faulty16(){
        parse("GamePiece one; Move(gp, (1,1,1), \"test\");;");
    }

    @Test (expected = Exception.class)
    public void move_faulty17(){
        parse("GamePiece one; Move(gp, (1,1,1), (2,3,1));;");
    }

    @Test (expected = Exception.class)
    public void move_faulty18(){
        parse("GamePiece one; Move(gp, (1,1,1), -5);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty01(){
        parse("GamePiece one; Wait(gp, -1);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty02(){
        parse("GamePiece one; Wait(gp, \"test\");;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty03(){
        parse("GamePiece one; Wait(gp, 4.5);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty04(){
        parse("GamePiece one; Wait(gp, false);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty05(){
        parse("GamePiece one; Wait(gp, (3,3,2));;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty06(){
        parse("GamePiece one; Wait(true, 5);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty07(){
        parse("GamePiece one; Wait(\"test\", 5);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty08(){
        parse("GamePiece one; Wait(1, 5);;");
    }

    @Test (expected = Exception.class)
    public void wait_faulty09(){
        parse("GamePiece one; Wait(2.5, 5);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty01(){
        parse("GamePiece one; Change(1, \"color\",\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty02(){
        parse("GamePiece one; Change(2.0, \"color\",\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty03(){
        parse("GamePiece one; Change(true, \"color\",\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty04(){
        parse("GamePiece one; Change(\"test\", \"color\",\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty05(){
        parse("GamePiece one; Change(1, \"color\",\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty06(){
        parse("GamePiece one; Change(gp, 2,\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty07(){
        parse("GamePiece one; Change(gp, 2.0,\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty08(){
        parse("GamePiece one; Change(gp, false,\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty09(){
        parse("GamePiece one; Change(gp, gp,\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty10(){
        parse("GamePiece one; Change(gp, (2,3,2),\"rgb(3,2,3)\", 2);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty11(){
        parse("GamePiece one; Change(gp, \"color\", \"rgb(3,2,3)\", -5);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty12(){
        parse("GamePiece one; Change(gp, \"color\", \"rgb(3,2,3)\", true);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty13(){
        parse("GamePiece one; Change(gp, \"color\", \"rgb(3,2,3)\", 5.21);;");
    }

    @Test (expected = Exception.class)
    public void change_faulty14(){
        parse("GamePiece one; Change(gp, \"color\", \"rgb(3,2,3)\", \"test\");;");
    }

    @Test (expected = Exception.class)
    public void change_faulty15(){
        parse("GamePiece one; Change(gp, \"color\", \"rgb(3,2,3)\", gp);;");
    }
}
