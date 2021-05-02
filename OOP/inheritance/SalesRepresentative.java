package inheritance;

/**
 * Represents an employee who sells products and gains commission based on 
 * value ot those sales
 * 
 * @author Jim
 *
 */
public class SalesRepresentative extends Employee{
	
	/** Total dollar value of sales of this rep, >= 0 */
	private double salesTotal;
	
	/** Percentage of sales as bonus pay. 5.0 = 5%, must be >= 0*/
	private double commissionPercentage;
	
	private void repOk() {
		assert(salesTotal >= 0);
		assert(commissionPercentage >= 0);
	}
	
	/**
	 * Records a new sale to this reps account
	 * @param amount - dollar amount must be >= 0
	 */
	public void sell(double amount) {
		if (amount <0) {
			throw new IllegalArgumentException("Can't sell negative amounts of product!");
		}
		salesTotal += amount;
		repOk();
	}

	@Override
	public double getPaycheckAmount() {
		double commission = salesTotal * commissionPercentage / 100;
		salesTotal = 0;
		repOk();
		return super.getPaycheckAmount() + commission;
	}
}
