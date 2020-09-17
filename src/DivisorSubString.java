import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DivisorSubString {
    public static void main(String[] args){
        int n = 555;
        int k = 1;
        int res = divisorSubstrings(n,k);
        System.out.println(res);
    }
    public static int divisorSubstrings(int n, int k) {
        int count = 0;
        String str = Integer.toString(n);
        System.out.println(str);
        Set<Integer> l = new HashSet<>();
        for(int i = 0 ; i+k-1 < str.length() ; i++){

            l.add(Integer.parseInt(str.substring(i, i+k)));
        }
        Iterator itr = l.iterator();
        while(itr.hasNext()) {
            int temp = (int) itr.next();
            if (n % temp == 0)
                count++;
        }
        return count;
    }

}
