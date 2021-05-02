package vtc.oop.week7.car;

public class TestDrive {

	public static void main(String[] args) {
		
		car Jeep = new car(18, 14, 45000);
		
		System.out.println(Jeep.toString());
		
		Jeep.drive(200);
				
		System.out.println(Jeep.toString());

	}

}
