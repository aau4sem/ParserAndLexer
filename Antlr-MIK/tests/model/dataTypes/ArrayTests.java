package model.dataTypes;

import customListeners.VariableCollectorListener;
import org.junit.Assert;
import org.junit.Test;

public class ArrayTests {

    @Test
    public void toString01(){
        Array<Integer> array = new Array<>(new Integer[5], VariableCollectorListener.VariableType.INT);
        Assert.assertEquals("{null,null,null,null,null}", array.toString());
    }

    @Test
    public void toString02(){
        Integer[] tempArray = new Integer[]{1,2,3,4,5};
        Array<Integer> array = new Array<>(tempArray, VariableCollectorListener.VariableType.INT);
        Assert.assertEquals("{1,2,3,4,5}", array.toString());
    }
}
