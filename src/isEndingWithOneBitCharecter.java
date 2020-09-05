public class isEndingWithOneBitCharecter {
    public static class Stack{
        int size=0;
        int[] temp = new int[10];
        //int top = temp[size];
        Stack(){}
        public int size(){
            return size;
        }
        public int top(){
            return temp[size];
        }
        public void push(int val){
            size++;
            temp[size] = val;
        }
        public void pop(){
            size--;
        }
        public boolean isEmpty(){
            if(size == 0)
                return true;
            return false;
        }
    }
    public static void main(String[] args){
        int[] bits = {1,1,1,0};
        System.out.println("Ends with one bit  char : "+isOneBitCharecter(bits));
    }
    public static boolean isOneBitCharecter(int[] bits){
        if(bits.length == 0)
            return false;
        Stack temp = new Stack();

        for(int i = 1 ; i < bits.length ; i++) {
            temp.push(bits[i]);
            System.out.println("pushed " + bits[i]);
                System.out.println("got " + bits[i]);
                System.out.println("top " + temp.top( ));
                if ((bits[i] == 1 || bits[i] == 0) && temp.top( ) == 1) {
                    System.out.println("popping " + temp.top( ));
                    temp.pop( );

            }
                temp.push(bits[i]);
                System.out.println("pushing else if "+bits[i]);
        }
        if (temp.isEmpty())
           return false;
        return true;
        }
}
