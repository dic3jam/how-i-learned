package inheritance;

/**
 * Represents a salaried employee at a company
 * @author jeremy
 *
 */
public class Employee {
	public static final int PAYCHECKS_PER_YEAR = 26;
	
	/** Employee's name, never null, never empty */
	private String name;
	
	/** Employee's annual salary, must be > 0 */
	private double annualSalary;
	
	private void repOK() {
		assert(name != null);
		assert(!name.isEmpty());
		assert(annualSalary > 0);
	}
	
	/**
	 * Creates a new employee
	 * @param name - employee's full name, never null, never empty
	 * @param annualSalary - must be positive
	 * @throws NullPointerException if name is null
	 * @throws IllegalArgumentException if name empty or annual salary is <= 0
	 */
	public Employee(String name, double annualSalary) throws NullPointerException, IllegalArgumentException {
		if (name == null) {
			throw new NullPointerException("name cannot be null");
		}
		
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		
		if (annualSalary <= 0) {
			throw new IllegalArgumentException("Invalid salary: " + annualSalary);
		}
		
		this.name = name;
		this.annualSalary = annualSalary;
		repOK();
	}
	
	/**
	 * @return the amount of this employee's bi-weekly paycheck
	 */
	public double getPaycheckAmount() {
		return annualSalary / PAYCHECKS_PER_YEAR;
	}
}