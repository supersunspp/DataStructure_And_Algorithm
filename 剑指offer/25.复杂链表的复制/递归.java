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
        
        RandomListNode newNode = new RandomListNode(pHead.label);
        
        newNode.random = pHead.random;
        newNode.next = Clone(pHead.next);
        
        return newNode;
    }
}