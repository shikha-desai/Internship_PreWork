
public class Person {
	
	int age;
	String workclass;
	String education;
	String gender;
	String country;
	
	public Person() {
		super();
	}
	public Person(int age, String workclass, String education, String gender, String country) {
		super();
		this.age = age;
		this.workclass = workclass;
		this.education = education;
		this.gender = gender;
		this.country = country;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getWorkclass() {
		return workclass;
	}
	public void setWorkclass(String workclass) {
		this.workclass = workclass;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return ("Person : " 
	+ age + " | " 
	+ workclass + " | "
	+ education + " | "
	+ gender + " | "
	+ country + "\n");
	}
	
}
