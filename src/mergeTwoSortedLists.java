import java.util.LinkedList;

public class mergeTwoSortedLists{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode createList(int[] arr){
        ListNode head = null;
        ListNode temp2 = null;
        ListNode temp1;
        for(int i = 0 ; i < arr.length ; i++){
            temp1= new ListNode();
            temp1.val = arr[i];
            temp1.next = null;
            if (head == null){
                head = temp1;
                temp2 = head;
            }
            else
            {
                temp2.next = temp1;
                temp2 = temp1;
            }
        }
        return head;
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val);
            if(head.next != null)
                System.out.print("-->");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String args[]){
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        int[] arr1 = {1,2,3,4};
        int[] arr2 = {10,20,30};
        l1 = createList(arr1);
        l2 = createList(arr2);
        System.out.println("l1 : "+l1.val);
        System.out.println("l2 : "+l2.val);
        printList(l1);

        printList(l2);

        ListNode result = mergeSortedLists(l1,l2);
        printList(result);
    }
    public static ListNode mergeSortedLists(ListNode l1, ListNode l2)
    {
        ListNode l3 = null;
        if(l1 == null && l2 == null)
            return l1;
        else if(l1 == null)
            return l2;
        else if(l2 == null)
            return l1;
        else {

            ListNode temp1 = null;
            ListNode temp2 = null;
            do {
                if (l1.val <= l2.val) {
                    temp1 = new ListNode( );
                    temp1.val = l1.val;
                    l1 = l1.next;
                } else {
                    temp1 = new ListNode( );
                    temp1.val = l2.val;
                    l2 = l2.next;
                }
                temp1.next = null;
                if (l3 == null) {
                    l3 = temp1;
                    temp2 = l3;
                } else {
                    temp2.next = temp1;
                    temp2 = temp1;
                }
            }while(l1 != null && l2 != null);
            if(l1 != null)
                temp2.next = l1;
            if(l2 != null)
                temp2.next = l2;
        }
        return l3;
    }
}