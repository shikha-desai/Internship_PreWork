import static org.junit.Assert.*;

import java.util.LinkedHashSet;

import org.junit.Test;

public class EmpDBTest {

	@Test
	public void testClass() {
		EmpDB db = new EmpDB();
		assertNotNull(db);
	}
	
	@Test
	public void testClassWithList() {
		LinkedHashSet<Employee> existingDB = new LinkedHashSet<Employee>();
		EmpDB db = new EmpDB(existingDB);
		assertNotNull(db);
	}
	
	@Test
	public void testcreate() {
		EmpDB db = new EmpDB();
		Employee emp = new Employee(1,"shikha",21,25000);
		db.create(emp);
		assertTrue(db.empDB.contains(emp));
	}

}
