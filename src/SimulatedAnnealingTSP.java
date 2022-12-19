import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatedAnnealingTSP {
    private final List<City> cities;
    private final Random random;

    public SimulatedAnnealingTSP(List<City> cities) {
        this.cities = cities;
        this.random = new Random();
    }

    public List<City> findBestPath() {
        // Ustawiamy początkową temperaturę T oraz warunki stopu
        double T = 100;
        int maxIterations = 200000;
        double desiredAccuracy = 0.001;

        // Losujemy początkową ścieżkę
        List<City> currentPath = new ArrayList<>(cities);
        Collections.shuffle(currentPath);

        // Obliczamy długość początkowej ścieżki
        int currentPathLength = calculatePathLength(currentPath);

        // Dla każdej iteracji algorytmu:
        for (int i = 0; i < maxIterations; i++) {
            // Losujemy nową ścieżkę poprzez zamianę kolejności dwóch losowo wybranych miast w aktualnej ścieżce
            List<City> newPath = new ArrayList<>(currentPath);
            int index1 = random.nextInt(cities.size());
            int index2 = random.nextInt(cities.size());
            Collections.swap(newPath, index1, index2);

            // Obliczamy długość nowej ścieżki
            int newPathLength = calculatePathLength(newPath);

            // Obliczamy różnicę pomiędzy długościami początkowej i nowej ścieżki
            int delta = newPathLength - currentPathLength;

            // Jeśli różnica jest ujemna (nowa ścieżka jest lepsza), to przyjmujemy nową ścieżkę jako aktualną
            if (delta < 0) {
                currentPath = newPath;
                currentPathLength = newPathLength;
            } else {
                // W przeciwnym wypadku, losujemy liczbę p z przedziału (0,1) i sprawdzamy, czy p jest mniejsze niż e^(-delta/T)
                double p = random.nextDouble();
                if (p < Math.exp(-delta / T)) {
                    currentPath = newPath;
                    currentPathLength = newPathLength;
                }
            }
            // Obniżamy temperaturę o określoną wartość (np. o 10% jej aktualnej wartości)
            T *= 0.9;
            // Sprawdzamy, czy warunki stopu zostały spełnione
            if (T < desiredAccuracy) {
                break;
            }
        }


        // Zwracamy najlepszą znalezioną ścieżkę
        return currentPath;

    }

    private int calculatePathLength(List <City> path) {
        int length = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            length += getDistanceBetweenCities(path.get(i), path.get(i + 1));
        }
        return length;
    }

    private int getDistanceBetweenCities (City city1, City city2){
        // Obliczamy odległość pomiędzy miastami city1 i city2
        // Możemy to zrobić np. przez obliczenie odległości euklidesowej pomiędzy nimi
        int xDiff = city1.getX() - city2.getX();
        int yDiff = city1.getY() - city2.getY();
        return (int) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }
}