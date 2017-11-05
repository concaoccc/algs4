package Chapter4_2;

import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import Chapter4_1.Graph;

import edu.princeton.cs.algs4.In;

//有向图
public class Digraph {
	//节点个数
	private int V;
	//边的个数
	private int E;
	//临接表
	List<Integer> []adj;
	
	//利用节点个数初始化邻接表
	public Digraph(int v) {
		// TODO Auto-generated constructor stub
		this.V =v;
		adj = (LinkedList<Integer>[]) new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	//利用输入流进行图的初始化
	public Digraph(In input)
	{
		this(input.readInt());
		int E = input.readInt();
		for (int i = 0; i < E; i++) {
			int p = input.readInt();
			int q = input.readInt();
			addEdge(p,q);
		}
		
	}
	
	//增加一条从v到w的边
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	
	//返回点的个数
	public int V()
	{
		return V;
	}
	
	//返回边的个数
	public int E()
	{
		return E;
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	public Digraph reverse()
	{
		Digraph R = new Digraph(V);
		for(int i =0 ; i<V; i++)
		{
			for (int  w: adj(i)) {
				R.addEdge(w, i);
			}
		}
		return R;
	}
	
	public String tostring()
	{
		String result ="";
		result += V+" 顶点 "+E+" 边 \n";
		for (int i = 0; i < V; i++) {
			for (int  w: adj(i)) {
				result += (i+"-"+w+"\n");
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\code\\java_code\\algs4-data\\tinyDG.txt";
		Digraph graph = new Digraph(new In(path));
		System.out.println(graph.tostring());
	}

}
