import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AmazonRailRoad {
    public static class Node{
        String city;
        List<Node> neighbors = new ArrayList<>();
        Node(String cityName){this.city = cityName;}
        boolean isConnected(Node destination){
            return this.neighbors.contains(destination);
        }
    }
    public static class Graph{
        Set<Node> graph = new HashSet<>();
        Graph(){}
        void addNode(Node cityName){
            graph.add(cityName);
        }
        void addEdge(Node source, Node destination){
            if(!source.neighbors.contains(destination))
                source.neighbors.add(destination);
        }
    }
    public static void main(String[] args){
        String[][] railRoads = {{"Seattle","Melbourne"},{"New York","Seattle"},{"Portland","New York"}};
        String origin = "Seattle";
        String destination = "Melbourne";
        System.out.println(" Can Travel ? "+canTravel(railRoads,origin,destination));
    }
    public static boolean canTravel(String[][] railroads,String origin, String destination){
        Graph railMap = new Graph();
        for(int i = 0 ; i < railroads.length ; i++){
            Node node = new Node(railroads[i][0]);
            Node neighbor = new Node(railroads[i][1]);
            railMap.addNode(node);
            railMap.addEdge(node,neighbor);
        }
        System.out.println(railMap.graph.);
        Node source = new Node(origin);
        Node destiny = new Node(destination);
        return source.isConnected(destiny);
    }
}
