
public class Person {
	
	static int hash = 0;
	String name;
	int age;
	int myhash;
		
	public Person() {
		super();
		hash++;
		this.myhash = hash;
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		hash++;
		this.myhash = hash;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int hashCode() {

		//return this.age; // to test the condition of same hash and not equals
		return this.myhash;
		
	}
	@Override
	public boolean equals(Object obj) {
	
		Person other = (Person)obj;
		
		if(this.name.equals(other.name)) {
			return true;
		}
		else if(this.age == other.age) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Override
	public String toString() {
		
		return "Person : " + this.name + "-" + this.age;
	}
	
	
	
}
