package Chapter4_2;

import java.util.LinkedList;
import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import Chapter4_1.Graph;

import edu.princeton.cs.algs4.In;

//����ͼ
public class Digraph {
	//�ڵ����
	private int V;
	//�ߵĸ���
	private int E;
	//�ٽӱ�
	List<Integer> []adj;
	
	//���ýڵ������ʼ���ڽӱ�
	public Digraph(int v) {
		// TODO Auto-generated constructor stub
		this.V =v;
		adj = (LinkedList<Integer>[]) new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	//��������������ͼ�ĳ�ʼ��
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
	
	//����һ����v��w�ı�
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		E++;
	}
	
	//���ص�ĸ���
	public int V()
	{
		return V;
	}
	
	//���رߵĸ���
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
		result += V+" ���� "+E+" �� \n";
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
