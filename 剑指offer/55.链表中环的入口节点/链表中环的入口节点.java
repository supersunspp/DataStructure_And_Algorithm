/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null & fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow)
                break;
        }
        
        if(fast==null || fast.next==null)
            return null;
        
        fast = pHead;
        while(fast!=slow)
        {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}