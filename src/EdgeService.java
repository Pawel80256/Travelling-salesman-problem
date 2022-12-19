/*
import java.util.ArrayList;
import java.util.List;

public class EdgeService {
    private final List<City> cities;

    public EdgeService(List<City> cities) {
        this.cities = cities;
    }

    public List<City.Edge> getEdgesForCityByName(String cityName) {
        var city = cities.stream()
                .filter(c -> c.getName().equals(cityName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No city found with name equal " + cityName + "."));

        var edges = new ArrayList<City.Edge>();

        cities.stream()
                .filter(c -> !c.getName().equals(cityName))
                .forEach(c -> edges.add(city.new Edge(c)));

        return edges;
    }
}
*/
