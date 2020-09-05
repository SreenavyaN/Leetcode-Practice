public class lastWordLength {
    public static void main(String args[]){
        String s = "sree navya N   ";
        System.out.println("Last word length is :"+lastWord(s));
    }
    public static int lastWord(String s){
        if(s.length() == 0)
            return 0;
        int len = 0,cnt = 0,result = 0;
        for(int i = 0 ; i < s.length() ; i++) {

            if (s.charAt(i) != ' ')
                cnt++;
            else if (s.charAt(i) == ' ') {
                if(cnt != 0) {
                    len = cnt;
                    result = len;
                }
                cnt = 0;
            }
        }
            if ( s.charAt(s.length() - 1) == ' ')
                return result;
            else
                return cnt;
    }
}
