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
import java.util.*;
public class Solution {
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if(node!=null)
            {
                queue.offer(node.left);
                queue.offer(node.right);
                sb.append(node.val+",");
            }
            else
            {
                sb.append("#" + ",");
            }
        }
        if(sb.length()!=0)
            sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
  }
    TreeNode Deserialize(String str) {
        TreeNode head = null;
        if(str==null || str.length()==0)
            return head;
        String[] nodes = str.split(",");
        TreeNode[] treenodes = new TreeNode[nodes.length];
        for(int i=0; i<nodes.length; i++)
        {
            if(!nodes[i].equals("#"))
                treenodes[i] = new TreeNode(Integer.valueOf(nodes[i]));
        }
        
        for(int i=0, j=1; j<treenodes.length; i++)
        {
            if(treenodes[i]!=null)
            {
                treenodes[i].left  = treenodes[j++];
                treenodes[i].right = treenodes[j++];
            }
        }
        
        return treenodes[0];
  }
}