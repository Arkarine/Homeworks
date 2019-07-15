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

        for (Person p : listPersons) {
            if(p == null){
                System.out.println("Wrong Object");
                return 0;
            }
        }

        Optional<Integer> reduce = listPersons.stream()
                .map(Person::getAge)
                .filter(p -> p > 17)
                .reduce(Integer::sum);
        int sum = 0;
        if(reduce.isPresent()){
            sum = reduce.get();
        }
        return sum;
    }

}
