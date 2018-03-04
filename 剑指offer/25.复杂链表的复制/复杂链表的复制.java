/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null)
        {
            return null;
        }
        RandomListNode currNode = pHead;
        while(currNode!=null)
        {
            RandomListNode node = new RandomListNode(currNode.label);
            node.next           = currNode.next;
            currNode.next       = node;
            currNode            = node.next;
        }
        currNode = pHead;
        while(currNode!=null)
        {
            RandomListNode node = currNode.next;
            if(currNode.random!=null)
            {
                node.random = currNode.random.next;
            }
            currNode = node.next;
        }
        
        RandomListNode pCloneHead = pHead.next;
        RandomListNode tmp;
        currNode = pHead;
        while(currNode.next!=null)
        {
            tmp           = currNode.next;
            currNode.next = tmp.next;
            currNode      = tmp;
        }
        
        return pCloneHead;
    }
}