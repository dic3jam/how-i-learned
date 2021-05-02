package StringPriorityQueue;

public class priority_queue_runner {

	public static void main(String[] args) {
		  StringPriorityQueue q = new StringPriorityQueue();
		  System.out.println(q);
		  
		  q.add("apple", 4);
		  System.out.println(q);
		  
		  q.add("banana", 4);
		  System.out.println(q);
		  
		  q.add("cherry", 1);
		  System.out.println(q);
		  
		  q.add("date", 3);
		  System.out.println(q);
		  
		  System.out.println("Traversing with iterator...");
		  for (PriorityString s : q) {
		   System.out.println(s);
		  }
		  
		  System.out.println("\nDequeing...");
		  while (q.size() > 0) {
		   System.out.println(q.dequeue());
		  }
		  
		  System.out.println(q);
		}
}
