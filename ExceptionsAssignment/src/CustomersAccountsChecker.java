import java.util.List;

public class CustomersAccountsChecker {
    private Printable p;

    public CustomersAccountsChecker(Printable p) {
        this.p = p;
    }

    public static void checkAge(int age) throws InvalidAgeExeption {
        if(age <= 17){
            throw new InvalidAgeExeption("Age must be more than 17");
        }
    }

    public static void checkIbanLength(String input) throws InvalidIbanLengthExeption {
        if(input.length() != 16){
            throw new InvalidIbanLengthExeption("Iban lenght must be equal to 16");
        }
    }

    public static void checkIbanCharacters(String input) throws InvalidIbanCharactersExeption {
        if (!input.substring(0,2).equals("DE")){
            throw new InvalidIbanCharactersExeption("The first two characters must be 'DE'.");
        }
    }

    public void checkCustomersList(List<Customer> list) throws InvalidAgeExeption, InvalidIbanLengthExeption, InvalidIbanCharactersExeption {
        for (Customer l: list ) {
            checkAge(l.getAge());
            checkIbanLength(l.getAccount().getIban());
            checkIbanCharacters(l.getAccount().getIban());
        }
    }
}
