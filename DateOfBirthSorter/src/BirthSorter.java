import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BirthSorter {
    public static void main(String[] args) {

        System.out.println(sortBirthDate());
    }

    private static  DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public  static List<String> sortBirthDate(){
        try {BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
            Stream<String> lines = bufferedReader.lines();


            List<String> sortedLines = lines
                    //.map(line -> createPerson(line))    OR
                    .map(BirthSorter::createPerson)
                    //.sorted((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()))   OR
                    .sorted(Comparator.comparing(Person::getDateOfBirth))
                    //.map(p -> createString(p))   OR
                    .map(BirthSorter::createString)
                    .collect(Collectors.toList());

            return sortedLines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static Person createPerson(String string) {
        String[] data = string.split(",");
        return new Person(data[0], LocalDate.parse(data[1], dateTimeFormatter));
    }

    public static String createString(Person person) {
        return "["+ person.getName() +", " + person.getDateOfBirth() +"]";
    }

    //---------------------------------------

    public  static List<String> sortBirthDate1() {
        try {BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));

            Stream<String> lines = bufferedReader.lines();

            List<String> sortedLines = lines
                    .map((l) -> Arrays.asList(l.split(",")))
                    .sorted((lin1, lin2) -> LocalDate.parse(lin1.get(lin1.size() - 1), dateTimeFormatter)
                            .compareTo(LocalDate.parse(lin2.get(lin2.size() - 1), dateTimeFormatter)))
                    .map(Object::toString)       //.map(l -> l.toString())
                    .collect(Collectors.toList());
            return  sortedLines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
