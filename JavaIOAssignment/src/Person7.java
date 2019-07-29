import java.time.LocalDate;

public class Person7 {
    String name;
    LocalDate dateOfBirth;

    public Person7(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }
}
