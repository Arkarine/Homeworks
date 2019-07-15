import org.junit.Assert;
import org.junit.Test;

public class StringHelperTest {

    @Test
    public void InputShouldBeInteger(){
        String string = "4546464";
        Boolean result = StringHelper.isInteger(string);
        Assert.assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void isIntegerForNull(){
        Boolean result = StringHelper.isInteger(null);
    }
}
