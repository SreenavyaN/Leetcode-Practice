public class QueueWithLinkedList {
    public static class Node{
        int val;
        Node next;
        Node(){ }
        Node(int value){this.val = value; this.next = null;}
    }
    public static class Queue{
        Node first;
        Node last;
        Queue(){}
        Node getFirst(){ return first; }
        Node getLast(){ return last; }
        void enQueue(int val){
            Node newNode = new Node(val);
            if(isEmpty()){
                first = newNode;
                first.next = null;
                last = first;
            }
            else{
                last.next = newNode;
            }
        }
        void deQueue(){
            if(isEmpty()){
                System.out.println("deQueue on empty queue");

            }
            else
                first = first.next;
        }
        boolean isEmpty(){
            if(first == null)
                return true;
            else
                return false;
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
        Queue q = new Queue();
        for( int i = 0 ; i < arr.length ; i++ ){
            q.enQueue(arr[i]);
        }
        q.Display(q.getFirst());
        q.deQueue();
        System.out.println("After deQueueing");
        q.Display(q.getFirst());
    }
}
