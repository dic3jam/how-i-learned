package ch6hw;

import java.util.Collection;

public class QueueTester {
	public static void main(String[] args) {
		Collection<Integer> q = new IntegerQueue();
		System.out.println(q);
		q.add(4);
		q.add(42);
		q.add(35);
		q.add(35);
		q.add(4);
		
		System.out.println(q);
		System.out.println(q.size());
		
		for (int i : q) {
			System.out.println(i);
		}
		
		System.out.println(q.contains(42));
		System.out.println(q.contains(12));
		
		
		Collection<Integer> a = new IntegerQueue();
		a.add(35);
		a.add(4);
		System.out.println("a: " + a.toString());
		q.removeAll(a);
		System.out.println(q.toString());
	}
}