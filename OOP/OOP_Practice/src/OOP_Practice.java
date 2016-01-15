
public class OOP_Practice {
	
	public static void main(String[] args){
		
		System.out.println("Hello user");
		System.out.println("Applying OOP Concepts");
		
		Vehicle v = new Vehicle(2,"GJ-01-RG-5811");
		Car c = new Car("GJ-06-BK-3124");
		
		System.out.println("Using Vehicle reference to Vehicle : " + v);
		//Abstraction
		v.who();
		System.out.println("Using Car reference to Car: " + c);
		c.who();
		//Not allowed: c.super.who();
		//But allowed if inside method of Car super.who()
		
		//Dynamic binding, Run Time polymorphism
		Vehicle v2 = new Car("GJ-01-RG-5811"); //Implicit Cast
		//RunTime Error : Car c2 = (Car)new Vehicle(4,"GJ-06-BL-3849"); //Explicit Cast
		
		System.out.println("Using Vehicle to Car : " + v2);
		v2.who();
		//Compile Error : v2.CarLocalMethod();
		//Error : System.out.println("Using Car reference to Vehicle: " + c2);
		
	}
	
}
