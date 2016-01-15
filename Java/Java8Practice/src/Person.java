import java.util.StringJoiner;

public class Person {

	String name;
	String gender;
	int age;
	
	public Person() {
		super();
	}
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(" | ", "{", "}");
		sj.add(this.name);
		sj.add(this.gender);
		sj.add(Integer.toString(this.age));
		String s = sj.toString();
		return s;
	}
	
	
	
}
