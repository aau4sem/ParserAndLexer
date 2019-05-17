package typeChecking;

import model.dataTypes.Vector;
import model.utils.TypeCheckerHelper;
import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class VectorArithmeticTests {

    @Test
    public void add01(){
        parse("vector i; i = (5,5,5) + (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(7, i.getX());
        Assert.assertEquals(7, i.getY());
        Assert.assertEquals(7, i.getZ());
    }

    @Test
    public void add02(){
        parse("vector i; i = (5,5,5) + (2,2,2) + (3,3,3);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(10, i.getX());
        Assert.assertEquals(10, i.getY());
        Assert.assertEquals(10, i.getZ());
    }

    @Test
    public void sub01(){
        parse("vector i; i = (5,5,5) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(3, i.getX());
        Assert.assertEquals(3, i.getY());
        Assert.assertEquals(3, i.getZ());
    }

    @Test
    public void sub02(){
        parse("vector i; i = (5,5,5) - (2,2,2) - (2,2,2);;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(1, i.getX());
        Assert.assertEquals(1, i.getY());
        Assert.assertEquals(1, i.getZ());
    }

    @Test
    public void sub03(){
        parse("vector i; vector x; x = (1,1,1); i = (5,5,5) - x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(4, i.getX());
        Assert.assertEquals(4, i.getY());
        Assert.assertEquals(4, i.getZ());
    }

    @Test
    public void sub05(){ //TODO Currently fails because i = i - x; is not parsed or check, so it is assumed to be a "normal" arithmetic expression.
        parse("vector i; vector x; x = (1,1,1); i = (5,5,5) - x; i = i - x;;");

        Vector i = TypeCheckerHelper.parseVector(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(3, i.getX());
        Assert.assertEquals(3, i.getY());
        Assert.assertEquals(3, i.getZ());
    }
}
