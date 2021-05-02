package week4;

import week4.NotFoundException;

/*
 * 2260 OOP
 * @author James DiCesare
 * Ch.4 Homework
 */

//4.2 - Frankly it does not seem to matter which loop you choose. I was able to 
// do the while loop in less lines of code. They both accomplish the same thing though when
//one is restricted to using an out of bounds exception to terminate a loop rather than
//a logical condition.

public class ch4hw {

	public static int searchFor(int[] a, int x) 
		throws NullPointerException, NotFoundException {	
		/**
		 * @requires: a is sorted
		 * @effects: if a is null throws NullPointerException; else if x is not in a,
		 * throws NotFoundException; else returns i such that a[i] = x.
		 */
			if(a == null)
				throw new NullPointerException();

			int i = 0;
			boolean itsThere = false;
						
			for(int b = 0; /*b < a.length*/; b++) {	
				if(a[b] == x) {
					i = b;
					itsThere = true;
					break;
				}
			}

			if(!itsThere)	
				throw new NotFoundException(x + " is not found in the array");			
			else
				return i;
	}
	
	public static int searchWhile(int[] a, int x) 
		throws NullPointerException, NotFoundException {	
		/**
		 * @requires: a is sorted
		 * @effects: if a is null throws NullPointerException; else if x is not in a,
		 * throws NotFoundException; else returns i such that a[i] = x.
		 */
			if(a == null)
				throw new NullPointerException();

			int i = 0;
			boolean itsThere = true;
			int b = 0;	

			while(itsThere) {	
				if(a[b] == x) {
					i = b;
					itsThere = false;	
				}
				b++;
			}

			if(!itsThere)	
				throw new NotFoundException(x + " is not found in the array");			
			else
				return i;
	}
				
	public static void main(String[] args) {

		int[] a = {24,56,56,23,67};
		
		int x = 24;
		int i = 0;
	
		try { i = searchFor(a, x); }
		
		catch (NullPointerException e) {
			System.out.println("The array is empty dummy");
		}
		catch (NotFoundException d) {
			System.out.println(d);
		}
		catch (ArrayIndexOutOfBoundsException c) {
			System.out.println("Gotta catch em all");
			return;
		}
		
		System.out.println(x + " is at index " + i);
		
		
		int y = 57;
		int u = 0;
		
		try { u = searchWhile(a, y); }
		
		catch (NullPointerException e) {
			System.out.println("The array is empty dummy");
		}
		catch (NotFoundException d) {
			System.out.println(d);
		}
		catch (ArrayIndexOutOfBoundsException c) {
			System.out.println("Gotta catch em all");
			return;
		}
		
		System.out.println(y + " is at index " + u);
		
	}
	
//4.3 - You would want the procedure to throw an exception in this case. If it returned 0, the caller
//could mistake that for the sum of the integers in the array. An exception provides better context to
//the caller and detail to action upon.
		
//4.4 - 

	static void combine(int[] a, int[] b)
		throws NullPointerException {
		/**
		 * @effects: if a or b are null, throws NullPointerException for the respective
		 * empty array; else multiples in place each element of a by the sum of the elements
		 * in b. 
		 * 
		 * This is a good specification because the calling program can catch for one 
		 * exception type that is relevant to both failure cases. This procedure can include
		 * a separate message depending upon which array it found to be null.
		 */

	}

}













