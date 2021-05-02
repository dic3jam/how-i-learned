package inheritance;

/**
 * Represents a function which is the quotient of two other function
 * @author jeremy
 *
 */
public class Quotient implements Function {
	private Function num;
	private Function den;
	
	/**
	 * Constructs a new quotient function given a function for the numerator
	 * and a function for the denominator.
	 * 
	 * @param num
	 * @param den
	 */
	public Quotient(Function num, Function den) {
		this.num = num;
		this.den = den;
	}

	@Override
	public double evaluate(double x) {
		return num.evaluate(x) / den.evaluate(x);
	}
	
	@Override
	public String toString() {
		return "(" + num.toString() + ") / (" + den.toString() + ")";
	}
	
}

