import org.junit.Assert;
import org.junit.Test;

public class WordCounterTest {

    @Test(timeout = 100)
    public void testCount(){
        String testInput = "The following are examples of using the predefined collectors to " +
                "perform common mutable reduction tasks.";
        String ch = "t";

        long result = WordCounter.countWords(testInput, ch);
        Assert.assertEquals(3, result);
    }

    @Test()
    public void testCountInputNull(){
        String ch = "t";
        long result = WordCounter.countWords(null, ch);
        Assert.assertEquals(0, result);
    }

    @Test()
    public void testCountInputNullCharacter(){
        String testInput = "The following are examples of using the predefined collectors to " +
                "perform common mutable reduction tasks.";
        String ch = null;
        long result = WordCounter.countWords(testInput, null);
        Assert.assertEquals(0, result);
    }

}
