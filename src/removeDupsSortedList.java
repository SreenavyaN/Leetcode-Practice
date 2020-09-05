public class removeDupsSortedList {
    public static class ListNode{
        int val;
        ListNode next = null;
        public ListNode(){        }
        public void addNode(ListNode head,int value){
            ListNode temp2 = new ListNode();
            temp2.val = value;
            temp2.next = null;
            ListNode temp = head;
            ListNode temp1 = temp;
            while(temp.next != null){
                temp1 = temp.next;
                temp = temp1;
            }
            temp1.next = temp2;
        }
    }
    public static void main(String args[]){
        ListNode withDups = new ListNode();
        withDups.val = 1;
        withDups.next = null;
        withDups.addNode(withDups,2);
        withDups.addNode(withDups,2);
        withDups.addNode(withDups,3);
       withDups.addNode(withDups,3);
       withDups.addNode(withDups,4);
       withDups.addNode(withDups,4);
       withDups.addNode(withDups,5);
        withDups.addNode(withDups,5);
        withDups.addNode(withDups,5);
        print(withDups);
        ListNode noDups = removeDuplicates(withDups);
        print(noDups);
    }
    public static ListNode removeDuplicates(ListNode withDups){
        if(withDups == null)
            return null;
        if(withDups.next == null)
            return withDups;
        ListNode head = withDups;
        ListNode temp1 = head;
        while(temp1.next != null){
            temp1 = temp1.next;
            if (withDups.val == temp1.val) {
                if (withDups == head) {
                    head.next = null;
                    head = temp1;
                } else {
                    while(temp1.next != null) {
                        if (withDups.val == temp1.val)
                            temp1 = temp1.next;
                        else {
                            //withDups.next = null;
                            withDups = temp1;
                            temp1 = temp1.next;
                        }
                        withDups.next = temp1;
                    }
                }
            }
            if(temp1.next == null && withDups.val == temp1.val){
                    withDups.next = null;
                }
            withDups = temp1;
        }
        return head;
    }
    public static void print(ListNode head){
        System.out.println();
        while(head != null){
            if(head.next == null) {
                System.out.print(head.val);
                break;
            }
            System.out.print(head.val);
            System.out.print("-->");
            head = head.next;

        }
    }
}
