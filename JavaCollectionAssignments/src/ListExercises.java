import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class ListExercises {

    static void printStringList(List<String> strings){
        for (String s: strings) {
            System.out.println(s);
        }
    }

    static void printIntegerList(List<Integer> ints){
        for (Integer s: ints) {
            System.out.println(s);
        }
    }

    //----------Number 1----------------

    static List<Address> getAddresses(List<Person> persons){
        List<Address> addresses = new ArrayList<>();

        for (Person p: persons) {
            addresses.add(p.getPersonAddress());
        }
        return addresses;
    }

     static void printAddressList(List<Address> addresses) {
        for (Address address: addresses) {
            System.out.println(address);
        }

    }

    //----------Number 2----------------

    /*          BAD VERSION
    public static List<String> namesFilter1(List<String> names){
        for (int i = 0; i < names.size(); i++) {
            if(names.get(i).length() == 4){
                names.remove(names.get(i));
            }
        }
        return names;
    }
    */


     static List<String> namesFilter(List<String> names){
        List<String> result = new ArrayList<>();
         for (String t: names) {
             if(t.length() != 4){
                 result.add(t);
             }
         }
        return result;
    }



    //----------Number 3----------------
     static List<String> checkList(List<Integer> list1, List<Integer> list2){
        if(list1 == null || list2 == null || list1.size() != list2.size()){
            System.out.println("Invalid lists");
            return Collections.EMPTY_LIST;
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) == null || list2.get(i) == null){
                System.out.println("Null object");
                return Collections.EMPTY_LIST;
            }
            if(list1.get(i).equals(list2.get(i)) ){
                result.add("Yes");
            }
            else{
                result.add("No");
            }
        }
        return result;
    }
    //----------Number 4----------------
    static boolean isCircular(List<String> list1, List<String> list2){
        if(list1.size() != list2.size()){
            System.out.println("The lists have different sizes.");
            return false;
        }

        List<String> tmp = new ArrayList<>(list1.size());
        tmp.addAll(list1);

        for (int i = 0; i < list1.size() ; i++) {

            tmp.add(tmp.get(0));
            tmp.remove(tmp.get(0));

            if(tmp.get(i).equals(list2.get(i))){
                return true;
            }
        }
        return false;
    }

    //----------Number 5----------------


    static List<Integer>  reverseList(List<Integer> list){
        //Collections.reverse(list);
        List<Integer> reverse = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            reverse.add(i, list.get(list.size()-1-i));
        }
        return reverse;
    }

    //----------Number 6----------------

    static  List<String> unionLists(List<String> list1, List<String> list2){
        List<String> unit = new ArrayList<>(list1.size()+list2.size());
        unit.addAll(list1);
        unit.addAll(list2);
        return unit;
    }

    //----------Number 7----------------

    static List<Integer> modifyList(List<Integer> list, Integer num){
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            if(integer.compareTo(num) <= 0){    // integer > num and (int num) // the same
                result.add(integer);
            }
        }
        return result;
    }

}
