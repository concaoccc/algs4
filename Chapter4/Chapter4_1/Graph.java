package Chapter4_1;


import java.lang.Integer;
import java.util.LinkedList;
import java.util.List;


import edu.princeton.cs.algs4.In;
//����ͼ�Ķ���
public class Graph {
	//ͼ��ͼ�нڵ�ĸ���
	private int V;
	//����ͼ�бߵĸ���
	private int E;
	//����ͼ�е��ڽӱ�
	private List<Integer> []adj;
	//����һ����V���ڵ������ͼ
	public Graph(int V) {
		// TODO Auto-generated constructor stub
		this.V = V;
		adj = (LinkedList<Integer>[]) new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	//���ö���Ľ���ͼ�ĳ�ʼ��
	public Graph(In in)
	{
		//��ȡ���������������һ���������г�ʼ��
		this(in.readInt());
		int E = in.readInt();
		for (int i = 0; i < E; i++) 
		{
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}
	
	//���ض������
	public int V()
	{
		return this.V;
	}
	//���رߵĸ���
	public int E()
	{
		return this.E;
	}
	//����һ����
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	//����ͼ���ڽӱ�
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	//��ͼ��ӡ����
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
	
	//����ͼ��ĳ������Ķ���
	public static int degree(Graph G, int V)
	{
		int degree =0;
		for (@SuppressWarnings("unused") int w: G.adj(V))
		{
			degree++;
		}
		return degree;
	}
	
	//�������ж����������
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
	
	//�������ж����ƽ����
	public static double avgDegree(Graph G)
	{
		return 2.0*G.E()/G.V();
	}
	
	//�����Ի���Ŀ
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
		//��ͼ�ĳ�ʼ�����в���
		String path = "D:\\code\\java_code\\algs4Data\\algs4-data\\tinyG.txt";
		Graph graph = new Graph(new In(path));
		System.out.println(maxDegree(graph));
		System.out.println(graph.toString());
	}

}
