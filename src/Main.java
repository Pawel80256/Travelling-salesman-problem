import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var cities = CitiesGenerator.readFromFile();
        cities.forEach(System.out::println);

        var edgeService = new EdgeService(cities);
        cities.forEach(c -> System.out.println(edgeService.getEdgesForCityByName(c.getName())));
    }
}
