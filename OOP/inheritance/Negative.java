package inheritance;

public class Negative implements Function {
	private Function num;
	
	/**
	 * Constructs a new negative function
	 * 
	 * @param num
	 */
	public Negative(Function num) {
		this.num = num;
	}
	
	@Override
	public double evaluate(double x) {
		return num.evaluate(x) * -1;
	}
	
	@Override
	public String toString() {
		return "-" + num.toString();
	}

}
