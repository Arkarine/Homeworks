public class Customer {
    String firstName;
    String lastName;
    int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + age + '\n';
    }
}
