import java.util.*;

 class SetExercises {

    //----------Number 1----------------

    // for example
    // {“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”, “Piotr”, “Anna”}

    static List<String> removeDuplicates(List<String> input){
        Set<String> set = new HashSet<>(input);
       return new ArrayList<>(set);
   }

    //----------Number 2----------------

    //{“Ivan”, “Maria”, “Piotr”, “Anna”, “Maria”, “Ivan”} -> {“Ivan”, “Maria”}

    static List<String> getDuplicates(List<String> input){
        List<String> unique = removeDuplicates(input);

        for (String st: unique) {
            input.remove(st);
        }
        return removeDuplicates(input);
    }

}
