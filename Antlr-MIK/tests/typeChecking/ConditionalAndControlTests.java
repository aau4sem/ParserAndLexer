package typeChecking;

import org.junit.Assert;
import org.junit.Test;

import static testUtilities.TestUtils.parse;
import static testUtilities.TestUtils.vcl;

public class ConditionalAndControlTests {

    @Test
    public void while01(){
        parse("int i; i = 0; while(i < 5){ i = i + 1;};;");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }

    @Test
    public void ifThenElse01(){
        parse("testTODO");

        Integer i = Integer.parseInt(vcl.getValueFromIdentifier("i").getValue());

        Assert.assertNotNull(i);
        Assert.assertEquals(5, i.intValue());
    }
}
