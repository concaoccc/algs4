package Chapter4_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

//��������������ͼ�нڵ�ĵ���˳��
public class DepthFirstOrder {
	private boolean[] marked;
	private Queue<Integer> pre;//����ǰ�����
	private Queue<Integer> post;//�����������
	private Stack<Integer> reversePost;//�������������
	public DepthFirstOrder(Digraph g) {
		// TODO Auto-generated constructor stub
		marked = new boolean[g.V()];
		pre = new Queue<>();
		post = new Queue<>();
		reversePost = new Stack<>();
		for (int i = 0; i < g.V(); i++) {
			if (!marked[i]) {
				dfs(g, i);
			}
		}
	}
	
	private void dfs(Digraph g, int s)
	{
		marked[s] = true;
		pre.enqueue(s);
		for(int w: g.adj(s))
		{
			if(!marked[w])
			{
				dfs(g, w);
			}
		}
		post.enqueue(s);
		reversePost.push(s);
	}
	
	public Iterable<Integer> pre()
	{
		return pre;
	}
	
	public Iterable<Integer> post()
	{
		return post;
	}
	
	public Iterable<Integer> reversePost()
	{
		return reversePost();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
