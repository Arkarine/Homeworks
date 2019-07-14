import java.util.List;

public class Person8Exercise {
    String name;
    List<String> banAccounts;

    public Person8Exercise(String name, List<String> banAccounts) {
        this.name = name;
        this.banAccounts = banAccounts;
    }

    public List<String> getBanAccounts() {
        return banAccounts;
    }
}
