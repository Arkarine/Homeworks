import java.time.LocalDate;

public class Person {

    String name;
    LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "["+ name +", " + dateOfBirth +"]";
    }
}
