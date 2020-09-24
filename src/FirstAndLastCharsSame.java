import java.util.ArrayList;
import java.util.List;

public class FirstAndLastCharsSame {
    public static void main(String[] args){
        String x = "aabb";
        int count = 0;
        List<String> result = shifting(x);
        for(int i = 0 ; i < result.size() ; i++){
            if(result.get(i).charAt(0) == result.get(i).charAt(result.get(i).length() - 1))
                count++;
        }
        System.out.println("Number of strings that has first and last chars same in all the left shifted strings is : "+count);
    }
    public static List<String> shifting(String x){
        String buff = x;
        List<String> temp = new ArrayList<>();
        x = x.substring(1,x.length())+x.charAt(0);
        temp.add(x);
        do{
            int i = 0;
            x = x.substring(i+1,x.length())+x.charAt(i);
            temp.add(x);
        }while(!x.equals(buff));
        System.out.println(temp);
        return temp;
    }
}
