package Chapter4_1;

import edu.princeton.cs.algs4.In;

//����������ȱ���
public class DepthFirstSearch {
	//��¼�ڵ��״̬������������˾���1
	private boolean [] marked;
	//��¼���˽ڵ���ͨ�ĸ���
	private int count;
	
	//���캯��
	
	public DepthFirstSearch(Graph G, int S) 
	{
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		dfs(G, S);
	}
	
	//��Ѱ����
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
