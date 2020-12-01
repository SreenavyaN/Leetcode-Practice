public class StackWithLinkedList {
    public static class Node {
        int val;
        Node next;
        Node() {
        }
        public Node(int value) {
            this.val = value;
        }
    }
    public static class Stack {
        Node top = null;
        public Stack(){}
        boolean isEmpty(){
            if(top() == null)
                return true;
            else
                return false;
        }
        void push(int val) {
            Node newNode = new Node(val);
            if (isEmpty( )) {
                newNode.next = null;
            }
            else{
                newNode.next = top;
            }
            top = newNode;
        }
        void pop(){
            if(!isEmpty())
                top = top.next;
            else
                System.out.println("Pop operation on an Empty Stack");
        }
        Node top(){
                return top;
        }
        void Display(Node head){
            Node temp = new Node();
            temp = head;
            while(temp.next != null){
                System.out.println(temp.val);
                temp = temp.next;
            }
            System.out.println(temp.val);
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        Stack stk = new Stack();
        for(int i = 0; i < arr.length ; i++) {
            stk.push(arr[i]);
        }
        stk.Display(stk.top());
        System.out.println("End");
        stk.pop();
        stk.Display(stk.top());
    }
}
