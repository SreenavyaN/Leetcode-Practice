import java.util.*;

public class AmazonRailRoad {
    public static class Node{
        private String city;
        private Set<Node> neighbors = new HashSet<>();
        public Node(){}
        public Node(String cityName){ this.city = cityName;}
        public Set<Node> getNeighbors(){ return this.neighbors;}
        public void addNeighbor(Node node){ this.neighbors.add(node); }
        public boolean isNeighbor(Node node){
            return this.neighbors.contains(node);
        }
    }
    public static class Graph{
        private Set<Node> graph = new HashSet<>();
        Graph(){}
        public void addNode(String cityName){
            Node temp = new Node(cityName);
            graph.add(temp);
        }
        public void addEdge(String source, String destination){
            Node n1 = new Node(source);
            Node n2 = new Node(destination);
            if(!graph.contains(n1) && !graph.contains(n2)){
                graph.add(n1);
                graph.add(n2);
            }
            else if(!graph.contains(n1)){
                graph.add(n1);
            }
            else if(!graph.contains(n2)){
                graph.add(n2);
            }
            n1.addNeighbor(n2);
            n2.addNeighbor(n1);
        }
        public boolean hasNode(Node checkNode){
            return graph.contains(checkNode);
        }
        public boolean isEdge(Node node1,Node node2){
            return node1.isNeighbor(node2) && node2.isNeighbor(node1);
        }
        public Set<Node> nodeSet(){
            return graph;
        }
        public Node getNode(String cityName){
            for (Node temp : graph) {
                if (temp.city.equals(cityName))
                    return temp;
            }
            return new Node();
        }
    }
    public static void main(String[] args){
        String[][] railRoads = {{"Seattle","Melbourne"},{"New York","Seattle"},{"Portland","New York"}};
        //String origin = "Seattle";
        //String destination = "Melbourne";
        //System.out.println(" Can Travel ? "+canTravel(railRoads,origin,destination));
        Graph railMap = new Graph();
        railMap = createGraph(railRoads);
        for(Node temp : railMap.nodeSet()){
            System.out.println(temp.city);
        }
        System.out.println("Done");
        printGraph(railMap);
    }
    public static Graph createGraph(String[][] grid){
        Graph railMap = new Graph();
        for(int i = 0 ; i < grid.length ; i++){
            railMap.addNode(grid[i][0]);
            railMap.addNode(grid[i][1]);
            railMap.addEdge(grid[i][0],grid[i][1]);
        }
        return railMap;
    }
    public static void printGraph(Graph graph){
        Set<Node> nodes = new HashSet<>();
        nodes = graph.nodeSet();
        Iterator<Node> itr = nodes.iterator();
        while(itr.hasNext()){
            Node temp = itr.next();
            System.out.println(temp.city);
            Set<Node> neighbors = temp.getNeighbors();
            for(int i = 0 ; i < neighbors.size() ; i++) {
                System.out.println(neighbors.stream().toArray());
            }
        }
    }
    public static boolean canTravel(String[][] railroads,String origin, String destination){
        if(railroads == null)
            return false;
        Graph railWays = new Graph();
        createGraph(railroads);
        return true;
    }
}
