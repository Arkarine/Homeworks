import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DateFormatModifier {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("2019-05-18", "2015-04-25", "2009-04-22");
        System.out.println("Old list" + '\n' + list);
        System.out.println("Formatted list" + '\n' + reformatDates(list));

    }

    public static List<String> reformatDates(List<String> list){
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
