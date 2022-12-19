import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var cities = CitiesGenerator.readFromFile();
//        cities.forEach(System.out::println);

//        var edgeService = new EdgeService(cities);
//        cities.forEach(c -> System.out.println(edgeService.getEdgesForCityByName(c.getName())));
//        List<City> cities = new ArrayList<>();
//        cities.add(new City("Kraków", 0, 0));
//        cities.add(new City("Warszawa", 0, 5));
//        cities.add(new City("Wrocław", 0, 10));
//        cities.add(new City("Poznań", 10, 10));

        SimulatedAnnealingTSP solver = new SimulatedAnnealingTSP(cities);
        List<City> bestPath = solver.findBestPath();

        bestPath.forEach(System.out::println);
    }
}
