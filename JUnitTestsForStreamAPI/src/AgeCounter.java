import java.util.List;
import java.util.Optional;

public class AgeCounter {

    /*
        Для списка persons посчитать общий возраст тех, кому больше 17 лет.
        Подсказка - reduce()
    */

    public static int countAges(List<Person> listPersons){
        if(listPersons == null){
            System.out.println("Wrong argument");
            return 0;
        }

        Integer reduce = listPersons.stream()
                .filter(p -> p!= null)
                .map(Person::getAge)
                .filter(p -> p > 17)
                .reduce(Integer::sum).orElse(0);

        return reduce;

    }

}
