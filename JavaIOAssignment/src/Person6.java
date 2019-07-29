public class Person6 {
    String firstName;
    String lastName;
    String equipment;
    int price;

    public Person6(String firstName, String lastName, String equipment, int price) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.equipment = equipment;
        this.price = price;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstLastName() {
        return firstName + lastName;
    }

    public String getEquipment() {
        return equipment;
    }

    public int getPrice() {
        return price;
    }
}
