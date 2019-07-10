
import java.util.*;

class MapExercises {

    //----------Number 1----------------

     static Map<String, String> mergeKeys(Map<String, String> input, String key1, String key2){
         if(input.containsKey(key1) && input.containsKey(key2)){
             input.put(key1+key2, input.get(key1)+input.get(key2));
         }
         return input;
     }

    //----------Number 2----------------

     /*
     wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
     wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
     wordMultiple(["c", "c", "c", "c"]) → {"c": true}
     */

     // ---------In the MapTasks class there is a solution of another version

    private static boolean isMultiple(String[] strings, String symbol){
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals(symbol)){
                count ++;
            }
        }

        return (count > 1);
    }

    static Map<String, Boolean> wordMultiple(String[] strings){
        Map<String, Boolean> result = new HashMap<>();
        for (String s: strings) {
            result.put(s, isMultiple(strings,s));
        }
        return result;
    }

    //----------Number 3----------------

    // ---------In the MapTasks class there is a solution of task through HashMap

    static boolean isAnagram(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if(str2.indexOf(str1.charAt(i)) == -1 || str1.indexOf(str2.charAt(i)) == -1){
                return false;
            }
        }
        return true;
    }

    static List<String> sequenceAnagrams (List<String> dictionary, String word){
        List<String> anagrams = new ArrayList<>();
        if(!dictionary.contains(word)){
            System.out.println("Invalid word");
            return Collections.EMPTY_LIST;
        }
        for (String s: dictionary) {
            if(isAnagram(word, s) && !word.equals(s))  {
                anagrams.add(s);
            }
        }
        return anagrams;
    }

    //----------Number 4----------------

    // ---------In the MapTasks class there is a solution of task through HashMap

    static int numberOfRepeat (List<String> list, String name){

        int counter = 0;
        for (String s: list) {
            if(s.equals(name)){
                counter ++;
            }
        }
        return counter;
    }

    //----------Number 5----------------

    // simple prepositions "about, after, at, during, for, in, on, till, within"

    static String mostOccuredWord(String text){

        text = text.replace('.', ' ');
        text = text.replace(',', ' ');

        Set<String> prepositions = new HashSet<>(Arrays.asList("about", "after", "at", "during", "for", "in", "on", "till", "within", ""));

        List<String> trimmedText = new ArrayList<>(Arrays.asList(text.split(" ")));

        trimmedText.removeAll(prepositions);
        System.out.println(trimmedText);

        Map <String, Integer> map = new HashMap<>();
        for (String s: trimmedText) {
            if(map.containsKey(s)){

                // "put" will update the value V for key K and returns the old value i.e.
                // When the value of key don’t even exist
                //It will return null and will add a new entry in the map for given key and value.
                //
                //"Replace" will update the value V for key K and returns the old value i.e.
                //For key that don’t even exists method "replace"
                //will NOT add the new key value entry in map and returns null.

                map.put(s,map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }

        String maxKey = trimmedText.get(0);

        for (String s: map.keySet()) {
            if(map.get(maxKey) < map.get(s)){
                maxKey = s;
            }
        }
        return maxKey;
    }
}
