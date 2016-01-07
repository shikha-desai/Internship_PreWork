import java.util.LinkedHashSet;

public class EmpDB implements EmpDBInterface{
	
	LinkedHashSet<Employee> empDB;

	public EmpDB() {
		super();
		this.empDB = new LinkedHashSet<Employee>();
	}
	
	public EmpDB(LinkedHashSet<Employee> empDB) {
		super();
		this.empDB = empDB;
	}

	@Override
	public void create(Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ColumnNames col, int value, Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ColumnNames col, String value, Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ColumnNames col, Float value, Employee emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ColumnNames col, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ColumnNames col, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ColumnNames col, Float value) {
		// TODO Auto-generated method stub
		
	}

	
	
}
