package StringPriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a Queue of strings that are each assigned a priority.
 * PriorityStrings are not kept in sorted order and are removed 
 * in order of priority
 * @author Jim DiCesare
 *
 */
public class StringPriorityQueue implements Iterable<PriorityString> {

	/** Elements of the StringPriorityQueue - never null */
	private PriorityString[] elements;	
	
	/** Number of elements in the queue */
	private int size;

	private void repOK() {
		assert (elements != null) : "elements cannot be null";
		assert (elements.length > 0) : "elements must have > 0 items";
		assert (size >= 0) : "size must be > 0";
		assert (size <= elements.length) : "size must be <= the length of elements";
	}
	
	/**
	 * Creates a new StringPriorityQueue
	 */
	public StringPriorityQueue() {
		clear();
	}
	
	/**
	 * @return the current size of the queue
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Creates a new PriorityString and adds to the queue
	 * @param s the string portion of the PriorityString, cannot be null
	 * @param p the priority of the string, must be > 0
	 * @return true if PriorityString created and added successfully,
	 * false if not
	 */
	public boolean add(String s, int p) {
		PriorityString a = new PriorityString(s, p);
		increase_size();
		elements[size-1] = a;
		repOK();
		return true;
	}
	
	/**
	 * Helper function to add - increases the size of the queue
	 * when an element is added 
	 */
	private void increase_size() {
		this.size++;
		PriorityString[] old = elements;
		elements = new PriorityString[size];
		for(int i = 0; i < old.length; i++)
			elements[i] = old[i];
		repOK();
	}
	
	/**
	 * Removes the element of the highest priority from the queue
	 * @return the string representation of the PriorityString that was removed
	 * or null if all priorities are set to int_max
	 */
	public String dequeue() {
		int pos = find_bigkahuna();
		if(pos == -1)
			return null;
		String thatOne = elements[pos].toString();
		condense_array(pos);
		repOK();
		return thatOne;
	}

	/**
	 * Iterates through the queue and identifies the first string with 
	 * the highest priority 
	 * @return integer of the position of the largest element 
	 * within the queue or -1 if all priorities are int_max
	 */
	private int find_bigkahuna() {
		int dapriority = 2147483647;
		int pos = -1;
		for(int i = 0; i < size; i ++){
			if (elements[i].get_priority() < dapriority) {
				dapriority = elements[i].get_priority();
				pos = i;
			}
		}
		return pos;
	}
	
	/**
	 * When an item is removed from the queue, collapses
	 * all items to the right of it and decreases the size
	 * of the queue
	 * @param pos the position of the removed item. Must be > 0, and less than
	 * size
	 */
	private void condense_array(int pos) {
		for(int i = pos; i+1 < size; i++)
			elements[i] = elements[i+1];
		this.size--;
		PriorityString[] old = elements;
		elements = new PriorityString[size];
		for(int i = 0; i < size; i++)
			elements[i] = old[i];
		repOK();
	}
	
	/**
	 * Empties the StringPriorityQueue
	 */
	private void clear() {
		this.elements = new PriorityString[0];
		this.size = 0;
		repOK();
	}
	
	
	@Override
	public Iterator<PriorityString> iterator() {
		return new Iterator<PriorityString>() {
			/** Index of next element to return */
			private int next = 0;

			@Override
			public boolean hasNext() {
				return (next < size);
			}

			@Override
			public PriorityString next() {
				if (next >= size) {
					throw new NoSuchElementException();
				}
				
				return elements[next++];
			}
		};	
		
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("[ ");
		for(PriorityString x : elements)
			b.append(x.toString() + " ,");
		b.append(" ]");
		return b.toString();
	}
}
