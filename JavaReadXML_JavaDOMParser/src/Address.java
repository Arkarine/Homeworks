public class Address {
    //Address (street, houseNumber)
    private String street;
    private int houseNumber;


        public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    public Address() {
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber ;
    }
}
