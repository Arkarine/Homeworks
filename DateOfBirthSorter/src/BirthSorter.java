import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BirthSorter {
    public static void main(String[] args) {

        System.out.println(sortBirthDate());
    }

    public  static List<String> sortBirthDate() {
        try {BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));

            Stream<String> lines = bufferedReader.lines();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            List<String> sortedLines = lines.map((l) -> Arrays.asList(l.split(",")))
                    .sorted((lin1, lin2) -> LocalDate.parse(lin1.get(lin1.size() - 1), dateTimeFormatter)
                            .compareTo(LocalDate.parse(lin2.get(lin2.size() - 1), dateTimeFormatter)))
                    //.map(l -> l.toString())
                    .map(Object::toString)
                    .collect(Collectors.toList());
            return  sortedLines;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
