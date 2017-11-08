package Chapter4_2;

public class Topological {
	//记录排序的结果
	private Iterable<Integer> order;
	public Topological(Digraph g) {
		// TODO Auto-generated constructor stub
		//首先检查图中是否存在环，如果存在环就不用继续
		DirectCycle cyclefinder = new DirectCycle(g);
		if(!cyclefinder.hasCycle())
		{
			DepthFirstOrder dfsOrder = new DepthFirstOrder(g);
			order = dfsOrder.reversePost();
		}
	}
	
	//返回图中的排序结果
	public Iterable<Integer> order()
	{
		return order;
	}
	
	//返回途中是否存在环
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
