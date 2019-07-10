import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Address personAddress;

    public Person(String name, Address personAddress) {
        this.name = name;
        this.personAddress = personAddress;
    }

    public Address getPersonAddress() {
        return personAddress;
    }
}
