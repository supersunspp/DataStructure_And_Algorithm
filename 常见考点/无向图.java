import java.util.LinkedList;

public class 有向无环图的最短路径 {
	public static void main(String[] args)
	{
		char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		char[][] edges = new char[][] {
			{'A', 'C'},
			{'A', 'D'},
			{'A', 'F'},
			{'B', 'C'},
			{'C', 'D'},
			{'E', 'G'},
			{'F', 'G'}};
			
		ListUDG pG;
		pG = new ListUDG(vexs, edges);
		//pG.DFS();
		pG.BFS();
	}
}

class ListUDG{
	//邻接表中对应链表的顶点
	private class ENode{
		int   ivex;  //该边所指向顶点的位置
		ENode nextEdge; //指向下一条弧的指针
	}
	
	//邻接表中表的顶点
	private class VNode{
		char  data;  //顶点信息
		ENode firstEdge;  //指向第一条依附该顶点的弧
	}
	
	//顶点数组
	private VNode[] mVexs;
	private void linkLast(ENode list, ENode node)
	{
		ENode p = list;
		while(p.nextEdge!=null)
			p = p.nextEdge;
		
		p.nextEdge = node;
	}
	
	private int getPosition(char ch)
	{
		for(int i=0; i<mVexs.length; i++)
			if(mVexs[i].data==ch)
				return i;
		
		return -1;
	}
	
	public ListUDG(char[] vexs, char[][] edges)
	{
		int vlen = vexs.length;
		int elen = edges.length;
		
		//初始化“顶点”
		mVexs    = new VNode[vlen];
		for(int i=0; i<mVexs.length; i++)
		{
			mVexs[i]           = new VNode();
			mVexs[i].data      = vexs[i];
			mVexs[i].firstEdge = null;
		}
		
		//初始化“边”
		for(int i=0; i<elen; i++)
		{
			char c1 = edges[i][0];
			char c2 = edges[i][1];
			
			int p1  = getPosition(edges[i][0]);
			int p2  = getPosition(edges[i][1]);
			//System.out.print(p1);
			//System.out.print(p2);
			
			ENode node1 = new ENode();
			node1.ivex  = p2;
			
			if(mVexs[p1].firstEdge==null)
				mVexs[p1].firstEdge = node1;
			else
				linkLast(mVexs[p1].firstEdge, node1);
			
			ENode node2 = new ENode();
			node2.ivex  = p1;
			if(mVexs[p2].firstEdge==null)
				mVexs[p2].firstEdge = node2;
			else
				linkLast(mVexs[p2].firstEdge, node2);
		}
	}
	
	public void print()
	{
		System.out.println("List Graph:\n");
		for(int i=0; i<mVexs.length; i++)
		{
			System.out.printf("%d(%c):", i, mVexs[i].data);
			ENode node = mVexs[i].firstEdge;
			while(node!=null)
			{
				System.out.printf("%d(%c):", node.ivex, mVexs[node.ivex].data);
				node = node.nextEdge;
			}
			
			System.out.printf("\n");
		}
	}
	
	//深度优先遍历
	public void DFS()
	{
		boolean[] marked = new boolean[mVexs.length];
		for(int i=0; i<marked.length; i++)
			marked[i] = false;
		
		DFSHelper(marked, mVexs[0]);
	}
	
	public void DFSHelper(boolean[] marked, VNode node)
	{
		int pos     = getPosition(node.data);
		marked[pos] = true;
		//System.out.println(node.data);
		boolean res = isTraverAll(marked);
		if(res)
			return;
		ENode node1 = node.firstEdge;
		while(node1!=null)
		{
			if(marked[node1.ivex]==false)
				DFSHelper(marked, mVexs[node1.ivex]);
			
			node1 = node1.nextEdge;
		}
	}
	
	public boolean isTraverAll(boolean[] marked)
	{
		for(int i=0; i<marked.length; i++)
			if(marked[i]==false)
				return false;
		
		return true;
	}
	
	//广度优先遍历
	public void BFS()
	{
		boolean[] marked = new boolean[mVexs.length];
		for(int i=0; i<marked.length; i++)
		{
			marked[i] = false;
		}
		
		BFSHelper(marked, mVexs[0]);
	}
	
	public void BFSHelper(boolean[] marked, VNode node)
	{
		LinkedList<VNode> queue = new LinkedList<VNode>();
		queue.addLast(node);
		int pos;
		while(queue.size()!=0)
		{
			VNode tmp   = queue.pollFirst();
			marked[getPosition(tmp.data)] = true;
			System.out.println(tmp.data);
			ENode edge  = tmp.firstEdge;
			while(edge!=null)
			{
				if(marked[getPosition(mVexs[edge.ivex].data)]==false)
				{
					queue.addLast(mVexs[edge.ivex]);
					pos = getPosition(mVexs[edge.ivex].data);
					marked[pos] = true;
				}
				edge = edge.nextEdge;
			}
		}
	}
}
