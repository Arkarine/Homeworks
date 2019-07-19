public class Customer {
    private String name;
    private  int age;
    private BankAccount account;

    public Customer(String name, int age, BankAccount account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public int getAge() {
        return age;
    }

    public BankAccount getAccount() {
        return account;
    }
}
