package week4;

public class week4class1 {
	/**
	 * Removes all instances of value in array a 
	 * @param a Integer array that is not null
	 * @param value any real number
	 * @return a new array that has removed all instances of value
	 * and has condensed down on itself
	 */
	public static int[] removeAll(int[] a, int value) {

		int[] b = null;
	
		for(int i = 0; i < a.length; i++) {
			int j = 0;
			if(a[i] != value) {
				b[j] = a[i];
				j++;
			}
			else if (a[i] == value)
				continue;
		}
 				
		return b;	
	}

	/**
	 * Removes all instances of value in array a and replaces with newValue 
	 * @param a Integer array that is not null
	 * @param value any real number
	 * @param newValue any real number that will replace all instances of value	
	 * @return a new array that has removed all instances of value
	 * and has condensed down on itself
	 */
	public static int[] replaceAll(int[] a, int value, int newValue) {
	
		return a;
	}
	
	
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 5, 6, 6, 6, 7};
		
		int[] b = removeAll(a, 6);
		
		System.out.println(b);

	}

}
