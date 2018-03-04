import java.util.ArrayList;
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
public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        if(root==null)
        {
            return list;
        }
        
        queue.add(root);
        while(queue.size()!=0)
        {
            TreeNode tmp = queue.remove(0);
            if(tmp.left!=null)
            {
                queue.add(tmp.left);
            }
            if(tmp.right!=null)
            {
                queue.add(tmp.right);
            }
            list.add(tmp.val);
        }
        
        return list;
    }
}