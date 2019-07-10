public class Recursion {
    public static void main(String[] args) {
        String s = "absd";
        System.out.println("Reverse of string 'absd' is " + reverse(s));
        System.out.println(factorial(4));
    }

     // reverse("absd") -> "dsba"
    /*
    public static String reverse1(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
    */

    private static String reverseByRec(String s, int i){
        if(i == 0){
            return Character.toString(s.charAt(0));
        }
        return Character.toString(s.charAt(i)) + reverseByRec(s, i - 1);

    }

    public static String reverse (String s){
        return reverseByRec(s, s.length()-1);
    }


    public static int factorial (int n){
        if(n == 1) return 1;
        return n * factorial(n-1);
    }
}
