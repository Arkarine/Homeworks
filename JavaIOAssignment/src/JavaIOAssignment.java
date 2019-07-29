import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIOAssignment {
    public static void main(String[] args) {
        System.out.println("----------1----------");
        System.out.println(sumOfNumbers("file1.txt"));

        System.out.println("----------2----------");
        System.out.println(sortArrayOfString("file2.txt"));

        System.out.println("----------3----------");
        sortByAge("file3.csv");

        System.out.println("----------4----------");
        Customer c1 = new Customer("Anna", "Shmidt", 45);
        Customer c2 = new Customer("Olga", "Fisher", 25);
        Customer c3 = new Customer("Tom", "Humbolt", 15);
        Customer c4 = new Customer("Artur", "Hausman", 38);
        List<Customer> list = Arrays.asList(c1, c2, c3, c4);

        writeInFile(list, "out.csv");

        System.out.println("----------5----------");


        // from   C:\Users\Karine\Desktop\Folder1\bigfile.zip
        // to     C:\Users\Karine\Desktop\Folder2

        System.out.println("Copying file using streams");
        System.out.println("Cofying bigfile.zip file from Folder1 to Folder2, keeping file name");

        copyFile("C:\\Users\\Karine\\Desktop\\Folder1\\bigfile.zip", "C:\\Users\\Karine\\Desktop\\Folder2\\bigfile.zip");

        System.out.println("----------6----------");
        System.out.println(sortBySum("file6.txt"));

        System.out.println("-----------7------------");

        sortByDateOfBirth("file7.txt", "out7.txt");

    }

    //-------------JavaIOAssignment1-------------------

    //---------------------1----------------------
        /*
    1.Есть текстовый файл, где каждая строка - целое число:
    1
    2
    5
    45
    54
    Написать функцию,
    которая принимает имя файла, возвращает сумму чисел из файла.
    Подсказка: FileReader, BufferedReader плюс stream API.
    */
    public static int sumOfNumbers(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int sum = reader.lines()
                    //.mapToInt(line -> Integer.parseInt(line))   OR
                    .mapToInt(Integer::parseInt)
                    .sum();

            // OR
            //.reduce((a, b) -> a + b)   OR ---------
                    //.reduce(Integer::sum)
                    //.orElse(0);
            return sum;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    //---------------------2----------------------
    /*
    2. Есть массив строк разной длины. Отсортировать его по длине строк.
    Пример:вход ​{“aaa”, “bbbb”, “a”, ‘bb”}​, выход ​{“a”, “bb”, “aaa”, “bbbb”}​.
    Подсказка:Stream API, sorted, Comparator, lambda functions, Java Doc.
     */
    public static String sortArrayOfString(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String sorted = Arrays.stream(reader.readLine().split(", "))
                    .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                    .collect(Collectors.joining(", "));
            return sorted;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    //--------------------------3-----------------------
    /*
    3. Есть текстовый csv файл:
    “Ivan”, “18”
    “Piotr”, “20”
    “Anna”, “10”
    Вывести на экран отсортированный по возрасту список.
    Подсказка: вычитать файл построчно с помощью Reader’a,
    положить данные в список классов  Person, список отсортировать с
    помощью Stream API.Можно усложнить - вычитать только тех, кто старше 17 лет.
    Тут разные варианты решения: вычитать всех, потом отсортировать тех, кто старше 17,
    но если список вфайле большой, то может не стоит создавать объекты в Джаве,
    то есть проверять впроцессе чтения и создавать Джава объекты только
    для тех пользователей, что старше 17.
     */
    public static  void  sortByAge(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            reader.lines()
                    .map(l -> l.split(", "))
                    .filter(array -> Integer.parseInt(array[1]) > 17)
                    .map(array -> new Person(array[0], Integer.parseInt(array[1])))
                    .sorted(Comparator.comparingInt(Person::getAge))
                    .map(Person::toString)
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //------------------4-------------------------
    /*
    4. есть список Customers: firstName, lastName, age -сохранить его в csv файл, похожий на то, что в 3.
     */
    public  static void writeInFile (List<Customer> list, String fileName){
        try(PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {

            list.stream()
                    .sorted((c1, c2) -> Integer.compare(c1.getAge(), c2.getAge()))
                    .map(Customer::toString)
                    //.forEach(s -> writer.print(s));
                    .forEach(writer::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //-------------JavaIOAssignment2-------------------

    //------------------5-------------------------
    /*
    Задача 1
    Написать функцию
    public void copyFile(String from, String to){}
    которая принимает файл и цель и копирует файл. Например,
    copyFile(“c:\\temp\\bigfile.zip”, “c:\\temp2”)
    должна скопировать ​bigfile.zip​ в папку ​temp2​.
    Возможны 3 реализации: вычитывание файла побайтово, вычитывание блоками в
    буфер заданного размера или вычитывание того, что доступно для вычитывания с
    использованием функции available().
    */

    // "Cofying bigfile.zip file from Folder1 to Folder2"


    public static void copyFile(String sourseFile, String targetFile) {

        try(FileInputStream fis = new FileInputStream(sourseFile);
            FileOutputStream fos = new FileOutputStream(targetFile)){

            byte[] buffer = new byte[1024];
            int noOfBytes = 0;
            while ((noOfBytes = fis.read(buffer)) != -1){
                fos.write(buffer, 0, noOfBytes);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //------------------6-------------------------
    /*
    Задача 2
    Есть файл:
    Sergey,Lukichev,Notebook Lenovo,500
    Piotr,Ivanov,Apple MacBook,800
    Sergey,Lukichev,Keyboard Cherry,25
    Ivan,Petrov,Mouspad,5
    Piotr,Ivanov,Apple Touchpad,60

    То есть список имен с оборудованием и оценочной стоимостью. Имена могут
    повторяться. Нужно написать программу, которая вернет файл с отсортированным по
    сумме списком имен и суммой по стоимости для каждого человека:
    Ivan Petrov,5
    Sergey Lukichev,525
    Piotr Ivanov,860
    */

    public static List<String> sortBySum (String fileName){

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            Map<String, Integer> collect = reader.lines()
                    .map(l -> l.split(","))
                    .map(array -> new Person6(array[0], array[1], array[2], Integer.parseInt(array[3])))
                    .collect(Collectors.groupingBy(Person6::getFirstLastName, Collectors.summingInt(Person6::getPrice)));

            List<String> sorted = collect
                    .entrySet()
                    .stream()
                    //.sorted((a, b) -> a.getValue().compareTo(b.getValue()))
                    .sorted(Comparator.comparing(Map.Entry::getValue))
                    //.map(o -> convertToString(o))
                    .map(JavaIOAssignment::convertToString)
                    .collect(Collectors.toList());
            return sorted;


        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;

    }

    public static String convertToString(Map.Entry<String, Integer> o){
        return o.getKey() + "," + o.getValue();
    }

    //------------------7-------------------------
    /*
    Задача 3
    Есть файл со списком имен с датами рождения:
    Sergey,15-02-1979
    Ivan,22-03-1986
    Piotr,01-10-1955
    Anna,13-12-1995
    Нужно написать программу, которая возвращает файл со списком имен и дат
    рождений, отсортированный по дате рождения.

    Дополнительное задание​​: те строки в файле, для которых дата рождения указана вдругом формате,
    записать в отдельный файл без изменений.
    */

    public static void sortByDateOfBirth(String from, String to){
        try(BufferedReader reader = new BufferedReader(new FileReader(from));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(to)))){
            List<String> sorted = reader.lines()
                    //.map(line -> stringToPerson(line)) OR
                    .map(JavaIOAssignment::stringToPerson)
                    //.sorted((p1, p2) -> p1.getDateOfBirth().compareTo(p2.getDateOfBirth()))  OR
                    .sorted(Comparator.comparing(Person7::getDateOfBirth))
                    //.map(p -> personToString(p))   OR
                    .map(JavaIOAssignment::personToString)
                    .collect(Collectors.toList());

            sorted.stream()
                    //.forEach(st -> writer.print(st));  OR
                    .forEach(writer::println);

            System.out.println(sorted);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static Person7 stringToPerson(String s) {
		String [] p = s.split(",");
		return new Person7(p[0], LocalDate.parse(p[1], formatter));
	}

	public static String personToString(Person7 p) {
		return p.getName() + "," + p.getDateOfBirth().format(formatter);
	}


}
