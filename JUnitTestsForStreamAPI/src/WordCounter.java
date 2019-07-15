import java.util.Arrays;

public class WordCounter {
    /*
    Написать функцию, которая принимает предложение, а возвращает
количество слов, начинающихся на заданную букву.
     */

    public static long countWords(String st, String letter){
        if(st == null || letter == null){
            System.out.println("Input arguments are wrong!");
            return 0;
        }

        String[] stArray = st.split(" ");

        long result = Arrays.stream(stArray)
                .filter(s -> s.startsWith(letter))
                .count();

        return result;
    }
}
