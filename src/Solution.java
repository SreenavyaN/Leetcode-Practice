import java.util.List;

/**
 * Definition for singly-linked list.
 * */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode() {

    }
}
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null)
        return null;
        ListNode currl1 = l1;
        ListNode currl2 = l2;
        ListNode l3 = null;
//        ListNode currl3 = l3;
        int l1_val = 0;
        int l2_val = 0;
        int carry = 0;
    while ((currl1 != null && currl1.next !=null ) || (currl2 != null && currl2.next != null))
    {
        if(currl1 != null )
        {
           l1_val = currl1.val;
        }
        else
            l1_val = 0;
        if(currl2 != null )
        {
            l2_val = currl2.val;
        }
        else
            l2_val = 0;
        ListNode currl3 = new ListNode(0);
        int temp = l1_val+l2_val+carry;
        carry=0;
        if(temp > 9)
        {
            currl3.val = temp%10;
            carry = temp/10;
        }
        else
            currl3.val = temp;
        currl1 = currl1.next;
        currl2 = currl2.next;
        l3 = add(l3,currl3);
    }
    return l3;
    }
    public ListNode add(ListNode ll, ListNode lastNode)
    {
        ListNode l4;
        if (ll == null)
        {
         ll = lastNode;
         return ll;
        }
        l4 = ll;
        while (ll.next != null)
        {
            ll = ll.next;
        }
        ll.next = lastNode;
        return l4;

    }
}