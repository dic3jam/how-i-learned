
public class Counters {
	/**
	 * count the number of occurrences of value in the first count elements of nums
	 * @param nums the array of numbers to search, never null
	 * @param count the number of elements in array to consider,
	 * must be >= 0, must be <= nums.length
	 * @param value the value being searched for in nums
	 * @return returns the number of occurrences of value in nums, always >= 0.
	 */ 
	public static int countValues(int[] nums, int count, int value) {

		int occurrences = 0; 
		boolean isValid = true;

		//check nums for null or empty
		if(nums == null || nums.length == 0) {
			System.out.println("Hey fool, I need a real array");
			occurrences  = -1;
			isValid = false;
		}
		
		//check count is >= 0 and less than nums.length
		if(count < 0 || count > nums.length) {
			System.out.println("Count must be smaller than the array");
			occurrences  = -1;
			isValid = false;
		}
		
		//check value to ensure it is a valid number
		if(value == Double.NaN) {
			System.out.println("Value must be a real number");
			occurrences  = -1;
			isValid = false;	
		}
		
		//now find occurrences of value
		if(isValid) {			
			for(int i = 0; i < count; i++) {		
				if(value == nums[i]) {
					occurrences++;	
				}
				
			}	
		}
	
		return occurrences;
		
	}

	/**
	 * find the first occurrence of value in nums
	 * @param nums the array of numbers to search, never null
	 * @param count the number of elements in array to consider,
	 * must be >= 0, must be <= nums.length
	 * @param value the value being searched for in nums
	 * @return the index of the occurrence (>= 0) or -1 if not found.
	 */
	public static int findFirst(int[] nums, int count, int value) {
		
		int occurrence = 0; 
		boolean isValid = true;

		//check nums for null or empty
		if(nums == null || nums.length == 0) {
			System.out.println("Hey fool, I need a real array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check count is >= 0 and less than nums.length
		if(count < 0 || count > nums.length) {
			System.out.println("Count must be smaller than the array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check value to ensure it is a valid number
		if(value == Double.NaN) {
			System.out.println("Value must be a real number");
			occurrence  = -1;
			isValid = false;	
		}

		//now find the first occurrence
		if(isValid) {			
			for(int i = 0; i < count; i++) {		
				if(value == nums[i]) {
					occurrence = i;	
					break;
				}
			}	
			if(occurrence == 0)
				occurrence = -1;
		}
	
		return occurrence;
	}

	/**
	 * find the next occurrence of value in the range num[after+1 .. count-1]
	 * @param nums the array of numbers to search, never null
	 * @param count the number of elements in array to consider,
	 * must be >= 0, must be <= nums.length
	 * @param value the value being searched for in nums
	 * @param after the earliest value not to consider, must be >= 0, < count
	 * @return the index of the occurrence (> after, < count) or -1 if not found.
	 */
	public static int findNext(int[] nums, int count, int value, int after) {
		
		int occurrence = 0; 
		boolean isValid = true;

		//check nums for null or empty
		if(nums == null || nums.length == 0) {
			System.out.println("Hey fool, I need a real array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check count is >= 0 and less than nums.length
		if(count < 0 || count > nums.length) {
			System.out.println("Count must be smaller than the array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check value to ensure it is a valid number
		if(value == Double.NaN) {
			System.out.println("Value must be a real number");
			occurrence  = -1;
			isValid = false;	
		}
		
		//check after to ensure it is > count but less than the array length
		if(after > count || after > nums.length) {
			System.out.println("After must be smaller than count and smaller than the array");
			occurrence  = -1;
			isValid = false;
		}

		//now find the next occurrence
		if(isValid) {			
			for(int i = after + 1; i < count; i++) {		
				if(value == nums[i]) {
					occurrence = i;	
					break;
				}
			}	
			if(occurrence == 0)
				occurrence = -1;
		}
	
		return occurrence;
		
	}

	/**
	 * find the last occurrence of value in nums
	 * @param nums the array of numbers to search
	 * @param count the number of elements in array to consider,
	 * must be >= 0, must be <= nums.length
	 * @param value the value being searched for in nums
	 * @return the index of the occurrence (>= 0, < count) or
	 * -1 if not found.
	 */
	public static int findLast(int[] nums, int count, int value) {
		
		int occurrence = 0; 
		boolean isValid = true;

		//check nums for null or empty
		if(nums == null || nums.length == 0) {
			System.out.println("Hey fool, I need a real array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check count is >= 0 and less than nums.length
		if(count < 0 || count > nums.length) {
			System.out.println("Count must be smaller than the array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check value to ensure it is a valid number
		if(value == Double.NaN) {
			System.out.println("Value must be a real number");
			occurrence  = -1;
			isValid = false;	
		}

		//now find the last occurrence
		if(isValid) {			
			for(int i = 0; i < count; i++) {		
				if(value == nums[i]) {
					occurrence = i;		
				}
			}	
			if(occurrence == 0)
				occurrence = -1;
		}
	
		return occurrence;
	}	

	/**
	 * find the previous occurrence of value in nums before before
	 * @param nums the array of numbers to search
	 * @param count the number of elements in array to consider,
	 * must be >= 0, must be <= nums.length
	 * @param value the value being searched for in nums
	 * @param before consider only elements in nums between 0 and before-1,
	 * must be <= count * @return the index of the occurrence (>= 0, < count) or
	 * -1 if not found.
	 */
	public static int findPrev(int[] nums, int count, int value, int before) {
		
	
		int occurrence = 0; 
		boolean isValid = true;

		//check nums for null or empty
		if(nums == null || nums.length == 0) {
			System.out.println("Hey fool, I need a real array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check count is >= 0 and less than nums.length
		if(count < 0 || count < nums.length) {
			System.out.println("Count must be smaller than the array");
			occurrence  = -1;
			isValid = false;
		}
		
		//check value to ensure it is a valid number
		if(value == Double.NaN) {
			System.out.println("Value must be a real number");
			occurrence  = -1;
			isValid = false;	
		}
		
		//check after to ensure it is > count but less than the array length
		if(before > count || before > nums.length) {
			System.out.println("Before must be smaller than count and the array");
			occurrence  = -1;
			isValid = false;
		}

		//now find the next occurrence
		if(isValid) {			
			for(int i = 0; i < before; i++) {		
				if(value == nums[i]) {
					occurrence = i;	
					break;
				}
			}	
			if(occurrence == 0)
				occurrence = -1;
		}
	
		return occurrence;	
				
	}

	public static void main(String[] args) {

		int[] nums = {2,4,6,23,54,4,6,78,23,2,9,25,25,98,12,34,23};
		
		int test1 = countValues(nums, nums.length, 23); 
		System.out.println("Count values says 23 occurs " + test1 + " times in the array");
	
		int test2 = findFirst(nums, 10, 6);
		System.out.println("findFirst says 6 occurs for the first time at " + test2);
		
		int test3 = findNext(nums, nums.length, 2, 3);
		System.out.println("findNext says 2 occurs at " + test3 + " after index 3");
		
		int test4 = findLast(nums, nums.length, 25);
		System.out.println("Last occurrence of 25 is at "+ test4);
		
		int test5 = findPrev(nums, nums.length, 23, 13);
		System.out.println("findPrev returns " + test5);
		
		System.out.println("\nThese tests will fail\n");
		
		test1 = countValues(nums, nums.length + 2, 23); 
		System.out.println(test1);
		
		int[] thisarrayisempty = {};

		test2 = findFirst(thisarrayisempty, 10, 6);
		System.out.println(test2);
		
		test3 = findNext(nums, 5, 2, 3);
		System.out.println(test3);
	
		//not in the array
		test4 = findLast(nums, nums.length, 7);
		System.out.println(test4);
		
		test5 = findPrev(nums, 10, 23, 13);
		System.out.println(test5);

	}
	
}

