package Chapter4_1;

import java.util.LinkedList;
import java.util.List;

import edu.princeton.cs.algs4.In;

//实现连通分量计算
public class CC {
	private boolean []marked;
	private int []id;
	private int count;
	//构造构造函数
	public CC(Graph g) {
			// TODO Auto-generated constructor stub
		marked = new boolean[g.V()];
		id = new int[g.V()];
		for(int i=0; i<g.V(); i++)
		{
			if(!marked[i])
			{
				dfs(g, i);
				count++;
			}
		}
	}
	
	private void dfs(Graph g, int s)
	{
		marked[s] = true;
		id[s] = count;
		for (int item :g.adj(s)) {
			if (!marked[item]) {
				dfs(g, item);
			}
		}
	}
	//判断两个点是否联通
	public boolean connected(int v, int w)
	{
		return id[v] == id[w];
		// TODO 完成判断两个节点是否联通
	}
	
	//返回联通
	public int count()
	{
		return count;
		// TODO 返回图中联通的个数
	}
	
	//返回v节点所在节点的位置
	public int id(int v)
	{
		return id[v];
	}
	//
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "D:\\code\\java_code\\algs4Data\\algs4-data\\tinyG.txt";
		Graph g = new Graph(new In(path));
		CC cc = new CC(g);
		int M = cc.count();
		System.out.println(M+" components");
		List<Integer> []components;
		components = (LinkedList<Integer>[]) new LinkedList[M];
		for (int i = 0; i < M; i++) {
			components[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < g.V(); i++) {
			components[cc.id(i)].add(i);
		}
		for (int i = 0; i < M; i++) {
			for(int v:components[i])
			{
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}

}
