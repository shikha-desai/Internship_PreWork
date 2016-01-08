import static org.junit.Assert.*;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.junit.Test;

@SuppressWarnings("unchecked")
public class EmpDBTest {
	
	EmpDB db;
	Employee emp;
	
	public EmpDBTest() {
	
		db = new EmpDB();
		emp = new Employee(1,"Shikha Desai",21,25000);
		
	}

	@Test
	public void testClass() {
		assertNotNull(db);
	}
	
	@Test
	public void testClassWithList() {
		LinkedHashSet<Employee> existingDB = new LinkedHashSet<Employee>();
		EmpDB newDB = new EmpDB(existingDB);
		assertNotNull(newDB);
	}
	
	@Test
	public void test1create() {
		db.create(emp);
		assertTrue(db.empDB.contains(emp));
	}
	
	@Test
	public void test2create() {
		db.create(null);
		assertFalse(db.empDB.contains(null));
	}
	
	@Test
	public void test3create() {
		Object obj = new Object();
		db.create(obj);
		assertFalse(db.empDB.contains(obj));
	}
	
	@Test
	public void test4create() {
		db.create(emp);
		int dbSize = db.empDB.size();
		db.create(emp);		
		assertTrue(db.empDB.size() == dbSize);
	}
	
	@Test
	public void test5create() {
		db.create(emp);
		int dbSize = db.empDB.size();
		Employee emp2 = new Employee(2,"shikha",21,25000);
		db.create(emp2);		
		assertTrue(db.empDB.size() == dbSize + 1);
	}
	
	@Test
	public void test6create() {
		db.create(emp);
		int dbSize = db.empDB.size();
		Employee emp2 = new Employee(1,"shikha",21,25000);
		db.create(emp2);		
		assertTrue(db.empDB.size() == dbSize);
	}
	
	@Test
	public void testcreateMultipleValues() {
		
		Collection<Employee> temp = new LinkedHashSet<Employee>();
		temp.add(emp);
		temp.add(new Employee(2,"Pankti Raval",25,50000));
		temp.add(new Employee(3,"Bhoomi Shah",21,30000));
		
		int dbSize = db.empDB.size();
		db.create(temp);
		assertTrue(db.empDB.size() == dbSize + 3);
		
	}
	
	@Test
	public void test2createMultipleValues() {
		
		db.create(emp);
		
		Collection<Employee> temp = new LinkedHashSet<Employee>();
		temp.add(emp);
		temp.add(new Employee(2,"Pankti Raval",25,50000));
		temp.add(new Employee(3,"Bhoomi Shah",21,30000));
		
		int dbSize = db.empDB.size();
		db.create(temp);
		assertTrue(db.empDB.size() == dbSize + 2);
		
	}
	
	@Test
	public void testreadAll() {
		db.create(emp);
		db.create(new Employee(2,"Bhoomi Shah",21,30000));
		Collection<Employee> tempDB = (Collection<Employee>)db.readAll();
		assertTrue(tempDB.equals(db.empDB));
	}
	
	@Test
	public void testreadByID() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.ID, 1);
		assertTrue(result.contains(emp));
	}
	
	@Test
	public void test2readByID() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.ID, 50);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testreadByName() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.NAME, "Shikha Desai");
		assertTrue(result.contains(emp));
	}
	
	@Test
	public void test2readByName() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.NAME, "Rakesh");
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testreadByAge() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.AGE, 21);
		assertTrue(result.contains(emp));
	}
	
	@Test
	public void test2readByAge() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.AGE, 50);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testreadBySalary() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.SALARY, 25000);
		assertTrue(result.contains(emp));
	}
	
	@Test
	public void test2readBySalary() {
		db.create(emp);
		Collection<Employee> result = (Collection<Employee>)db.read(ColumnNames.SALARY, 50);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void testreadMultipleConditions() {
		db.create(emp);
		db.create(new Employee(2,"Pankti Raval",25,50000));
		db.create(new Employee(3,"Bhoomi Shah",21,30000));
		
		Collection<Employee> r = (Collection<Employee>)db.read(new Employee(1,null,21,-1));
		
		assertTrue(r.size() == 1);
		assertTrue(r.iterator().next().getNAME().equals("Shikha Desai"));
	}
	
	@Test
	public void test1UpdateByID() {
		db.create(emp);
		Employee emp2 = new Employee(1,"Pankti Desai",25,35000);
		db.update(ColumnNames.ID, 1, emp2);
		assertTrue(db.empDB.contains(emp2));
	}
	
	@Test
	public void test2UpdateByID() {
		db.create(emp);
		Employee emp2 = new Employee(1,"Pankti Desai",25,35000);
		db.update(ColumnNames.ID, 100, emp2);
		assertFalse(db.empDB.contains(emp2));
	}
	
	@Test
	public void test3UpdateByID() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,-1,50000);
		db.update(ColumnNames.ID, 1, emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.ID, 1);
		for(Employee e : temp) {
			assertTrue(e.getSALARY() == 50000);
		}
	}
	
	@Test
	public void test4UpdateByID() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,-1,50000);
		db.update(ColumnNames.ID, 1, emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.ID, 1);
		for(Employee e : temp) {
			assertFalse(e.getNAME() == null);
		}
	}
	
	@Test
	public void test1UpdateByAge() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,25,35000);
		db.update(ColumnNames.AGE, 21, emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.AGE, 21);
		for(Employee e : temp) {
			assertTrue(e.getSALARY() == 35000);
		}
		
		//db.read();
	}
	
	@Test
	public void test1UpdateByName() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,25,35000);
		db.update(ColumnNames.NAME, "Shikha Desai", emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.NAME, "Shikha Desai");
		for(Employee e : temp) {
			assertTrue(e.getSALARY() == 35000);
		}
		//db.read();
	}
	
	@Test
	public void test1UpdateBySalary() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,25,35000);
		db.update(ColumnNames.SALARY, 25000, emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.SALARY, 25000);
		for(Employee e : temp) {
			assertTrue(e.getAGE() == 25);
		}
		
		//db.read();
	}
	
	@Test
	public void test2UpdateBySalary() {
		db.create(emp);
		Employee emp2 = new Employee(1,null,25,35000);
		db.update(ColumnNames.SALARY, 25000.00, emp2);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.SALARY, 25000.00);
		for(Employee e : temp) {
			assertTrue(e.getAGE() == 25);
		}
		//db.read();
	}	
	
	@Test
	public void testupdateMultipleConditions() {
		db.create(emp);
		db.create(new Employee(2,"Pankti Raval",25,50000));
		db.create(new Employee(3,"Bhoomi Shah",21,30000));
		
		Collection<Employee> r1 = (Collection<Employee>)db.read(ColumnNames.AGE, 21);
		Collection<Employee> r = (Collection<Employee>)(new EmpDB((LinkedHashSet<Employee>)r1)).read(ColumnNames.ID, 1);
		
		EmpDB temp = new EmpDB((LinkedHashSet<Employee>)r);
		temp.update(ColumnNames.AGE,21,new Employee(-1,null,-1,55000));
		
		db.empDB.remove(r);
		db.create(temp.empDB);
		
		assertTrue(db.read(ColumnNames.SALARY,55000).size() == 1);
	}
	
	@Test
	public void testdeleteAll() {
		db.create(emp);
		db.deleteAll();
		assertTrue(db.empDB.isEmpty());
	}
	
	@Test
	public void testdeleteByID() {
		db.create(emp);
		db.delete(ColumnNames.ID, 1);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.ID, 1);
		assertTrue(temp.isEmpty());
	}
	
	@Test
	public void testdeleteByName() {
		db.create(emp);
		db.delete(ColumnNames.NAME, "Shikha Desai");
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.NAME, "Shikha Desai");
		assertTrue(temp.isEmpty());
	}
	
	@Test
	public void testdeleteByAge() {
		db.create(emp);
		db.delete(ColumnNames.AGE, 21);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.AGE, 21);
		assertTrue(temp.isEmpty());
	}
	
	@Test
	public void testdeleteBySalary() {
		db.create(emp);
		db.delete(ColumnNames.SALARY, 25000);
		Collection<Employee> temp = (Collection<Employee>)db.read(ColumnNames.SALARY, 25000);
		assertTrue(temp.isEmpty());
	}
	
/*	@Test
	public void testdeleteMultipleConditions() {
		db.create(emp);
		db.create(new Employee(2,"Pankti Raval",25,50000));
		db.create(new Employee(3,"Bhoomi Shah",21,30000));
		
		Collection<Employee> r1 = (Collection<Employee>)db.read(ColumnNames.AGE, 21);
		Collection<Employee> r = (Collection<Employee>)(new EmpDB((LinkedHashSet<Employee>)r1)).read(ColumnNames.ID, 1);
		
		int dbSize = db.empDB.size();
		db.empDB.remove(r);
	}*/
	
}
