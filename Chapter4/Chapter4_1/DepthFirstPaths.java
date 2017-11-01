package Chapter4_1;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;


public class DepthFirstPaths {
	//���ô˽���DFS����
	private boolean [] marked;
	//��¼���λ��
	private final int s;
	//��¼�ýڵ����һ���ڵ�
	private int []edgeTo;
	
	//���캯��
	//����Ϊһ��ͼ�����λ��
	public DepthFirstPaths(Graph g,int s) {
		// TODO Auto-generated constructor stub
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}
	
	//dfs�㷨����ͼ������ȱ���
	private void dfs(Graph g, int s)
	{
		marked[s] = true;
		for (int w: g.adj(s)) {
			//d
			if (!marked[w]) {
				edgeTo[w] = s;
				dfs(g, w);
			}
		}
	}
	
	//����������û�е���v�ڵ��·��
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	
	//���ؾ����·��
	//����ΪҪ����ĵ�
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
		DepthFirstPaths search = new DepthFirstPaths(graph, s);
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
