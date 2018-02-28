/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        ListNode pNode = listNode;
        if(pNode!=null)
        {
            if(pNode.next!=null)
            {
                list = printListFromTailToHead(pNode.next);
            }
            list.add(pNode.val);
        }
        
        return list;
    }
}