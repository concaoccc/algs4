package Chapter1_5;

import java.nio.file.Path;

import edu.princeton.cs.algs4.In;


public class UF {
	//保存该节点所在的连接
	private int []id;
	//节点的个数
	private int count;
	//初始化一个有n个节点的
	public UF(int n) {
		// TODO Auto-generated constructor stub
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] =i;
		}
	}
	
	//连接节点p和q
	public void union(int p, int q)
	{
		quick_find_union(q,p);
	}
	
	//寻找节点p所在的连接分量
	public int quick_find(int p)
	{
		return id[p];
	}
	
	private void quick_find_union(int q, int p)
	{
		int qId = quick_find(q);
		int pId = quick_find(p);
		//已经合并了
		if(pId == qId)
		{
			return ;
		}
		for(int i=0; i <id.length; i++)
		{
			if (id[i]==qId)
			{
				id[i] = pId;
			}
		}
		count--;
	}
	
	//判断p和q是否是同一个连接
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	//返回连接的个数
	public int count()
	{
		return count;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Path ="C:\\code\\java_code\\algs4-data\\tinyUF.txt";
		In inputIn = new In(Path);
		int N = inputIn.readInt();
		UF uf = new UF(N);
		while(!inputIn.isEmpty())
		{
			int p = inputIn.readInt();
			int q = inputIn.readInt();
			if(uf.connected(p, q)) continue;
			uf.union(p, q);
			System.out.println(p+" "+q);
		}
		System.out.println(uf.count()+"componentes");
	}

}
