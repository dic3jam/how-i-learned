package inheritance;

import java.util.Iterator;

public class OddGenerator implements Iterator<Integer> {
	
	private int nextOdd = 1;

	@Override
	public boolean hasNext() {
		return nextOdd > 0;
	}

	@Override
	public Integer next() {
		int value = nextOdd;
		nextOdd += 2;
		return value;
	}

}
