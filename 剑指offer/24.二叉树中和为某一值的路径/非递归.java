import java.util.ArrayList;
import java.util.Stack;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Stack<TreeNode> stack                 = new Stack<TreeNode>();
        ArrayList<Integer> list               = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
        
        while(root!=null || !stack.empty())
        {
            while(root!=null)
            {
                stack.push(root);
                list.add(root.val);
                target -= root.val;
                if(root.left!=null)
                {
                    root = root.left;
                }
                else
                {
                    root = root.right;
                }
            }
            root = stack.peek();
            if(target==0 && root.left==null && root.right==null)
            {
                listAll.add(new ArrayList<Integer>(list));
            }
            stack.pop();
            list.remove(list.size()-1);
            target += root.val;
            if(!stack.empty() && stack.peek().left==root)
            {
                root = stack.peek().right;
            }
            else
            {
                root = null;
            }
        }
        
        return listAll;
    }
}