package Chapter4_2;

public class Topological {
	//��¼����Ľ��
	private Iterable<Integer> order;
	public Topological(Digraph g) {
		// TODO Auto-generated constructor stub
		//���ȼ��ͼ���Ƿ���ڻ���������ڻ��Ͳ��ü���
		DirectCycle cyclefinder = new DirectCycle(g);
		if(!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfsOrder = new DepthFirstOrder(g);
			order = dfsOrder.reversePost();
		}
	}
	
	//����ͼ�е�������
	public Iterable<Integer> order()
	{
		return order;
	}
	
	//����;���Ƿ���ڻ�
	public boolean isDAG()
	{
		return order != null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
