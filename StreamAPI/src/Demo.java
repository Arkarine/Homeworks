import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {

        System.out.println("-----------1------------------");
        /*
        Нужно написать функцию, которая по списку persons вернет список адресов тех
        людей, чей возраст больше 17 лет.
        */

        Address a1 = new Address("Tieckstrasse", 10);
        Address a2 = new Address("Torstrasse", 107);
        Address a3 = new Address("Novalinstrasse", 125);
        Address a4 = new Address("Auguststrasse", 48);



        Person p1 = new Person("Anna", 40, a1);
        Person p2 = new Person("David", 40, a2);
        Person p3 = new Person("Robert", 15, a3);
        Person p4 = new Person("Lia", 27, a4);

        List<Person> list = Arrays.asList(p1, p2, p3, p4);

        List<Address> listAdresses = list
                .stream()
                .filter(p -> p.getAge() > 17)
                .map(Person::getAddress)
                .collect(Collectors.toList());
        System.out.println(listAdresses);

        System.out.println("-----------2------------------");

        /*
            Есть список имен, нужно написать функцию, которая вернет список имен без
            дупликатов.
        */

        List<String> listNames = Arrays.asList("Anna", "Bella", "Anna", "Tom", "Teo", "Bella");
        System.out.println(listNames);
        Set<String> namesWithoutDuplicate = listNames.stream().collect(Collectors.toSet()); //OR
        // Set<String> namesWithoutDuplicate = new HashSet<>(listNames);
        System.out.println(namesWithoutDuplicate);

        System.out.println("-----------3------------------");

        /*
        Есть список людей, нужно написать функцию, которая вернет мапу, где
        ключом является возраст, а значением список людей этого возраста.
        */

        List<Person> persons = Arrays.asList(p1, p2, p3, p4);

        Map<Integer, List<Person>> result = persons.stream().collect(Collectors.groupingBy(Person::getAge));

        result.forEach((k,v) -> {
            System.out.println(k + "->" +v);
        });

        System.out.println("-----------4------------------");

        /*
            написать функцию, которая возвращает мапу, где значением является Person, а
            значением - список его банковских счетов.
        */

        PersonOwner per1 = new PersonOwner("Anna");
        PersonOwner per2 = new PersonOwner("Leo");
        PersonOwner per3 = new PersonOwner("Sophie");
        PersonOwner per4 = new PersonOwner("Alex");

        BankAccount b1 = new BankAccount("DE91 1000 0000 0025 3564 75", per1);
        BankAccount b2 = new BankAccount("DE90 1000 0000 0123 4567 89", per2);
        BankAccount b3 = new BankAccount("DE92 1000 0000 2365 5879 90", per1);
        BankAccount b4 = new BankAccount("DE93 1000 0000 0124 4767 79", per3);
        BankAccount b5 = new BankAccount("DE91 1000 0000 0723 7567 19", per4);
        BankAccount b6 = new BankAccount("DE94 1000 0000 1123 4517 87", per4);
        BankAccount b7 = new BankAccount("DE90 1000 0000 0823 9567 56", per3);
        BankAccount b8 = new BankAccount("DE92 1000 0000 0223 8567 25", per4);
        BankAccount b9 = new BankAccount("DE95 1000 0000 2598 4767 18", per2);
        BankAccount b10 = new BankAccount("DE96 1000 0000 0923 7567 45", per1);


        List<BankAccount> persons1 = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);

        Map<PersonOwner, List<BankAccount>> result1 = persons1.stream().collect(Collectors.groupingBy(BankAccount::getOwner));

        result1.forEach((k,v) -> {
            System.out.println(k + "->" +v);
        });

        System.out.println("-----------5------------------");

        /*
            Написать функцию, которая для списка счетов, возвращает список IBANNs,
            где в каждом IBANN символы после 3-го и до конца заменены звездочками.
        */

        List<BankAccount> persons2 = Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10);

        List<String> IBANNsList = persons2
                .stream()
                //.map(b -> new BankAccount(transformString(b.getIBANN()), b.getOwner()))     //OR
                .map(b -> b = transformAccount(b))
                .map(BankAccount::getIBANN)
                .collect(Collectors.toList());

        IBANNsList.forEach(System.out::println);


        System.out.println("-----------6------------------");
        /*
            Написать функцию, которая принимает предложение, а возвращает
            количество слов, начинающихся на заданную букву.
        */

        String s = "The following are examples of using the predefined collectors to " +
                "perform common mutable reduction tasks.";

        String[] stArray = s.split(" ");

        String ch = "t";

        long count = Arrays.stream(stArray)
                //.filter(st -> st.charAt(0) == ch)   //OR
                .filter(st -> st.startsWith(ch))
                .count();
        System.out.println(count);

        System.out.println("-----------7------------------");

        /*
        Написать функцию, которая проверяет, является ли заданная строка целым
        числом. Подсказка - Character.isDigit() и Stream.allMatch().
        */

        String string1 = "4546464";
        String string2 = "ssd546464";

        //7 regular expression
        /*
        \\d  - one number
        *  - 0 or more
        +  - 1 or more

        */

        System.out.println(string1.matches("\\d*"));
        System.out.println(string2.matches("\\d*"));

        //Stream

        List<Character> listChars1 = new ArrayList<>();
        for (int i = 0; i < string1.length(); i++) {
            listChars1.add(string1.charAt(i));
        }

        System.out.println(listChars1.stream().allMatch(Character::isDigit));

        System.out.println("-----------8------------------");
        /*
        Написать функцию, которая по списку persons возвращает список их
        банковских счетов с звездочками с третьего символа. Подсказка - flatMap()
        */

        BankAccount8Exercise ba1 = new BankAccount8Exercise("DE91 1000 0000 0025 3564 75");
        BankAccount8Exercise ba2 = new BankAccount8Exercise("DE90 1000 0000 0123 4567 89");
        BankAccount8Exercise ba3 = new BankAccount8Exercise("DE92 1000 0000 2365 5879 90");
        BankAccount8Exercise ba4 = new BankAccount8Exercise("DE93 1000 0000 0124 4767 79");
        BankAccount8Exercise ba5 = new BankAccount8Exercise("DE91 1000 0000 0723 7567 19");
        BankAccount8Exercise ba6 = new BankAccount8Exercise("DE94 1000 0000 1123 4517 87");
        BankAccount8Exercise ba7 = new BankAccount8Exercise("DE90 1000 0000 0823 9567 56");
        BankAccount8Exercise ba8 = new BankAccount8Exercise("DE92 1000 0000 0223 8567 25");
        BankAccount8Exercise ba9 = new BankAccount8Exercise("DE95 1000 0000 2598 4767 18");
        BankAccount8Exercise ba10 = new BankAccount8Exercise("DE96 1000 0000 0923 7567 45");

        List<String> list1 = Arrays.asList(ba1.getIBANN(), ba2.getIBANN(), ba3.getIBANN());
        List<String> list2 = Arrays.asList(ba4.getIBANN(), ba5.getIBANN(), ba6.getIBANN());
        List<String> list3 = Arrays.asList(ba7.getIBANN(), ba8.getIBANN(), ba9.getIBANN(), ba10.getIBANN());

        Person8Exercise pers1 = new Person8Exercise("Anna", list1);
        Person8Exercise pers2 = new Person8Exercise("Teo", list2);
        Person8Exercise pers3 = new Person8Exercise("Lia", list3);

        List<Person8Exercise> personList = Arrays.asList(pers1, pers2, pers3);

        List<String> res = personList.stream()
                .flatMap(l -> l.getBanAccounts().stream())
                .map(Demo::transformString)
                //.map(iban -> transformString(iban))
                .collect(Collectors.toList());

        res.forEach(System.out::println);

        System.out.println("-----------9------------------");
        /*
        Для списка persons посчитать общий возраст тех, кому больше 17 лет.
        Подсказка - reduce()
        */

        Person p_1 = new Person("Anna", 40, a1);
        Person p_2 = new Person("David", 40, a2);
        Person p_3 = new Person("Robert", 25, a3);
        Person p_4 = new Person("Lia", 16, a4);

        List<Person> listP = Arrays.asList(p_1, p_2, p_3, p_4);

        int sum = listP.stream().map(Person::getAge)
        //int sum = listP.stream().map(a -> a.getAge())
                .filter(p -> p > 17)
                .reduce(Integer::sum)
                //.reduce((acc, age) -> acc +age)
                .get();
        System.out.println(sum);

        System.out.println("-----------10------------------");
        /*
        Написать функцию, которая для списка persons напечатает для тех, кто
        старше 17 лет: In Germany <name1> and <name2> and …<nameN> are of legal
        age. Подсказка - Collectors.joining();
         */
        List<Person> listPersons = Arrays.asList(p_1, p_2, p_3, p_4);

        String sentence = listPersons.stream()
                .filter(p -> p.getAge() > 17)
                .map(Person::getName)
                //.map(p -> p.getName())
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        System.out.println(sentence);


    }

    //============================Methods for Task 5=============================
    public static String transformString (String b){
        if(b == null) return null;

        /* ---------------1 Method----------------
        for (int i = 3; i < b.length(); i++) {
            b = b.substring(0, i) + '*' + b.substring(i + 1);
        }
        return b;
        */
        /* -------------------2 Method ---------------
        char[] chars = b.toCharArray();
        for (int i = 3; i < b.length(); i++) {
            chars[i] = '*';
        }
        String res = String.valueOf(chars);
        return res;
        */
        // -------------------3 Method ---------------
        StringBuilder res = new StringBuilder(b);
        for (int i = 3; i < b.length(); i++) {
            res.setCharAt(i,'*');
        }
        return res.toString();
    }

    public static BankAccount transformAccount (BankAccount b){
        if(b == null || b.getIBANN() == null){
            return null;
        }
        StringBuilder res = new StringBuilder(b.getIBANN());
        for (int i = 3; i < b.getIBANN().length(); i++) {
            res.setCharAt(i, '*');
        }
        return new BankAccount(res.toString(), b.getOwner());
    }
    //===========================================================
}
