package ch6hw;

public class MaxIntSet extends IntSet {
	
	private int max = 0;

	public MaxIntSet() {
		super();
	}
	
	@Override
	public void add(int x) {
		// If set already contains this number than we do nothing
		if (this.contains(x)) {
			return;
		}

		// If values is full, double its size
		if (size == values.length) {
			int[] oldValues = values;
			values = new int[2 * size];
			for (int i = 0; i < size; i++) {
				values[i] = oldValues[i];
			}
		}
		// If larger than anything currently in the set, update max
		if(x > max) 
			this.max = x;
		
		// Add new element
		values[size] = x;
		size++;
		repOK();
	}
	
	public int getMax() {
		return this.max;
	}
	
}
