public class FindJudgeGraphsCurated {
    public static class Node {
        int val = 0;
        int in = 0;
        int out = 0;
        Node() {}
    }
    public static class TrustMap{
        int size = 0;
        Node[] labels = new Node[999];
        TrustMap(){}
        public void add(int val){
            Node temp = new Node();
            temp.val = val;
            temp.in = 0;
            temp.out = 0;
            labels[size] = temp;
            size++;
        }
        public boolean contains(int val){
            for(int i = 0 ; i < size ; i++) {
                if (labels[i].val == val) return true;
            }
            return false;
        }
        public Node getNode(int val){
            for(int i = 0 ; i < size ; i++) {
                if (labels[i].val == val) return labels[i];
            }
            return null;
        }
        public int size(){return size;}
        public void printMap(){
            for(int i = 0 ; i < size ; i++) {
                System.out.println("Value is:" + labels[i].val + " with in : " + labels[i].in + " and out : " + labels[i].out);
            }

        }
    }
    public static void main(String[] args){
        int[][] trust = {{1,3},{2,3},{3,1}};
        int n = 3;
        System.out.println("Judge label is : "+findJudge(n,trust));
    }
    public static int findJudge(int N, int[][] trust) {
        TrustMap map = new TrustMap();
        for (int i = 0 ; i < trust.length; i++){
            int j = 0;
            if (!map.contains(trust[i][0])) {
                System.out.println("here"+trust[i][0]);
                map.add(trust[i][0]);
                map.getNode(trust[i][0]).out++;
                //map.printMap( );
            }
            else
                map.getNode(trust[i][0]).out++;

            if (!map.contains(trust[i][1])) {
                System.out.println("here"+trust[i][1]);
                map.add(trust[i][1]);
                map.getNode(trust[i][1]).in++;
            }
            else
                map.getNode(trust[i][1]).in++;
        }
        map.printMap( );
        for(int i = 0 ; i < map.size() ; i++){
            if(map.labels[i].out == 0 && map.labels[i].in == N - 1)
                return map.labels[i].val;
        }

        return -1;
    }
}
