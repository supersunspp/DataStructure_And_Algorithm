import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
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
public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(pRoot==null)
            return ret;
        
        ArrayList<Integer> list    = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);
        queue.addLast(pRoot);
        boolean leftToRight = true;
        
        while(queue.size()!=1)
        {
            TreeNode node = queue.removeFirst();
            if(node==null)
            {
                Iterator<TreeNode> iter = null;
                if(leftToRight)
                {
                    iter = queue.iterator();
                }
                else
                {
                    iter = queue.descendingIterator();
                }
                leftToRight = !leftToRight;
                while(iter.hasNext())
                {
                    TreeNode temp = (TreeNode)iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);
                continue;
            }
            if(node.left!=null)
                queue.addLast(node.left);
            if(node.right!=null)
                queue.addLast(node.right);
        }
        
        return ret;
    }

}                                            