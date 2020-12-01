import java.util.ArrayList;
import java.util.List;

public class JsonTOCSV {
    public static void main (String[] args){
        List<Integer> lst = new ArrayList<>();
        int[] arr = {1,2,3,4,5};
        for(int k = 0 ; k < arr.length ; k++){
            lst.add(arr[k]);
        }
        for (int i = 0 ; i < lst.size() ; i++){
            System.out.println(" for Elem : "+lst.get(i));
        }
        int j = 0;
        while( j < lst.size()){
            System.out.println(" While Elem : "+lst.get(j));
            j++;
        }
        for(int i : lst){
            System.out.println(" for Elem : "+i);
        }
    }
}
