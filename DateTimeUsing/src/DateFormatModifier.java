import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DateFormatModifier {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2019-05-18", "2015-04-25", "2009-04-22");
        System.out.println("Old list" + '\n' + list);
        System.out.println("Formatted list" + '\n' + reformatDates(list));
    }

    //The task through Stream API

    public static List<String> reformatDates(List<String> list){
        DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd MMMM, yyyy EEEE", Locale.ENGLISH);


        List<String>  reformattedDates = list
                .stream()
                .map(s -> LocalDate.parse(s,formatterIn))
                .map(date -> date.format(formatterOut))
                .collect(Collectors.toList());

        return reformattedDates;
    }

    public static List<String> reformatSortDates(List<String> list){
        DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd MMMM, yyyy EEEE", Locale.ENGLISH);


        List<String>  reformattedSortedDates = list
                .stream()
                .map(s -> LocalDate.parse(s,formatterIn))
                .sorted()
                .map(date -> date.format(formatterOut))
                .collect(Collectors.toList());

        return reformattedSortedDates;
    }

    //The task through loop

    public static List<String> reformatDates1(List<String> list){
        List<LocalDate> dates = new ArrayList<>();

        for (String s : list) {
            LocalDate parse = LocalDate.parse(s);
            dates.add(parse);
        }

        List<String> result = new ArrayList<>();

        for (int j = 0; j < dates.size(); j++) {
            String format = dates.get(j).format(DateTimeFormatter.ofPattern("(dd. MMM, yyyy EEEE)"));
            result.add(format);
        }
        return result;
    }

}
