/**
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
    public void Mirror(TreeNode root) {
        if(root==null)
        {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            if(node.left!=null || node.right!=null)
            {
                TreeNode tmp = node.left;
                node.left    = node.right;
                node.right   = tmp;
            }
            if(node.left!=null)
            {
                stack.push(node.left);
            }
            if(node.right!=null)
            {
                stack.push(node.right);
            }
        }
    }
}