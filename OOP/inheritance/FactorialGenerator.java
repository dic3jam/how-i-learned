package inheritance;

import java.util.Iterator;

public class FactorialGenerator implements Iterator<Integer> {

	private Integer nextFactorial = 0;

	@Override
	public boolean hasNext() {
		return total > 0;
	}

	@Override
	public Integer next() {
		if(!hasNext()) {
			int count = nextFactorial;
			count--;
			nextFactorial *= count;
			}
			return nextFactorial;
	}
}
