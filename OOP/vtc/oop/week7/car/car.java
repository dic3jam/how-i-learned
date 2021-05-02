package vtc.oop.week7.car;

/**
 * Represents a car that can be driven by burning fuel.
 * 
 * @author jeremy
 *
 */
public class car {
	/** Number of gallons of gas the tank can hold, must be > 0 */
	private final double FUEL_CAPACITY;
	
	/** Number of miles that can be driven on a gallon of fuel, must be > 0 */
	private final double FUEL_EFFICIENCY;
	
	/** Number of miles car has been driven in its lifetime, >= 0 */
	private double odometer;
	
	/** Number of gallons of fuel in the tank, must be >= 0 and <= {@link FUEL_CAPACITY} */
	private double fuelLevel;
	
	private void repOK() {
		assert(FUEL_CAPACITY > 0);
		assert(FUEL_EFFICIENCY > 0);
		assert(odometer >= 0);
		assert(fuelLevel >= 0 && fuelLevel <= FUEL_CAPACITY);
	}

	/**
	 * Creates a new car with a full tank of gas
	 * 
	 * @param fuelCapacity   - maximum number of gallons of fuel tank can hold, must
	 *                       be > 0
	 * @param fuelEfficiency - car's fuel efficiency in miles per gallon, must be >
	 *                       0
	 * @param odometer       - initial odometer reading in miles, must be >= 0
	 * @throws IllegalArgumentException if fuel tank capacity or fuel efficiency are
	 *                                  0 or negative, or if odometer reading is
	 *                                  negative
	 */
	public car(double fuelCapacity, double fuelEfficiency, double odometer) throws IllegalArgumentException {
			if(fuelCapacity <= 0) {
				throw new IllegalArgumentException("Invalid fuel capacity" + fuelCapacity);
			}
			
			if(fuelEfficiency <= 0) {
				throw new IllegalArgumentException("Invalid fuel efficiency" + fuelEfficiency);
			}
			
			if(odometer < 0) {
				throw new IllegalArgumentException("Invalid initial odometer reading" + odometer);
			}
			
			this.FUEL_CAPACITY = fuelCapacity;
			this.FUEL_EFFICIENCY = fuelEfficiency;
			this.odometer = odometer;
			this.fuelLevel = fuelCapacity;
			
			repOK();
	}

	/**
	 * Drives the car a given number of miles, burning fuel in the process
	 * 
	 * @param nMiles - number of miles to drive, cannot be negative, cannot exceed
	 *               the car's range
	 * @throws IllegalArgumentException if the requested number of miles is negative
	 *                                  or exceeds the car's range
	 */
	public void drive(double nMiles) throws IllegalArgumentException {
			if(nMiles < 0)
				throw new IllegalArgumentException("Invalid distance");
			
			if (nMiles > getRange()) 
				throw new IllegalArgumentException("Too far bro");

			odometer = odometer + nMiles;
			
			fuelLevel = fuelLevel - (nMiles / FUEL_EFFICIENCY);
			
			repOK();
	}

	/**
	 * Fills the car's fuel tank to capacity
	 * 
	 * @return {@code true} if any fuel was added to the tank, {@code false}
	 *         otherwise
	 */
	public boolean refuel() {
		if(fuelLevel < FUEL_CAPACITY) {
			fuelLevel = FUEL_CAPACITY;
			repOK();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return the number of gallons of fuel left in the tank, >= 0
	 */
	public double getFuelLevel() {
		return fuelLevel;
	}

	/**
	 * @return the number of miles the car can be driven until it runs out of fuel,
	 *         >= 0
	 */
	public double getRange() {
		return fuelLevel*FUEL_EFFICIENCY;
	}

	/**
	 * @return how many miles the car has been driven in its lifetime, >= 0
	 */
	public double getOdometerReading() {
		return odometer;
	}
	
	@Override
	public String toString() {
		//Show odometer reading, fuel level / capacity, mpg
		return String.format("Car: odometer = %.1f, fuel = %.1f / %.1f gal, efficiency = %.1f", odometer, fuelLevel, FUEL_CAPACITY, FUEL_EFFICIENCY);
	}
}













