package dates;

/**
 * Represents a date on the Gregorian calendar (i.e. September 30, 2020 CE).
 * 
 * @author jeremy
 *
 */
public class Date {
	
	/** day of the month, must be valid for given month */
	private int day;
	
	/** month of the year from 1-12 */
	private int month;
	
	/** year CE, negative for BCE, cannot be 0 */
	private int year;
	
	private void repOK() {
		// code to ensure that all those things we put in 
	}

	/**
	 * Creates a new Date given a day, month, and year
	 * 
	 * @param day   - day of the month, must be a valid day value between 1 and the
	 *              number of days in the given month
	 * @param month - month of the year from 1-12 (1 = January, 2 = February, etc.)
	 * @param year - positive for CE, negative for BCE, cannot be 0
	 */
	public Date(int day, int month, int year) throws IllegalArgumentException {

	}
	
	/*
	 * Other possible constructors
	public Date(int dayOfYear, int year) {
		
	}
	
	public Date(int epochDay) {
		
	}*/

	/**
	 * Determines if this date occurs before another
	 * 
	 * @param other - date to compare to, never null
	 * @return {@code true} if this date occurs before the other date, {@code false}
	 *         if it is the same date or occurs afterwards
	 * @throws NullPointerException if other is null
	 */
	public boolean isBefore(Date other) throws NullPointerException {
		return false;
	}

	/**
	 * Determines how many days until another date
	 * 
	 * @param other - never null
	 * @return the number of days until the other date, positive if other date is
	 *         later in time, negative if other date is earlier
	 * @throws NullPointerException if other is null
	 */
	public int daysUntil(Date other) throws NullPointerException {
		return 0;
	}

	/**
	 * 
	 * @return the day number of the year from 1 to 365
	 */
	public int dayOfYear() {
		return 0;
	}
}
