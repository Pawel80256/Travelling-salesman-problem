import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CitiesGenerator {
    public static final String filepath = "cities.csv";

    public static List<City> readFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filepath));
        scanner.useDelimiter(",");
        List<City> result = new ArrayList<>();
        City city = new City();
        int iter = 0;

        while (scanner.hasNext()){
            switch (iter) {
                case 0 -> city.setName(scanner.next());
                case 1 -> city.setX(Integer.parseInt(scanner.next()));
                case 2 -> city.setY(Integer.parseInt(scanner.next()));
            }
            iter++;
            if(iter == 3){
                result.add(city);
                city = new City();
                iter = 0;
            }
        }
        System.out.println();
        return result;
    }
}
