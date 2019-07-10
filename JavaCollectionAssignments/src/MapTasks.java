import java.util.*;

public class MapTasks {

    //-------------2---------------------

    static Map<String, Boolean> wordMultiple (String[] letters){

        Map<String, Boolean> map = new HashMap<>();
        for (int i = 0; i < letters.length ; i++) {
            if(map.containsKey(letters[i])){
                map.put(letters[i], true);
            }
            else {
                map.put(letters[i], false);
            }
        }
        return map;
    }

    //-------------3---------------------

    static boolean isAnagram (String s1, String s2){
        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if(s1Map.containsKey(s1.charAt(i))){
                s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i)) + 1);
            }
            else {
                s1Map.put(s1.charAt(i), 1);
            }

            if(s2Map.containsKey(s2.charAt(i))){
                s2Map.put(s2.charAt(i), s2Map.get(s2.charAt(i)) + 1);
            }
            else {
                s2Map.put(s2.charAt(i), 1);
            }
        }

        Set<Character> s1Keys = s1Map.keySet();
        Set<Character> s2Keys = s2Map.keySet();
        if(s1Keys.size() != s2Keys.size()){
            return false;
        }
        for (Character chr : s1Keys ) {
            if(!s2Keys.contains(chr) || s1Map.get(chr) != s2Map.get(chr)){
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

    //------------------4---------------------

    static int numberOfRepeat (List<String> list, String name){
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            if (map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else{
                map.put(s,1);
            }
        }
        if(!map.containsKey(name)){
            return 0;
        }
        return map.get(name);
    }

}
