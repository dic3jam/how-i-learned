/*
 * Exam 1 OOP
 * @author Jim DiCesare
 */

package Exam1;

import java.util.Arrays;

public class exam1 {

	/**
	 * Takes an array of integers, adds each integer and returns the sum
	 * @param a integer array that is not null
	 * @return the sum of the integers within a
	 * @throws NullPointerException if a points to null
	 */
	public static int sum(int[] a) throws NullPointerException {
		
		int sum = 0;
		
		for(int x : a)
			sum += x;

		return sum;
				
	}

	/**
	 * Takes an array of integers, and returns the maximum number	
	 * @param a an integer array that is not null
	 * @return the maximum value contained in the array
	 * @throws NullPointerException if the array is null
	 */
	public static int max(int[] a) throws NullPointerException {
		
		int max = 0;
		
		for(int x : a) {
			if(x > max)
				max = x;
		}
		
		return max;

	}

	/**
	 * Takes an array of integers, determines if the numbers in the array are a palindrome
	 * @param a array that is not null
	 * @return boolean representing the array is a palindrome or not
	 * @throws NullPointerException if the array is null
	 */
	public static boolean isPalindrome(int[] a) throws NullPointerException {
		
		boolean itIs = true;

		int i = 0;
		int j = a.length - 1;
		while(i < a.length)	{
			if(a[i] != a[j]) {
				itIs= false;
				break;
			}
			i++;
			j--;
		}
		
		return itIs;

	}

	/**
	 * Returns an array of strings containing only String s, for num times
	 * @param s any string so long as it is not null
	 * @param num any positive integer greater than 1
	 * @return Array of strings containing string s num times
	 * @throws NullPointerException if s is null
	 * @throws invalidArraySize if num is < 1
	 */
	public static String[] repeat(String s, int num) throws NullPointerException, invalidArraySize {
	
		if(s == null)
			throw new NullPointerException("s cannot be null");

		if(num < 1)
			throw new invalidArraySize("Must provide an array size of 1 or greater");
	
		String[] repeated = new String[num];
		
		for(int i = 0; i < num; i++) {
			repeated[i] = s;
		}
		
		return repeated;
	}
		
	public static void main(String[] args) {

		int[] a = {1,1,5};	

		int itWorked = sum(a);	
		System.out.println(itWorked);
		
		int thatWorked = max(a);
		System.out.println(thatWorked);
	
		int[] b = {1,2,3,4,5,6,5,4,3,2,1};
		boolean didThatWork = isPalindrome(b);
		System.out.println(didThatWork);
		
		String s = "chugga";
		String[] knockknock = repeat(s, 8);
		System.out.print(Arrays.deepToString(knockknock));
		System.out.println(" Choo choo!");
		
	}

}
