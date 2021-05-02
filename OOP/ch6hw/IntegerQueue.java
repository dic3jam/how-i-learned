package ch6hw;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents a first-in first-out (FIFO) queue of integers
 * @author jeremy
 *
 */
public class IntegerQueue implements Collection<Integer> {
	/** Initial size of queue. */
	private final static int INITIAL_SIZE = 8;
	
	/** Elements of queue - never null, never empty. */
	private Integer[] elements;
	
	/** Number of elements in queue and index where next enqueued value should be placed. */
	private int size;
	
	private void repOK() {
		assert (elements != null) : "elements cannot be null";
		assert (elements.length > 0) : "elements cannot be empty";
		assert (size >= 0) : "size (" + size + ") must be >= 0";
		assert (size <= elements.length) : "size (" + size + ") must be <= elements.length (" + elements.length + ")";
	}
	
	/**
	 * Creates an empty queue.
	 */
	public IntegerQueue() {
		clear();
	}
	
	/**
	 * Adds an element to the end of the queue
	 * @param x
	 * @return {@code true} if the queue was changed by this operation
	 */
	public boolean enqueue(Integer x) {
		if (size == elements.length) {
			resize();
		}
		
		elements[size] = x;
		size++;
		repOK();
		return true;
	}
	
	/**
	 * Resizes the queue so it can hold more elements
	 */
	private void resize() {
		Integer[] old = elements;
		elements = new Integer[2 * elements.length];
		
		for (int i = 0; i < old.length; i++) {
			elements[i] = old[i];
		}
		
		repOK();
	}
	
	/**
	 * Removes and returns the element from the front of the queue.
	 * 
	 * @return the element from the front of the queue.
	 * @throws NoSuchElementException if the queue is empty.
	 */
	public Integer dequeue() throws NoSuchElementException {
		if (size == 0) {
			throw new NoSuchElementException();
		}

		// Get value at front
		Integer value = elements[0];
		
		// Mark as empty - necessary for the case where the queue has only one element
		elements[0] = null;
		
		// Shift all elements back
		for (int i = 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}

		size--;
		repOK();
		return value;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		
		for (int i = 0; i < size; i++) {
			builder.append(elements[i]);
			
			if (i < size - 1) {
				builder.append(", ");
			}
		}
		
		builder.append(']');
		return builder.toString();
	}

	@Override
	public boolean add(Integer i) {
		return enqueue(i);
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		boolean changed = false;
		for(Integer i : c) {
			boolean thisOneAdded = this.add(i);
			changed = changed || thisOneAdded;
		}
		return changed;
	}

	@Override
	public void clear() {
		elements = new Integer[INITIAL_SIZE];
		size = 0;
		repOK();
	}

	@Override
	public boolean contains(Object o) {
		for (Integer i : this) {
			if (o.equals(i)) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// For every element of c ask if this collection contains that element
		// If not - then return false
		// If so - keep checking
		
		// If we get all the way through then return true
		for (Object o : c) {
			if (!this.contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			/** Index of next element to return */
			private int next = 0;

			@Override
			public boolean hasNext() {
				return (next < size);
			}

			@Override
			public Integer next() {
				if (next >= size) {
					throw new NoSuchElementException();
				}
				
				return elements[next++];
			}
		};
	}
	/*
	 * If multiple instances of this exist in queue
	 * then the instance closest to the front of the queue
	 * will be removed
	 */
	@Override
	public boolean remove(Object o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])){
				for(int j = i; j < size -1; j++) {
					elements[j] = elements[j+1];
				}
				size--;
				repOK();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		for(Object o : c) {
			while(this.contains(o))
				changed = this.remove(o) || changed;
		}
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		IntegerQueue toRemove = new IntegerQueue();
	
		for(Integer i : this) {
			if (c.contains(i)) {
				toRemove.add(i);
			}
		}
		return this.removeAll(toRemove);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		
		for(int i = 0; i < size; i++)
			a[i] = elements[i];
		
		return a;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}