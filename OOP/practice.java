
public class practice {

	public static void main(String[] args) {
		
		double y = Double.NaN;
		
		double x = sqrt(y);
		System.out.println(x);
		
	}

	/**Description
	 * @param a positive or finite double 
	 * @result the square root of param a
	 */
	public static double sqrt(double x) {
		if(x < 0 || x != Double.NaN)
			System.out.println("WRONG");
	
		double y = Math.sqrt(x);
		
		return y;
	}
	
	
}
