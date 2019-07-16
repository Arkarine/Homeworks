import java.util.Arrays;

public class WordCounter {
    /*
    Написать функцию, которая принимает предложение, а возвращает
количество слов, начинающихся на заданную букву.
     */


    public static long countWords(String st, String letter) throws IllegalArgumentException {

        if(st == null || letter == null){
            throw new IllegalArgumentException("Input arguments are wrong!");
        }

        String[] stArray = st.split(" ");

        long result = Arrays.stream(stArray)
                .filter(s -> s.startsWith(letter))
                .count();

        return result;
    }
}
