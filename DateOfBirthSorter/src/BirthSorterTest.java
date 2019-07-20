import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BirthSorterTest {
    @Test
    public void sortBirthDatesTest(){

        /*
        /The content of the file/

        Caroline Herschel,1956-05-25,
        Elizabeth Blackburn,1894-08-30,
        Max Born,1998-07-18,
        Albert Einstein,1879-03-14
        */

        List<String> expected = Arrays.asList(
                "[Albert Einstein, 1879-03-14]",
                "[Elizabeth Blackburn, 1894-08-30]",
                "[Caroline Herschel, 1956-05-25]",
                "[Max Born, 1998-07-18]");
        List<String> actual = BirthSorter.sortBirthDate();
        Assert.assertEquals(expected,actual);
    }
}
