import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        BankAccount b1 = new BankAccount("DE21236789454521");
        BankAccount b2 = new BankAccount("DE57968413287455");
        BankAccount b3 = new BankAccount("DE41119874522266");
        BankAccount b4 = new BankAccount("DE33970048751100");
        BankAccount b5 = new BankAccount("DE77899003487534");

        Customer c1 = new Customer("Inga", 54, b1);
        Customer c2 = new Customer("Anna", 24, b2);
        Customer c3 = new Customer("Alex", 36, b3);
        Customer c4 = new Customer("David", 40, b4);
        Customer c5 = new Customer("Tom", 23, b5);

        List<Customer> list = Arrays.asList(c1, c2, c3, c4, c5);

        try{
            CustomersAccountsChecker.checkCustomersList(list);
        }
        catch (InvalidAgeExeption | InvalidIbanLengthExeption | InvalidIbanCharactersExeption exeption) {
            System.out.println(exeption.getMessage());
        }

    }
}
