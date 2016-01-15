
//Inheritance
public class Car extends Vehicle {
		
	MusicSystem UsesMusicSys; //Association
	
	public Car() {
		super(4);
	}

	public Car(String numPlate) {
		super(4, numPlate);
	}

	public Car(String numPlate, MusicSystem UsesMusicSys) {
		super(4, numPlate);
		this.UsesMusicSys = UsesMusicSys;
	}
	
	//Overriding
	public void who() {
		System.out.println("I am a Car");
	}
	
	public void CarLocalMethod() {
		System.out.println("Car's own method");
	}
	
	public String toString() {
		return "Car with " + this.NumOfWheels + " has number " + this.getNumPlate();
	}
	
}
