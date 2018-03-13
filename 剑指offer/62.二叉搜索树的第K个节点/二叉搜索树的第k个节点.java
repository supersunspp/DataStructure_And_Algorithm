/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
import java.util.Stack;
public class Solution {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null || k==0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count             = 0;
        TreeNode node         = pRoot;
        do{
            if(node!=null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                node = stack.pop();
                count++;
                if(count==k)
                    return node;
                node = node.right;
            }
        }while(node!=null || !stack.isEmpty());
        
        return null;
    }


}