package Chapter1_5;

import java.nio.file.Path;

import edu.princeton.cs.algs4.In;


public class UF {
	//����ýڵ����ڵ�����
	private int []id;
	//�ڵ�ĸ���
	private int count;
	//�ڵ����ڸ��ڵ����Ŀ
	private int []sz;
	//��ʼ��һ����n���ڵ��
	public UF(int n) {
		// TODO Auto-generated constructor stub
		count = n;
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] =i;
		}
	}
	
	//���ӽڵ�p��q
	public void union(int p, int q)
	{
		weighted_quick_union(q,p);
	}
	
	//Ѱ�ҽڵ�p���ڵ����ӷ���
	public int quick_find(int p)
	{
		return id[p];
	}
	
	public int quickUnionFind(int p)
	{
		while(p!=id[p]) p = id[p];
		return p;
	}
	
	//quick_find������Ҫ��union
	private void quick_find_union(int q, int p)
	{
		int qId = quick_find(q);
		int pId = quick_find(p);
		//�Ѿ��ϲ���
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
	
	//��ͨ��quick_union����
	private void quick_union(int p, int q)
	{
		int pRoot = quickUnionFind(p);
		int qRoot = quickUnionFind(q);
		if(pRoot == qRoot)return;
		id[pRoot] = qRoot;
		count--;
	}
	//j��Ȩ��quick_union����
	
	private void weighted_quick_union(int q, int p)
	{
		int pRoot = quickUnionFind(p);
		int qRoot = quickUnionFind(q);
		if(pRoot == qRoot)return;
		if(sz[pRoot]>sz[qRoot])
		{
			id[qRoot] = id[pRoot];
			sz[pRoot] += sz[qRoot];
		}
		else {
			id[pRoot] = id[qRoot];
			sz[qRoot] = sz[pRoot];
		}
		count--;
	}
	
	
	//�ж�p��q�Ƿ���ͬһ������
	public boolean connected(int p, int q)
	{
		return id[p] == id[q];
	}
	
	//�������ӵĸ���
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
