public class Person {
    //<!-- Person (name, gender, address), Address (street, houseNumber)-->
    private String name;
    private String gender;
    private  Address address;

    public Person(String name, String gender, Address address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", " + address +
                '}';
    }
}
