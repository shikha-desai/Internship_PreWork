
public class Employee {
	
	int ID;
	String NAME;
	int AGE;
	float SALARY;

	public Employee(int iD, String nAME, int aGE, float sALARY) {
		super();
		ID = iD;
		NAME = nAME;
		AGE = aGE;
		SALARY = sALARY;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public float getSALARY() {
		return SALARY;
	}

	public void setSALARY(float sALARY) {
		SALARY = sALARY;
	}
	
}
