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
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    boolean isSymmetrical(TreeNode pRoot)
    {
        inOrder(pRoot);
        inOrderReverse(pRoot);
        return sb1.toString().equals(sb2.toString());
    }
    
    private void inOrder(TreeNode pRoot)
    {
        if(pRoot==null)
        {
            sb1.append("#");
            return;
        }
        
        if(pRoot.left==null && pRoot.right==null)
        {
            sb1.append(pRoot.val);
            return;
        }
        
        inOrder(pRoot.left);
        sb1.append(pRoot.val);
        inOrder(pRoot.right);
    }
    
    private void inOrderReverse(TreeNode pRoot)
    {
        if(pRoot==null)
        {
            sb2.append("#");
            return;
        }
        
        if(pRoot.left==null && pRoot.right==null)
        {
            sb2.append(pRoot.val);
            return;
        }
        
        inOrderReverse(pRoot.right);
        sb2.append(pRoot.val);
        inOrderReverse(pRoot.left);
    }
}