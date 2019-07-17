import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomersAccountsCheckerTest {

    private static BankAccount bankAccount;
    private static Customer customer;

    @BeforeClass
    public static void createCustomer(){
        bankAccount = new BankAccount("DE12587000234123");
        customer = new Customer("Tom", 20, bankAccount);
    }

    @Test
    public void validAgeShouldNotThrowError() throws InvalidAgeExeption {
        CustomersAccountsChecker.checkAge(customer.getAge());
    }

    @Test
    public void validLengthShouldNotThrowError() throws InvalidIbanLengthExeption {
        CustomersAccountsChecker.checkIbanLength(customer.getAccount().getIban());
    }

    @Test
    public void validStartShouldNotThrowError () throws InvalidIbanCharactersExeption {
        CustomersAccountsChecker.checkIbanCharacters(customer.getAccount().getIban());
    }

    //*****************************************

    @Test(expected = InvalidAgeExeption.class)
    public void shouldThrowErrorForInvalidAge() throws InvalidAgeExeption {
        BankAccount bankAccount = new BankAccount("DE12341234123412");
        Customer customer = new Customer("Tom", 10, bankAccount);
        CustomersAccountsChecker.checkAge(customer.getAge());
    }

    @Test(expected = InvalidIbanLengthExeption.class)
    public void shouldThrowErrorForInvalidLength() throws InvalidIbanLengthExeption {
        BankAccount bankAccount = new BankAccount("DE1234123");
        Customer customer = new Customer("Tom", 20, bankAccount);
        CustomersAccountsChecker.checkIbanLength(customer.getAccount().getIban());
    }

    @Test(expected = InvalidIbanCharactersExeption.class)
    public void shouldThrowErrorForInvalidStart() throws InvalidIbanCharactersExeption {
        BankAccount bankAccount = new BankAccount("EE12341234123412");
        Customer customer = new Customer("Tom", 20, bankAccount);
        CustomersAccountsChecker.checkIbanCharacters(customer.getAccount().getIban());
    }
}
