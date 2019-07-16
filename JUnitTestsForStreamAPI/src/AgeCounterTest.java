import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AgeCounterTest {
    @Test
    public void testCountAges(){
        Address a1 = new Address("Tieckstrasse", 10);
        Address a2 = new Address("Torstrasse", 107);
        Address a3 = new Address("Novalinstrasse", 125);
        Address a4 = new Address("Auguststrasse", 48);

        Person p1 = new Person("Anna", 40, a1);
        Person p2 = new Person("David", 40, a2);
        Person p3 = new Person("Robert", 25, a3);
        Person p4 = new Person("Lia", 16, a4);

        List<Person> listPersons = Arrays.asList(p1, p2, p3, p4);
        int result = AgeCounter.countAges(listPersons);
        Assert.assertEquals(105, result);
    }
    @Test(timeout = 1000)
    public void testCountAgesForNullList(){
        int result = AgeCounter.countAges(null);
        Assert.assertEquals(0,result);
    }

    Address a5 = new Address("Oranienburgerstrasse", 15);
    Person p5 = new Person("Ira", 60, a5);

    List<Person> listPersons1 = Arrays.asList(p5 , null);
    @Test
    public void testCountAgesForNullObject(){
        int result = AgeCounter.countAges(listPersons1);
        Assert.assertEquals(60,result);
    }
}
