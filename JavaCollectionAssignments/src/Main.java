import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------LIST----------------");

        System.out.println("----------Number 1----------------");

        Address add1 = new Address("Torstrasse", 175);
        Address add2 = new Address("Tieckstrasse", 145);
        Address add3 = new Address("Novalienstrasse", 105);
        Address add4 = new Address("Oranienburgerstrasse", 168);
        Address add5 = new Address("Friedrichstrasse", 170);

        Person p1 = new Person("Anna", add1);
        Person p2 = new Person("Inga", add2);
        Person p3 = new Person("David", add3);
        Person p4 = new Person("Teo", add4);
        Person p5 = new Person("Andreas", add5);

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        persons.add(p5);

        ListExercises.printAddressList(ListExercises.getAddresses(persons));

        System.out.println("----------Number 2----------------");

        List<String> listName = Arrays.asList("Ivan", "Maria", "Stephan", "John", "Amalia");
        //-------------------------------------------------
        List<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Maria");
        names.add("Stephan");
        names.add("John");
        names.add("Amalia");

        ListExercises.printStringList(ListExercises.namesFilter(names));
        System.out.println("*********");
        System.out.println(ListExercises.namesFilter(listName));

        System.out.println("----------Number 3----------------");

        Integer[] ints1 = {1, 2, 3, 4};
        Integer[] ints2 = {5, 2, 3, 8};
        List<Integer> lst_1 = Arrays.asList(ints1);
        List<Integer> lst_2 = Arrays.asList(ints2);

        /*
        int[] ints1 = new int[] {1, 2, 3, 4};
        int[] ints2 = new int[]{5, 2, 3, 8};
        List<Integer> list_1 = new ArrayList<>();
        for (int i : ints1)
        {
            list_1.add(i);
        }
        List<Integer> list_2 = new ArrayList<>();
        for (int i : ints2)
        {
            list_2.add(i);
        }

        ListExercises.printStringList(ListExercises.checkList(list_1,list_2));
        */

        ListExercises.printStringList(ListExercises.checkList(lst_1, lst_2));


        System.out.println("----------Number 4----------------");

        String[] str1 = {"aa", "bb", "cc", "dd"};
        String[] str2 = {"cc", "dd", "aa", "bb"};
        String[] str3 = {"dd", "ee", "ff"};
        String[] str4 = {"dd", "ff", "ee"};

        /*
        ArrayList<String> list1 = new ArrayList<>();

        for (String i : str1)
        {
            list1.add(i);
        }
        ArrayList<String> list2 = new ArrayList<>();
        for (String i : str2)
        {
            list2.add(i);
        }

        ArrayList<String> list3 = new ArrayList<>();
        for (String i : str3)
        {
            list3.add(i);
        }
        ArrayList<String> list4 = new ArrayList<>();
        for (String i : str4)
        {
            list4.add(i);
        }
        */

        List<String> list1 = Arrays.asList(str1);
        List<String> list2 = Arrays.asList(str2);
        List<String> list3 = Arrays.asList(str3);
        List<String> list4 = Arrays.asList(str4);

        System.out.println(ListExercises.isCircular(list1, list2));
        System.out.println(ListExercises.isCircular(list3, list4));


        System.out.println("----------Number 5----------------");

        // {1, 2, 3, 4, 5} -> {5, 4, 3, 2, 1}

        Integer[] ints = new Integer[]{1, 2, 3, 4, 5}; //Integer[] ints = {1, 2, 3, 4, 5} ; The same!
        /*
        List<Integer> listInts = new ArrayList<>();
        for (Integer k : ints)
        {
            listInts.add(k);
        }
        */

        List<Integer> listInts = Arrays.asList(ints);

        ListExercises.printIntegerList(ListExercises.reverseList(listInts));

        System.out.println("----------Number 6----------------");
        ListExercises.printStringList(list1);
        System.out.println("*****");
        ListExercises.printStringList(list2);
        System.out.println("*****");
        ListExercises.printStringList(ListExercises.unionLists(list1, list2));

        System.out.println("----------Number 7----------------");

        Integer[] integers = {1, 2, 3, 4, 5};
        List<Integer> listIntegers = Arrays.asList(integers);
        Integer num = 3;

        ListExercises.printIntegerList(ListExercises.modifyList(listIntegers, num));

        System.out.println("-------------SET----------------");

        System.out.println("----------SET_Number 1----------------");

        // for example
        // {“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”, “Piotr”, “Anna”}

        List<String> input1 = new ArrayList<>(Arrays.asList("Ivan", "Maria", "Piotr", "Anna", "Maria", "Ivan"));
        System.out.println(input1);
        System.out.println(SetExercises.removeDuplicates(input1));

        System.out.println("----------SET_Number 2----------------");

        //{“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”}

        System.out.println(input1);
        System.out.println(SetExercises.getDuplicates(input1));

        System.out.println("-------------MAP _ MapExercises----------------");

        System.out.println("----------MAP_Number 1----------------");

        /*
        mapAB({"a": "Hi", "b": "There"}) → {"a": "Hi", "ab": "HiThere", "b": "There"}
        mapAB({"a": "Hi"}) → {"a": "Hi"}
        mapAB({"b": "There"}) → {"b": "There"}
        */

        Map<String, String> input = new HashMap<>();
        input.put("a", "Hi");
        input.put("b", "There");
        input.put("c", "how");
        input.put("d", "are");
        input.put("e", "you");

        MapExercises.mergeKeys(input, "a", "b");
        System.out.println(input);

        System.out.println("----------MAP_Number 2----------------");

        /*
        wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        wordMultiple(["c", "c", "c", "c"]) → {"c": true}
         */

        String[] strings1 = {"a", "b", "a", "c", "b"};
        String[] strings2 = {"c", "b", "a"};
        String[] strings3 = {"c", "c", "c", "c"};
        System.out.println(MapExercises.wordMultiple(strings1));
        System.out.println(MapExercises.wordMultiple(strings2));
        System.out.println(MapExercises.wordMultiple(strings3));

        System.out.println("----------MAP_Number 3----------------");
        String string1 = "navi";
        String string2 = "vani";
        String string3 = "naan";
        String string4 = "nana";
        System.out.println(MapExercises.isAnagram(string4, string1));

        //{“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”} => {“navi”, “vani”}

        List<String> dictionary = new ArrayList<>(Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi"));
        System.out.println(MapExercises.sequenceAnagrams(dictionary, "naan"));

        System.out.println("----------MAP_Number 4----------------");

        List<String> list = new ArrayList<>(Arrays.asList("anna", "inga", "naan", "anna", "piotr", "inga", "anna"));
        System.out.println(MapExercises.numberOfRepeat(list, "inga"));

        System.out.println("----------MAP_Number 5----------------");
        String text = " It is about 6 p.m. Summer comes after spring. Let us meet at 10 a.m. " +
                "She was sleeping during the whole lesson. He laughed for 5 minutes. " +
                "I will be home in 10 minutes. I usually go shopping on Fridays." +
                " I will not go shopping till Sunday. You must do it within a month. go go go go go";

        System.out.println(MapExercises.mostOccuredWord(text));


        System.out.println("****************NEW VERSION MAP _ MapTasks ***********************");

        System.out.println("----------MAP_Number 2----------------");

        /*
        wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        wordMultiple(["c", "c", "c", "c"]) → {"c": true}
         */

        String[] letters1 = {"a", "b", "a", "c", "b"};
        String[] letters2 = {"c", "b", "a"};
        String[] letters3 = {"c", "c", "c", "c"};

        System.out.println(MapTasks.wordMultiple(letters1));
        System.out.println(MapTasks.wordMultiple(letters2));
        System.out.println(MapTasks.wordMultiple(letters3));

        System.out.println("----------MAP_Number 3----------------");

        String s1 = "navi";
        String s2 = "vani";
        String s3 = "naan";
        String s4 = "nana";

        System.out.println(MapTasks.isAnagram(s1, s2));

        List<String> dictionary1 = new ArrayList<>(Arrays.asList("anna", "ivan", "naan", "vani", "piotr", "nana", "navi"));
        System.out.println(MapTasks.sequenceAnagrams(dictionary1, "naan"));

        System.out.println("----------MAP_Number 4----------------");

        List<String> lst = new ArrayList<>(Arrays.asList("anna", "inga", "naan", "anna", "piotr", "inga", "anna"));
        System.out.println(MapTasks.numberOfRepeat(list, "anna"));

        System.out.println("----------ANAGRAM---------------");

        // list = Arrays.asList("ivan", "navi",	"vani",	"anna", "naan");

        Anagram.createVoc();

        for (int j = 0; j < Anagram.list.size() ; j++) {
            System.out.println(Anagram.findAnagrams(Anagram.list.get(j)));
        }


    }
}
