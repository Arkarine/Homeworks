public class BankAccount {
    String IBANN;
    PersonOwner owner;

    public BankAccount(String IBANN, PersonOwner owner) {
        this.IBANN = IBANN;
        this.owner = owner;
    }

    public PersonOwner getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "IBANN='" + IBANN + '\'' +
                ", owner=" + owner +
                '}';
    }

    public String getIBANN() {
        return IBANN;
    }


}