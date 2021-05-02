package StringPriorityQueue;

/**
 * Represents a priority string consisting of a string and a priority
 * number - immutable object cannot be modified
 * 
 * @author Jim DiCesare
 *  
 */
public class PriorityString {

	/** The string portion of the priority string*/
	private String dastring;
	
	/** The priority, must be > 0 */
	 private int priority;
	 
	private void repOk() {
		assert (dastring != null) : "the string cannot be null";
		assert (priority > 0) : "priority must be > 0";
	}
	
	/**
	 * Creates a PriorityString
	 * @param String cannot be null
	 * @param p must be greater than 0
	 * @throws NullPointerException if string s is null
	 * @throws IllegalArgumentException if p is 0 or less
	 */
	public PriorityString(String s, int p) throws NullPointerException, IllegalArgumentException {
		if(s == null)
			throw new NullPointerException("String cannot be null silly!");
		if(p <= 0)
			throw new IllegalArgumentException("Priorities must be greater than 0");
		this.dastring = s;
		this.priority = p;
		repOk();
	}
	
	/**
	 * Returns the string from this PriorityString
	 * @return the string portion of PriorityString
	 */
	public String get_string() {
		return this.dastring;
	}
	
	/**
	 * Returns the priority of this PriorityString
	 * @return integer value of the priority
	 */
	public int get_priority() {
		return this.priority;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.dastring + ", " + this.priority);
		return builder.toString();
	}
		 
}
