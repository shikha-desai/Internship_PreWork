
public class Vehicle {
	//Encapsulation
	int NumOfWheels;
	private String NumPlate;
	Engine OwnsEngine; //Composition
	Person Driver; //Aggregation
	
	//Constructor overloading
	public Vehicle() {
		super();
	}
	
	public Vehicle(int numOfWheels) {
		super();
		NumOfWheels = numOfWheels;
	}
	
	public Vehicle(int numOfWheels, String numPlate) {
		super();
		NumOfWheels = numOfWheels;
		NumPlate = numPlate;
	}
	
	public Vehicle(int numOfWheels, String numPlate, Engine ownsEngine, Person driver) {
		super();
		NumOfWheels = numOfWheels;
		NumPlate = numPlate;
		OwnsEngine = ownsEngine;
		Driver = driver;
	}

	public int getNumOfWheels() {
		return NumOfWheels;
	}
	public void setNumOfWheels(int numOfWheels) {
		NumOfWheels = numOfWheels;
	}
	public String getNumPlate() {
		return NumPlate;
	}
	public void setNumPlate(String numPlate) {
		NumPlate = numPlate;
	}	
	public Engine getOwnsEngine() {
		return OwnsEngine;
	}
	public void setOwnsEngine(Engine ownsEngine) {
		OwnsEngine = ownsEngine;
	}
	public Person getDriver() {
		return Driver;
	}
	public void setDriver(Person driver) {
		Driver = driver;
	}

	public void who() {
		System.out.println("I am a Vehicle");
	}
	
	public String toString() {
		return "Vehicle with " + this.NumOfWheels + " has number " + this.NumPlate;
	}

}
