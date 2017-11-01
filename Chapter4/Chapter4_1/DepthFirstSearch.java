package Chapter4_1;

import edu.princeton.cs.algs4.In;

//进行深度优先遍历
public class DepthFirstSearch {
	//记录节点的状态，如果被访问了就是1
	private boolean [] marked;
	//记录跟此节点联通的个数
	private int count;
	
	//构造函数
	
	public DepthFirstSearch(Graph G, int S) 
	{
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		dfs(G, S);
	}
	
	//搜寻函数
	private void dfs(Graph G, int s)
	{
		marked[s] = true;
		count++;
		for (int w: G.adj(s)) 
		{
			if(!marked[w])
			{
				dfs(G, w);
			}
		}
	}
	public int count()
	{
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\code\\java_code\\algs4Data\\algs4-data\\tinyG.txt";
		Graph graph = new Graph(new In(path));
		DepthFirstSearch dfs = new DepthFirstSearch(graph, 7);
		System.out.println(dfs.count());

	}

}
