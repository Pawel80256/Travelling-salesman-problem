import java.util.*;

public class SimulatedAnnealingTSP {
    private final List<City> cities;
    private final Random random;

    public SimulatedAnnealingTSP(List<City> cities) {
        this.cities = cities;
        this.random = new Random();
    }

    public List<City> findBestPath() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object

        // Ustawiamy początkową temperaturę T oraz warunki stopu
        double T = 100;
        System.out.println("Podaj maksymalną liczbę iteracji:");
        int maxIterations = sc.nextInt();
        System.out.println("Podaj dokładność:");
        double desiredAccuracy = sc.nextDouble();
        System.out.println("Wybierz tryb:");
        System.out.println("1. Wyświetl aktualnie najkrótszą ścieżkę w każdej iteracji");
        System.out.println("2. Wyświetl wyliczoną ścieżkę w każdej iteracji, na końcu najkrótszą");
        System.out.println("3. Wyświetl obydwie wartości");

        int mode = sc.nextInt();

        while (mode != 1 && mode != 2 && mode != 3){
            System.out.println("Wybierz poprawną wartość");
            mode = sc.nextInt();
        }

        // Losujemy początkową ścieżkę
        List<City> currentPath = new ArrayList<>(cities);
        Collections.shuffle(currentPath);

        // Obliczamy długość początkowej ścieżki
        int currentPathLength = calculatePathLength(currentPath);

        // Dla każdej iteracji algorytmu:
        for (int i = 0; i < maxIterations; i++) {
            // Losujemy nową ścieżkę poprzez zamianę kolejności dwóch losowo wybranych miast w aktualnej ścieżce
            System.out.println("ITERACJA " + i);
            List<City> newPath = new ArrayList<>(currentPath);
            int index1 = random.nextInt(cities.size());
            int index2 = random.nextInt(cities.size());
            Collections.swap(newPath, index1, index2);

            // Obliczamy długość nowej ścieżki
            int newPathLength = calculatePathLength(newPath);

            if(mode == 2 || mode == 3){
                System.out.println("Wyliczona ścieżka: " + newPathLength);
            }

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

            // Obniżamy temperaturę o określoną wartość
            T *= 0.9;

            if(mode == 1 || mode == 3){
                System.out.println("Najkrótsza ścieżka: " + currentPathLength);
            }

            // Sprawdzamy, czy warunki stopu zostały spełnione
            if (T < desiredAccuracy) {
                if(mode == 2){
                    System.out.println("Najkrótsza ścieżka: " + currentPathLength);
                }
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
        int xDiff = city1.getX() - city2.getX();
        int yDiff = city1.getY() - city2.getY();
        return (int) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
    }
}