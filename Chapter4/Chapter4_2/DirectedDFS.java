package Chapter4_2;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

//完成有向图的深度遍历
public class DirectedDFS {
	private boolean []marked;
	//寻找所有从s点出发能到达的点
	public DirectedDFS(Digraph G, int s) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		dfs(G, s);
	}
	
	//寻找所有从集合source出发能到达的点
	public DirectedDFS(Digraph G, Iterable<Integer> source) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		for (int i : source) {
			dfs(G, i);
		}
	}
	
	
	private void dfs(Digraph G, int s)
	{
		marked[s] = true;
		for (int w: G.adj(s)) {
			if(!marked(w))
			{
				dfs(G, w);
			}
		}
	}
	public boolean marked(int v)
	{
		return marked[v];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\code\\java_code\\algs4-data\\tinyDG.txt";
		Digraph graph = new Digraph(new In(path));
		List<Integer> sources = new LinkedList<>();
		sources.add(1);
		sources.add(2);
		sources.add(6);
		DirectedDFS Ddfs = new DirectedDFS(graph,sources);
		for (int i = 0; i < graph.V(); i++) {
			if(Ddfs.marked[i])
			{
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

}
