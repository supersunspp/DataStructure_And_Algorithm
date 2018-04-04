
public class 有向图 {
	char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
	char[][] edges = new char[][]{
        {'A', 'B'}, 
        {'B', 'C'}, 
        {'B', 'E'}, 
        {'B', 'F'}, 
        {'C', 'E'}, 
        {'D', 'C'}, 
        {'E', 'B'}, 
        {'E', 'D'}, 
        {'F', 'G'}}; 
    
    ListDG pG;
    pG = new ListDG(vexs, edges);
    
    pG.print();
}

class ListDG{
	private class ENode{
		int   ivex;
		ENode nextEdge;
	}
	
	private class VNode{
		char  data;
		ENode firstEdge;
	}
	
	private VNode[] mVexs;
	
	private int getPosition(char ch) {
		for(int i=0; i<mVexs.length; i++)
		{
			if(mVexs[i].data==ch)
				return i;
		}
		
		return -1;
	}
	
	private void linkLast(ENode list, ENode node)
	{
		ENode p = list;
		
		while(p.nextEdge!=null)
			p = p.nextEdge;
		
		p.nextEdge = node;
	}
	
	public ListDG(char[] vexs, char[][] edges)
	{
		int vlen = vexs.length;
		int elen = edges.length;
		
		mVexs    = new VNode[vlen];
		for(int i=0; i<mVexs.length; i++)
		{
			mVexs[i]           = new VNode();
			mVexs[i].data      = vexs[i];
			mVexs[i].firstEdge = null;
		}
		
		for(int i=0; i<elen; i++)
		{
			char c1 = edges[i][0];
			char c2 = edges[i][1];
			
			int p1  = getPosition(edges[i][0]);
			int p2  = getPosition(edges[i][1]);
			
			ENode node1 = new ENode();
			node1.ivex  = p2;
			if(mVexs[p1].firstEdge==null)
				mVexs[p1].firstEdge = node1;
			else
				linkLast(mVexs[p1].firstEdge, node1);
		}
	}
	
	public void print() {
		System.out.println("List Graph:\n");
		for(int i=0; i<mVexs.length; i++)
		{
			System.out.printf("%d(%c):", i, mVexs[i].data);
			ENode node = mVexs[i].firstEdge;
			while(node!=null)
			{
				System.out.printf("%d(%c) ", node.ivex, mVexs[node.ivex].data);
				node = node.nextEdge;
			}
			
			System.out.printf("\n");
		}
	}
}