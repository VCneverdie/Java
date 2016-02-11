package syy.util;

public class ArrayListinDouble 
{

	private static final int DEFAULT_CAPACITY = 10;

	private int theSize;
	private int[] theItems;

	public ArrayListinDouble()
	{
		doClear();
	}

	public void clear() 
	{
		doClear();
	}

	private void doClear() 
	{
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public int size()
	{
		return theSize;
	}

	public boolean isEmpty() 
	{
		return size() == 0;
	}

	public void trimToSize() 
	{
		ensureCapacity(size());
	}

	public int get(int idx) 
	{
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}

	public int set(int idx, int newVal) 
	{
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException();
		int old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}

	public void ensureCapacity(int newCapacity)
	{
		if (newCapacity < theSize)
			return;

		int[] old = theItems;
		theItems = new int[newCapacity];
		for (int i = 0; i < size(); i++)
			theItems[i] = old[i];
	}

	public boolean add(int x) 
	{
		add(size(), x);
		return true;
	}

	public void add(int idx, int x) 
	{
		if (theItems.length == size())
			ensureCapacity(size() * 2 + 1);
		for (int i = theSize; i > idx; i--)
			theItems[i] = theItems[i - 1];
		theItems[idx] = x;
		theSize++;
	}

	public int remove(int idx) 
	{
		int removedItem = theItems[idx];
		for (int i = idx; i < size() - 1; i++)
			theItems[i] = theItems[i + 1];
		theSize--;
		return removedItem;
	}

	private class ArrayListIterator implements java.util.Iterator
	{
		private int current = 0;

		public boolean hasNext() {
			return current < size();
	}
		
	public int next()
	{
		if (!hasNext())
			throw new java.util.NoSuchElementException();
		return theItems[current++];
	}

	public void remove() 
	{
		ArrayListinDouble.this.remove(--current);
	}
}

}
