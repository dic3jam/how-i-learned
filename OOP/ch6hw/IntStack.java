 // Create a class IntStack that implements the Collection interface. A stack is a LIFO queue, where the last element added is the first element removed.
 /*
 * OOP Ch.5 HW pt 1 Prob 5.5
 * @author Jim DiCesare
 */

package ch6hw;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntStack implements Collection<Integer> {
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
	public IntStack() {
		clear();
	}	
	
	public boolean stack(Integer x) {
		if(size == elements.length)
			resize();
		
		elements[size] = x;
		size++;
		repOK();
		return true;
	}

	private void resize() {
		Integer[] old = elements;
		elements = new Integer[2 * elements.length];
		
		for (int i = 0; i < old.length; i++) {
			elements[i] = old[i];
		}
		
		repOK();
	}
	
	public Integer unstack() throws NoSuchElementException {
		if(size == 0)
			throw new NoSuchElementException();
		
		Integer value = elements[size];
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
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
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
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int next = 0;
			
			@Override
			public boolean hasNext() {
				return (next < size);
			}
			
			@Override
			public Integer next() {
				if(next >= size) {
					throw new NoSuchElementException();
				}
				return elements[next++];
			}
		};
	}

	@Override
	public Object[] toArray() {
		Object[] a = new Object[size];
		
		for(int i = 0; i < size; i++)
			a[i] = elements[i];
		
		return a;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if(a.length < size ) {
			a = (T[]) new Object[size];
		}
		if(a.length > size) {
			a[size] = null;
		}
		for(int i = 0; i < size; i++) {
			a[i] = (T) elements[i];
		}
		return a;
	}

	@Override
	public boolean add(Integer e) {
		return stack(e);
	}

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
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!this.contains(o)) {
				return false;
			}
		}
		return true;
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
	public void clear() {
		elements = new Integer[INITIAL_SIZE];
		size = 0;
		repOK();
	}
}
