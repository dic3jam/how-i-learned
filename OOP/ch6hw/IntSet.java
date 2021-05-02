/**1. Create a subclass of IntSet called MaxIntSet which includes a new operation max() which returns the 
 * largest value in the set, throwing an IllegalOperationException if the set is empty. Hint: you shouldn't need 
 * to traverse the IntSet every time someone calls max().

2. Create a class IntStack that implements the Collection interface. A stack is a LIFO queue, where the last element added is the first element removed.
*/

package ch6hw;

import java.util.Iterator;

/**
 * Represents a set of integers with no duplicate values
 * 
 * @author jeremy
 *
 */
public class IntSet implements Iterable<Integer>{
	/** Stores the elements of the set, no duplicates */
	protected int[] values;

	/**
	 * Number of elements in values used so far, must be >= 0 and <=
	 * {@link #values}.length
	 */
	protected int size;

	/** Initial size for {@link #values} */
	protected final static int INITIAL_CAPACITY = 10;

	protected void repOK() {
		// Values is not null
		assert (values != null) : "values cannot be null";

		// Size is valid
		assert (size >= 0) : "Invalid size: " + size;
		assert (size <= values.length) : "Ivalid size " + size + " for values.length = " + values.length;

		// No duplicate values
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				assert (values[i] != values[j]) : "duplicate value " + values[i] + " at indices " + i + " and " + j;
			}
		}

		// Extra values are padding
		for (int i = size; i < values.length; i++) {
			assert (values[i] == 0);
		}
	}

	/**
	 * Creates an empty set
	 */
	public IntSet() {
		values = new int[INITIAL_CAPACITY];
		size = 0;
		repOK();
	}

	/**
	 * Adds an element to the set. If the element already exists, the set is
	 * unmodified.
	 * 
	 * @param x
	 */
	public void add(int x) {
		// If set already contains this number than we do nothing
		if (this.contains(x)) {
			return;
		}

		// If values is full, double its size
		if (size == values.length) {
			int[] oldValues = values;
			values = new int[2 * size];
			for (int i = 0; i < size; i++) {
				values[i] = oldValues[i];
			}
		}

		// Add new element
		values[size] = x;
		size++;
		repOK();
	}

	/**
	 * Removes an element from the set. If the element is not in the set, the set is
	 * unmodified.
	 * 
	 * @param x
	 */
	public void remove(int x) {
		// Search set for element
		for (int i = 0; i < size; i++) {
			if (values[i] == x) {
				// Found element, remove it and move remaining elements back
				for (int j = i + 1; j < size; j++) {
					values[j - 1] = values[j];
				}

				// Reduce size by one and reset last element to 0
				size--;
				values[size] = 0;
				repOK();
				return;
			}
		}
	}

	/**
	 * 
	 * @param x
	 * @return {@code true} if the given element is in the set, {@code false}
	 *         otherwise
	 */
	public boolean contains(int x) {
		for (int i = 0; i < size; i++) {
			if (values[i] == x) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 
	 * @return the number of elements in the set
	 */
	public int size() {
		return size;
	}
	
	public String toString() {
		String s = "{ ";
		
		for (int i = 0; i < size; i++) {
			s = s + values[i] + " ";
		}
		
		return s + "}";
	}
	
	@Override
	public Iterator<Integer> iterator() {
		
		
		return null;
	}
	
	private class IntSetIterator implements Iterator<Integer> {
		
		private int next;

		@Override
		public boolean hasNext() {
			return next < size;
		}

		@Override
		public Integer next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException();

			int value = values[next];
			next++;
			return value;
		}
		
	}
}

