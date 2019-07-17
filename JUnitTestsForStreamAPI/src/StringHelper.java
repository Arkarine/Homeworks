public class StringHelper {
    /*
    Написать функцию, которая проверяет, является ли заданная строка целым числом.
     */

    public static boolean isInteger(String input){
        return input.matches("\\d*");
    }

}
