package Chapter1_3;

import java.util.Iterator;

//使用数组实现栈
public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	
	
	private class ReverseIterator implements Iterator<Item>
	{
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return true;
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			return null;
		} @Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
