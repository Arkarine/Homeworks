import java.util.function.*;

public class LambdaExpression {
    public static void main(String[] args) {

        //----------0-------------
        NumberSummable n = (a,b) -> a+b;
        System.out.println("Sum = " + n.sum(2, 4));

        //Package java.util.function (Functional interfaces )
        BiFunction<Integer,Integer,Integer> bi1 = (a, b) -> a+b;
        System.out.println("Sum = " + bi1.apply(2, 4));

        //----------1-----------
        StringConcate s = (a,b) -> Integer.toString(a).concat(Integer.toString(b));
        System.out.println(s.concat(7, 8));

        //Package java.util.function (Functional interfaces )
        BiFunction<Integer,Integer,String> bi2 = (a,b) -> Integer.toString(a).concat(Integer.toString(b));
        System.out.println(bi2.apply(7,8));

        //-----------2-----------
        //check("abc") -> true

        Checkable c = in -> in.length() == 3;
        System.out.println(c.check("Hello"));

        //Package java.util.function (Functional interfaces )
        Predicate<String> pr1 = in -> in.length() == 3;
        System.out.println(pr1.test("Hello"));

        //-----------3-----------
        Checkable c1 = in -> in.length()%2 == 0;
        System.out.println(c1.check("Hi"));

        //Package java.util.function (Functional interfaces )
        Predicate<String> pr2 = in -> in.length()%2 == 0;
        System.out.println(pr2.test("Hi"));

        //-----------4-----------
        // modify(“abcDe”) -> “ABCDE”

        Transformable t = in -> in.toUpperCase();
        System.out.println(t.modify("asdfsd"));

        //Package java.util.function (Functional interfaces )
        Function<String,String> f1 = in -> in.toUpperCase();
        System.out.println(f1.apply("asdfsd"));

        //-----------5-----------
        Transformable t1 = in -> in.length()==4 ? "****" : in;
        System.out.println(t1.modify("asdf"));

        //Package java.util.function (Functional interfaces )
        Function<String,String> f2 = in -> in.length()==4 ? "****" : in;
        System.out.println(f2.apply("asdf"));


        //-----------6-----------
        //print(“abc”) ->  ”!abc!”

        Printable p = st -> System.out.println("!" + st + "!");
        p.print("zxcv");

        //Package java.util.function (Functional interfaces )
        Consumer<String> con = st -> System.out.println("!" + st + "!");
        con.accept("zxcv");

        //-----------7-----------
        Producable pr = () -> "Hello World";
        System.out.println(pr.produce());

        //Package java.util.function (Functional interfaces )
        Supplier<String> sup = () -> "Hello World";
        System.out.println(sup.get());
    }
}
