package inheritance;

/**
 * Defines a mathematical function of a single variable
 * @author jeremy
 *
 */
public interface Function {
	/**
	 * Evaluates the function for a particular input variable
	 * @param x
	 * @return the value of the function
	 */
	public abstract double evaluate(double x);
	
	
	/**
	 * Prints a representation of the function to the console
	 */
	public default void display() {
		System.out.println(this.toString());
	}
}