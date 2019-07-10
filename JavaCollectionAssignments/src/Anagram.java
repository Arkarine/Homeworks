import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	/*
		 Анаграмма слова x - слово, по длине равное x и состоящее из таких же букв,
	что и x. Например, слово “vani” является анаграммой слова “ivan”, а слова
	“naan” и “anan” являются анаграммами слова “anna”. Дан словарь, сожержащий
	анаграммы, например {“anna”, “ivan”, “naan”, “vani”, “piotr”, “nana”, “navi”}.
	Написать функцию, которая по слову из словаря вернет все анаграммы этого
	слова, которые есть в словаре. Например, по слову “ivan” функция вернет
	{“navi”, “vani”}

	*/

    // key = sorted String, value = list of anagrams
    private static Map<String, List<String>> voc = new HashMap<>(); // vocabulary
    public static List<String> list = Arrays.asList("ivan",
            "navi",
            "vani",
            "anna",
            "naan");
    public static List<String> findAnagrams(String word){
        String s = sortWord(word);
        return voc.get(s);
    }

    public static void createVoc() {
        for(String s: list) {
            String alphS = sortWord(s);   //alphabetical S
            List<String> listS = voc.get(alphS);
            if(listS == null) {
                listS = new ArrayList<String>();
                voc.put(alphS, listS);
            }
            listS.add(s);
        }
    }


    public static String sortWord(String s) {

        // FIRST WAY
        char[] charArray = s.toCharArray();

		/*
		  SECOND WAY
		char[] charArray = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			charArray[i] = s.charAt(i);
		}
		*/

        Arrays.sort(charArray);
        return new String(charArray);
    }

}
