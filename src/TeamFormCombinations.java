public class TeamFormCombinations {
    public static void main(String[] args){
        int f = 2;
        int b = 2;
        System.out.println("No of ways : "+formTeam(f,b,1,1,3));
    }
    public static int formTeam(int f,int b, int minF, int minB,int maxSize){
        int i = 1,sum = 0;
        while( i <= Math.min(f,b)){
            sum = sum + (ncr(f,i) * ncr(b,maxSize - i));
            i++;
        }
        return sum;
    }
    public static int ncr(int n , int r){
        int combs = 0;
        combs = fact(n) / (fact(r) * fact(n - r));
        return combs;
    }
    public static int fact(int n){
        int fact = 1;
        if(n < 2)
            return 1;
        for(int i = 0 ; i <= n ; i++){
            fact = fact(n-1) * i;
        }
        return fact;
    }
}
