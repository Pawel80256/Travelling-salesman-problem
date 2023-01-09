import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        var cities = CitiesGenerator.readFromFile();

        SimulatedAnnealingTSP solver = new SimulatedAnnealingTSP(cities);
        List<City> bestPath = solver.findBestPath();

        bestPath.forEach(System.out::println);
    }
}
