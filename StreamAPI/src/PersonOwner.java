public class PersonOwner {
    String name;

    public PersonOwner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' ;
    }
}