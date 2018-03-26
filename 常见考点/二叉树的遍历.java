import java.util.Stack;
import java.util.LinkedList;

public class preTraver {
	public static void main(String[] args)
	{
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(7);
		TreeNode node6 = new TreeNode(8);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(10);
		TreeNode node9 = new TreeNode(11);
		node1.left  = node2;
		node1.right = node3;
		node2.left  = node4;
		node2.right = node5;
		node3.left  = node6;
		node3.right = node7;
		node4.right = node8;
		node6.left  = node9;
		
		//pre0(node1);
		//pre1(node1);
		//mid0(node1);
		//mid1(node1);
		//aft0(node1);
		//aft1(node1);
		leve0(node1);
	}
	
	//前序遍历递归版本
	public static void pre0(TreeNode head)
	{
		if(head==null)
			return;
		
		System.out.print(head.val);
		
		if(head.left!=null)
			pre0(head.left);
		if(head.right!=null)
			pre0(head.right);
	}
	
	//前序遍历非递归版本
	public static void pre1(TreeNode root)
	{
		if(root==null)
			return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty())
		{
		    TreeNode node = stack.pop();
		    System.out.println(node.val);
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}
	
	//中序遍历递归版本
	public static void mid0(TreeNode root)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
			mid0(root.left);
		System.out.println(root.val);
		if(root.right!=null)
			mid0(root.right);
	}
	
	//中序遍历非递归版本
	public static void mid1(TreeNode root)
	{
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root!=null || !stack.isEmpty())
		{
			while(root!=null)
			{
				stack.push(root);
				root = root.left;
			}
			
			if(!stack.isEmpty())
			{
				root = stack.pop();
				System.out.println(root.val);
				root = root.right;
			}
		}
	}
	
	//后序遍历递归版
	public static void aft0(TreeNode root)
	{
		if(root==null)
			return;
		
		if(root.left!=null)
			aft0(root.left);
		if(root.right!=null)
			aft0(root.right);
		
		System.out.println(root.val);
	}
	
	//后续遍历非递归版
	//后序遍历的难点在于判断上次访问的节点是位于左子树还是右子树
	//若是位于左子树，需要跳过根节点访问右子树
	//若是右子树，则直接访问根节点
	public static void aft1(TreeNode root)
	{
		if(root==null)
			return;
		
		TreeNode currNode = root;
		TreeNode lastNode = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while(currNode!=null)
		{
			stack.push(currNode);
			currNode = currNode.left;
		}
		
		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();
			if(node.right!=null && lastNode!=node.right)
			{
				stack.push(node);
				currNode = node.right;
				while(currNode!=null)
				{
					stack.push(currNode);
					currNode = currNode.left;
				}
			}
			else
			{
				System.out.println(node.val);
				lastNode = node;
			}
		}
	}
	
	//层次遍历非递归递归版本
	public static void leve0(TreeNode root)
	{
		if(root==null)
			return;
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.addLast(root);
		while(queue.size()!=0)
		{
			TreeNode node = queue.pollFirst();
			System.out.println(node.val);
			if(node.left!=null)
				queue.addLast(node.left);
			if(node.right!=null)
				queue.addLast(node.right);
		}
	}
}

 class TreeNode{
	 int val        = 0;
	 TreeNode left  = null;
	 TreeNode right = null;
	 
	 public TreeNode(int val)
	 {
		 this.val = val;
	 }
 }