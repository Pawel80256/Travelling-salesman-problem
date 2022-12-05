import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var cities = CitiesGenerator.readFromFile();
        cities.forEach(System.out::println);
    }
}
