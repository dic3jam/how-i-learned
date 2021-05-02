
import java.util.Date;


public class jdhw3 {

//Problem 1==================================================================
/**
 * Determines if a number is a prime number
 * @param num positive integer, not infinity or NaN
 * @return boolean true if prime, boolean false if not
 */
	public static boolean isPrime(int num) {
		if(num <= 0 || num == Double.POSITIVE_INFINITY  || num == Double.NaN)
			//I ain't playin
			System.exit(1);	
		//create a boolean to return
		boolean prime = true;
		//start with the smallest possible divisor
		int f = 2;
		//while num is greater than its square root
		while (num > Math.sqrt(num)) {
			//all possible numbers up to the square root of num must return 
			//a remainder in order for num to be prime
			if (num % f == 0) {
				prime = false;
				break;
			}
			else {
				num /= f;
				f++;
			}
			
		}
		
		return prime;
		
	}
//Problem 2===================================================================
	
/**
* Updates the start date
* @param year year + 1900, must be positive number, not infinity or NaN
* @param month must be greater than 0 and less than 12
* @param date must be greater than 0 and less than 31
* @return startdate must be less than enddate
*/
	public static void updateStartDate(int year, int month, int date) {
	if(year <= 0 || year == Double.POSITIVE_INFINITY  || year == Double.NaN)
		//I ain't playin
		System.exit(1);	
	else if(month <= 0 || month > 12 || month == Double.POSITIVE_INFINITY|| month == Double.NaN)
		System.exit(1);
	else if(date <= 0 || date > 31 || date == Double.POSITIVE_INFINITY|| date == Double.NaN)
		System.exit(1);
	else
		int startdate = (int) Date(year, month, date);
	
	if(startdate > enddate)
		System.exit(1);
	
	}

/**
* Updates the end date
* @param year year + 1900, must be positive number, not infinity or NaN
* @param month must be greater than 0 and less than 12
* @param date must be greater than 0 and less than 31
* @return enddate must be greater than startdate
*/
		public static void updateEndDate(int year, int month, int date) {
			
			if(year <= 0 || year == Double.POSITIVE_INFINITY  || year == Double.NaN)
				//I ain't playin
				System.exit(1);	
			else if(month <= 0 || month > 12 || month == Double.POSITIVE_INFINITY|| month == Double.NaN)
				System.exit(1);
			else if(date <= 0 || date > 31 || date == Double.POSITIVE_INFINITY|| date == Double.NaN)
				System.exit(1);
			else
				int enddate = (int) Date(year, month, date);
			
			if (enddate < startdate)
				System.exit(1);
			
		}	
/**
 * Returns an integer of the duration between the end date and the start date
 * @return integer that is the difference between the start date and end date
 */
	
	public static int duration(void) {
		
		return enddate - startdate;
		
	}
	
//Problem 3===================================================================	
	

	
	
	
	

//============================================================================
	/*
	public static void main(String args[]) {
		
		boolean prime = isPrime(47);
		
		System.out.println(prime);
		
	}
	*/
	
	
	         
	
	
	
	
	
	
	
	
	
}
