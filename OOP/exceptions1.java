import java.util.Scanner;

public class exceptions1 {
	
	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);

		try {	
			System.out.println("Enter the dividend: ");
			int dividend = console.nextInt();
			
			System.out.println("Enter the divisor: ");
			int divisor = console.nextInt();
			
			int quotient = dividend / divisor;
			System.out.println("Quotient is: " + quotient);
		}
		
		catch (ArithmeticException e) {
			System.out.println("NO!");
		}
		
		
	}

}
