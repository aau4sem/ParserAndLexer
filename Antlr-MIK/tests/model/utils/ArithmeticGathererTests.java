package model.utils;

import org.junit.Assert;
import org.junit.Test;

public class ArithmeticGathererTests {

    @Test
    public void eval01(){
        String input = "2 + 2";
        double expectedResult = 4;

        Assert.assertEquals(expectedResult, ArithmeticGatherer.eval(input), 10);
    }

    @Test
    public void eval02(){
        String input = "2 + 3 * 1 - (2 + 2) * (2 + 2 * 2) + 3";
        double expectedResult = -16;

        Assert.assertEquals(expectedResult, ArithmeticGatherer.eval(input), 10);
    }

    @Test
    public void eval03(){
        String input = "2 + 3 * 1 - (2 + 2)";
        double expectedResult = 1;

        Assert.assertEquals(expectedResult, ArithmeticGatherer.eval(input), 10);
    }

    @Test
    public void eval04(){
        String input = "(1 + 1) / 2";
        double expectedResult = 0;

        Assert.assertEquals(expectedResult, ArithmeticGatherer.eval(input), 10);
    }

    @Test
    public void eval05(){
        String input = "1 / 0";
        double expectedResult = 0;

        //TODO HANDLE devision by 0
        //Assert.assertEquals(expectedResult, ArithmeticGatherer.eval(input), 10);
    }
}
