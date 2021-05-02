package ch6hw;

public class IntStackTester {

	public static void main(String[] args) {

		IntStack a  = new IntStack();
		IntStack b = new IntStack();
		
		a.stack(9);
		a.stack(2);
		a.stack(5);
		a.stack(5);
		a.stack(5);
		
		System.out.println(a.toString());
		
		b.stack(2);
		b.stack(5);	
		
		a.unstack();

		System.out.println(a.toString());
		
		b.addAll(a);
		
		System.out.println(b.toString());
		
		Integer c = 9;

		b.remove(c);

		System.out.println(b.toString());
		
		b.unstack();
		b.unstack();
		
		System.out.println("b: " + b.toString());
		System.out.println("a: " + a.toString());
		
		a.retainAll(b);

		System.out.println(a.toString());
	}

}
