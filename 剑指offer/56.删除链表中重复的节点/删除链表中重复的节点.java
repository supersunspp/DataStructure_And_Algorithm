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
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode first = new ListNode(-1);
        first.next     = pHead;
        ListNode p     = pHead;
        ListNode last  = first;
        
        while(p!=null && p.next!=null)
        {
            if(p.val==p.next.val)
            {
                int val = p.val;
                while(p!=null && p.val==val)
                    p = p.next;
                
                last.next = p;
            }
            else
            {
                last = p;
                p    = p.next;
            }
        }
        
        return first.next;
    }
}