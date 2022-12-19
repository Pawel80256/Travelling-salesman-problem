import java.util.List;

public class City {
    private String name;
    private int x;
    private int y;
//    private List<Edge> edges;

    public City(){

    }

    public City(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

//    public List<Edge> getEdges() {
//        return edges;
//    }
//
//    public void setEdges(List<Edge> edges) {
//        this.edges = edges;
//    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

//    public class Edge {
//        private final City destination;
//        private final Integer distance;
//
//        public Edge(City destination) {
//            this.destination = destination;
//            this.distance = calculateDistanceBeetwenCities();
//        }
//
//        public Integer calculateDistanceBeetwenCities() {
//            var xDiff = destination.x - x;
//            var yDiff = destination.y - y;
//
//            return (int) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
//        }
//
//        public City getDestination() {
//            return destination;
//        }
//
//        public Integer getDistance() {
//            return distance;
//        }
//
//        @Override
//        public String toString() {
//            return "Edge{" +
//                    "destination=" + destination +
//                    ", distance=" + distance +
//                    '}';
//        }
//    }
}
