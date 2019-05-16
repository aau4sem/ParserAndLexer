package model.dataTypes;

import org.junit.Assert;
import org.junit.Test;

public class VectorTests {

    @Test
    public void addVector01(){
        Vector one = new Vector(1,1,1);
        Vector two = new Vector(2,2,2);

        one.addVector(two);

        Assert.assertEquals(3, one.getX());
        Assert.assertEquals(3, one.getY());
        Assert.assertEquals(3, one.getY());

        Assert.assertEquals(2, two.getX());
        Assert.assertEquals(2, two.getY());
        Assert.assertEquals(2, two.getY());
    }

    @Test
    public void addVector02(){
        Vector one = new Vector(1,1,1);
        Vector two = new Vector(0,0,0);

        one.addVector(two);

        Assert.assertEquals(1, one.getX());
        Assert.assertEquals(1, one.getY());
        Assert.assertEquals(1, one.getY());

        Assert.assertEquals(0, two.getX());
        Assert.assertEquals(0, two.getY());
        Assert.assertEquals(0, two.getY());
    }

    @Test
    public void subVector01(){
        Vector one = new Vector(1,1,1);
        Vector two = new Vector(2,2,2);

        one.subVector(two);

        Assert.assertEquals(-1, one.getX());
        Assert.assertEquals(-1, one.getY());
        Assert.assertEquals(-1, one.getY());

        Assert.assertEquals(2, two.getX());
        Assert.assertEquals(2, two.getY());
        Assert.assertEquals(2, two.getY());
    }

    @Test
    public void subVector02(){
        Vector one = new Vector(1,1,1);
        Vector two = new Vector(0,0,0);

        one.subVector(two);

        Assert.assertEquals(1, one.getX());
        Assert.assertEquals(1, one.getY());
        Assert.assertEquals(1, one.getY());

        Assert.assertEquals(0, two.getX());
        Assert.assertEquals(0, two.getY());
        Assert.assertEquals(0, two.getY());
    }

}
