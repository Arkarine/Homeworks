import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DateFormatModifierTest {
    @Test
    public void reformatDatesTest(){
        List<String> inputDates = Arrays.asList
                ("2018-06-25","2010-04-29","2009-08-11");
        List<String> expected = Arrays.asList
                ("25 June, 2018 Monday","29 April, 2010 Thursday", "11 August, 2009 Tuesday");
        List<String> actual = DateFormatModifier.reformatDates(inputDates);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void reformatSortDatesTest(){
        List<String> inputDates = Arrays.asList
                ("2018-06-25","2010-04-29","2009-08-11");
        List<String> expected = Arrays.asList
                ("11 August, 2009 Tuesday", "29 April, 2010 Thursday", "25 June, 2018 Monday");
        List<String> actual = DateFormatModifier.reformatSortDates(inputDates);
        Assert.assertEquals(expected,actual);
    }





}
