package Chapter4_1;


import java.lang.Integer;
import java.util.LinkedList;
import java.util.List;


import edu.princeton.cs.algs4.In;
//无向图的定义
public class Graph {
	//图像图中节点的个数
	private int V;
	//无向图中边的个数
	private int E;
	//无向图中的邻接表
	private List<Integer> []adj;
	//创建一个有V个节点的无向图
	public Graph(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	//利用读入的进行图的初始化
	public Graph(In in)
	{
		//读取顶点个数并调用另一个函数进行初始化
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) 
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	//返回顶点个数
	public int V()
	{
		return this.V;
	}
	//返回边的个数
	public int E()
	{
		return this.E;
	}
	//增加一条边
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	//返回图的邻接表
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//将图打印出来
	public String toString()
	{
		String string = V+" vertices,"+E+" edges\n";
		for(int i =0; i<V; i++)
		{
			string += i+" : ";
			for (Object w:this.adj(i))
			{
				 string += w+" ";
			}
			string += "\n";
		}
		return string;
	}
	
	//计算图中某个顶点的度数
	public static int degree(Graph G, int V)
	{
		int degree =0;
		for (@SuppressWarnings("unused") int w: G.adj(V))
		{
			degree++;
		}
		return degree;
	}
	
	//计算所有顶点的最大度数
	public static int maxDegree(Graph G)
	{
		int max =0;
		for (int i = 0; i < G.V(); i++) {
			int tmp = degree(G, i);
			if (tmp>max) {
				max = tmp;
			}
		}
		return max;
	}
	
	//计算所有顶点的平均数
	public static double avgDegree(Graph G)
	{
		return 2.0*G.E()/G.V();
	}
	
	//计算自环数目
	public static int numberOfSelfLoops(Graph G)
	{
		int count =0;
		for (int i = 0; i < G.V(); i++) {
			for(int w : G.adj(i))
			{
				if (w==i) {
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		//对图的初始化进行测试
		String path = "D:\\code\\java_code\\algs4Data\\algs4-data\\tinyG.txt";
		Graph graph = new Graph(new In(path));
		System.out.println(maxDegree(graph));
		System.out.println(graph.toString());
	}

}
