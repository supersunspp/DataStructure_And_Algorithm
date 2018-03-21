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
    protected TreeNode leftLast = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
        {
            return null;
        }
        
        if(pRootOfTree.left==null && pRootOfTree.right==null)
        {
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        
        TreeNode left = Convert(pRootOfTree.left);
        if(left!=null)
        {
            leftLast.right    = pRootOfTree;
            pRootOfTree.left  = leftLast;
        }
        leftLast = pRootOfTree;
        
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null)
        {
            right.left        = pRootOfTree;
            pRootOfTree.right = right;
        }
        return left!=null?left:pRootOfTree;     
    }
}