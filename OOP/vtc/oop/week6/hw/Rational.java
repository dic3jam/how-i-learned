/*
 *OOP Ch.5 HW pt 1 Prob 5.7
 *@author Jim DiCesare 
 */
package vtc.oop.week6.hw;

public class Rational {
	private int numerator;
	private int denominator;

	/**
	 * Constructs a rational number from inputted numerator and denominator
	 * @param num any integer value
	 * @param denom any integer value other than 0
	 * @throws ArithmeticException if denominator is 0
	 */
	public Rational(int num, int denom) throws ArithmeticException{
		if (denom == 0)
			throw new ArithmeticException();
		
		numerator = num;
		denominator = denom;
		
		repOk();
			
	}
		
	/**
	 * Shows the abstract value of the Rational number as a fraction and a decimal
	 * @return a String of the this
	 */
	public String toString() {
		
		double rational = numerator/denominator;

		String daString = numerator + "/" + denominator + " " + rational;

		return daString;	
	}

	/**
	 * numerator can be any integer number
	 * denominator can be any integer number other than 0
	 * Rational cannot be null
	 */
	private void repOk() {
		assert(denominator != 0) : "Denominator cannot be 0";
		assert(this != null) : "Rational objects cannot be null";
	}
	
}	
