/* 
 * OOP Ch.5 HW pt 1 Prob 5.5
 * @author Jim DiCesare
 */

package vtc.oop.week6.hw;

import java.util.Arrays;

public class IntQueue {
	
	private int q[];
	private int maxsize;
	private int length;
			
	/**
	 * Creates an integer Queue of size zero and sets the maximum size.
	 * The queue adds elements to
	 * the end of the queue and removes them from the front.
	 * @param qsize maximum size queue can be. Must be greater than 0
	 * @return an IntQueue object of size 0
	 * @throws NegativeArraySizeException if maximum size is less than 0
	 */
	public IntQueue(int qsize) throws NegativeArraySizeException{ 
		
		if(qsize < 0)
			throw new NegativeArraySizeException();

		maxsize = qsize;	
		length = 0;
		q = new int[length];	
	
		repOk();
	}

	/**
	 * Adds 1 to size of the IntQueue if the new size does not exceed the max size
	 * toAdd is then added to the end of the IntQueue. 
	 * @param toAdd can be any integer
	 * Queue will be appropriately resized to accommodate the addition and will include
	 * toAdd on the end
	 */
	public void enq(int toAdd) {
		
		length++;
		
		if(length > maxsize) {
			System.out.println("You can't do that!");
			return;	
		}
					
		int[] b = new int[length];
		
		System.arraycopy(q, 0, b, 0, (length-1));
		
		b[length-1] = toAdd;
		
		q = b;
		
		repOk();
	
	}

	/**
	 * Precondition: Queue must be larger than 0
	 * Removes the first element from the queue and resizes accordingly
	 * @throws NegativeArraySizeException if the array is less than 0.
	 */
	public int deq() {
		
		length--;
		
		if(length <= 0)
			throw new NegativeArraySizeException();

		int first = q[0];
		
		int[] resize = new int[length];
		
		System.arraycopy(q, 1, resize, 0, (length));
		
		q = resize;
		
		repOk();
		
		return first;

	}

	/**
	 * Returns a string denoting the abstract value of this IntQueue
	 * @return a string representing the current values in the IntQueue 
	 */
	public String toString() {

		String out = Arrays.toString(q);
		
		return out;
	}

	/**
	 * Verifies that this IntQueue is holding the rep invariant:
	 * maxsize must be > 0
	 * this cannot be null
	 */
	private void repOk() {
		assert(this.maxsize > 0) : "The array size must be greater than 0";
		assert(this != null) : "IntQueue cannot be null";
	}

/* for testing		
public static void main(String args[]) {

	IntQueue a = new IntQueue(4);
	
	a.enq(5);
	a.enq(10);
	a.enq(25);

	System.out.println(a.toString());	

	int o = deq();
	System.out.println("Deq " + o);
		
	System.out.println(a.toString());
	
	a.enq(2);
	a.enq(4);
	
	int c = deq();
	
	System.out.println("Deq " + c);
	
	System.out.println(a.toString());
	
	a.enq(1);
	a.enq(9);
	
	System.out.println(a.toString());	
	
	a.enq(9);
	
	System.out.println(a.toString());		
}*/
		
}
