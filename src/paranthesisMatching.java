import java.util.Scanner;
import java.util.Stack;

public class paranthesisMatching {
    public static class Stack{
        char[] arr = new char[10];
        int size = 0;
        public Stack(){
        }
        public int size(){
            return size;
        }
        public void push(char ch)
        {
            size++;
            arr[size] = ch;
        }
        public void pop(){
            size--;
        }
        public void clear(){
            size = 0;
        }
        public int peek() {
            return arr[size];
        }
        public boolean empty(){
            if (size == 0)
                return true;
            else
                return false;
        }
        public boolean equals(char ch){
           return true;
        }

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine( );
        System.out.println("Given string is : " + matchParentheses(str));
    }

    public static boolean matchParentheses(String str) {
        if (str.length( ) == 0)
            return true;
        else if (str.length( ) % 2 != 0)
            return false;
        else {
            Stack st = new Stack();
            for (int i = 0; i < str.length( ); i++) {
                char ch = str.charAt(i);
                if(st.empty())
                    st.push(ch);
                else if ((st.peek( ) == '(' && ch == ')') || (st.peek( ) =='[' && ch == ']') || (st.peek( ) =='{' && ch == '}')) {
                    st.pop( );
                }
            }
            return st.empty( );
        }
    }
}
