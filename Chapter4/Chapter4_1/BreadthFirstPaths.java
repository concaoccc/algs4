package Chapter4_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths {
	//利用此进行DFS调用
	private boolean [] marked;
	//记录起点位置
	private final int s;
	//记录该节点的上一个节点
	private int []edgeTo;
	
	//构造函数
	//参数为一个图，起点位置
	public BreadthFirstPaths(Graph g,int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		bfs(g, s);
	}
	
	//bfs算法，对图进行广度遍历
	private void bfs(Graph g, int s)
	{
		//首先初始化一个队列进行节点存储
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int tmp = queue.dequeue();
			for(int Item : g.adj(tmp))
			{
				if(!marked[Item])
				{
					queue.enqueue(Item);
					marked[Item] = true;
					edgeTo[Item] = tmp;
				}
			}
			
		}
	}
	
	//从起点出发有没有到达v节点的路径
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//返回具体的路径
	//参数为要到达的点
	public Iterable<Integer> pathTo(int v)
	{
		if(!hasPathTo(v))
		{
			return null;
		}
		Stack<Integer> path = new Stack<Integer>();
//		while( v != s)
//		{
//			path.push(v);
//			v = edgeTo[v];
//		}
		for(int x =v; x!=s; x = edgeTo[x])
		{
			path.push(x);
		}
		path.push(s);
		return path;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\code\\java_code\\algs4Data\\algs4-data\\tinyCG.txt";
		Graph graph = new Graph(new In(path));
		int s = 0;
		BreadthFirstPaths search = new BreadthFirstPaths(graph, s);
		for (int v = 0; v < graph.V(); v++) {
			System.out.print(s+" to "+v+": ");
			for (int x: search.pathTo(v)) {
				if(s==x)
				{
					System.out.print(x);
				}
				else {
					System.out.print("-"+x);
				}
			}
			System.out.println();
	}
}
}
