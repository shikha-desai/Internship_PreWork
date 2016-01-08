
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("unchecked")
public class EmpDB implements DBInterface{
	
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
	public void create(Object obj) {
		
		if(obj==null)	return;
		
		if(!(obj instanceof Employee))	return;
		
		Employee emp = (Employee)obj;
		
		//Checking for duplicate ID
		Iterator<Employee> itr = empDB.iterator();
		while(itr.hasNext()) {
			if(emp.getID() == (itr.next()).getID()) {
				System.out.println("Primary Key Conflict");
				return;
			}
		}
		
		empDB.add(emp);
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void create(Collection list) {
		
		if(list == null)	return;
		
		if(list.isEmpty())	return;
		
		if(!(list instanceof LinkedHashSet))	return;
		
		for(Employee emp : (LinkedHashSet<Employee>)list) {
			
			//Checking for duplicate ID
			Iterator<Employee> itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee e = itr.next();
				if(emp.getID() == e.getID()) {
					empDB.remove(e);
				}
			}
			
			empDB.add(emp);
		}
		
	}

	@Override
	public void update(ColumnNames col, int value, Object obj) {
		
		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case ID :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.ID, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
				
					empDB.remove(temp);
	
					Employee emp2 = (Employee)obj;
					emp2.setID(value);
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getNAME() == null)	emp2.setNAME(temp.getNAME());
					if(emp2.getSALARY() == -1)	emp2.setSALARY(temp.getSALARY());
					create(emp2);
					
				}
			}
			else {
				System.out.println("Specified ID doesn't exist");
			}
			
			break;
		case AGE :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.AGE, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
				
					empDB.remove(temp);
	
					Employee emp2 = (Employee)obj;
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getNAME() == null)	emp2.setNAME(temp.getNAME());
					if(emp2.getSALARY() == -1)	emp2.setSALARY(temp.getSALARY());
					create(emp2);
					
				}
			}
			else {
				System.out.println("No employee with specified AGE exists");
			}
			
			break;
		case SALARY :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.SALARY, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
				
					empDB.remove(temp);
	
					Employee emp2 = (Employee)obj;
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getNAME() == null)	emp2.setNAME(temp.getNAME());
					if(emp2.getSALARY() == -1)	emp2.setSALARY(temp.getSALARY());
					create(emp2);
					
				}
			}
			else {
				System.out.println("No employee with specified SALARY exists");
			}
			
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
	}

	@Override
	public void update(ColumnNames col, String value, Object obj) {
		
		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case NAME :
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.NAME, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
				
					empDB.remove(temp);
	
					Employee emp2 = (Employee)obj;
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getNAME() == null)	emp2.setNAME(temp.getNAME());
					if(emp2.getSALARY() == -1)	emp2.setSALARY(temp.getSALARY());
					create(emp2);
					
				}
			}
			else {
				System.out.println("No employee with specified NAME exists");
			}
			
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case SALARY:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
	}

	@Override
	public void update(ColumnNames col, double value, Object obj) {

		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case SALARY :
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.SALARY, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
				
					empDB.remove(temp);
	
					Employee emp2 = (Employee)obj;
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getAGE() == -1)	emp2.setAGE(temp.getAGE());
					if(emp2.getNAME() == null)	emp2.setNAME(temp.getNAME());
					if(emp2.getSALARY() == -1)	emp2.setSALARY(temp.getSALARY());
					create(emp2);
					
				}
			}
			else {
				System.out.println("No employee with specified SALARY exists");
			}
			
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
				
	}

	@Override
	public void deleteAll() {
		
		empDB.clear();
		
	}
	
	@Override
	public void delete(ColumnNames col, int value) {
		
		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case ID :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.ID, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
					empDB.remove(temp);					
				}
			}
			else {
				System.out.println("Specified ID doesn't exist");
			}
			
			break;
		case AGE :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.AGE, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
					empDB.remove(temp);	
				}
			}
			else {
				System.out.println("No employee with specified AGE exists");
			}
			
			break;
		case SALARY :
			
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.SALARY, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {				
					empDB.remove(temp);			}
			}
			else {
				System.out.println("No employee with specified SALARY exists");
			}
			
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
	}

	@Override
	public void delete(ColumnNames col, String value) {
		
		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case NAME :
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.NAME, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
					empDB.remove(temp);
				}
			}
			else {
				System.out.println("No employee with specified NAME exists");
			}
			
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case SALARY:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
	}

	@Override
	public void delete(ColumnNames col, Float value) {

		boolean flag;
		Collection<Employee> result;
		
		switch(col) {
		case SALARY :
			flag = false;
			result = (Collection<Employee>)read(ColumnNames.SALARY, value);
			if(!result.isEmpty())	flag = true;
			
			if(flag) {
				for(Employee temp : result) {
					empDB.remove(temp);					
				}
			}
			else {
				System.out.println("No employee with specified SALARY exists");
			}
			
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection readAll() {
		System.out.println("-----------Employee Database---------");
		System.out.println(ColumnNames.ID + "\t" + ColumnNames.NAME 
				+ "\t\t" + ColumnNames.AGE + "\t" + ColumnNames.SALARY);
		
		Iterator<Employee> itr = empDB.iterator();
		while(itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println(emp.getID() + "\t" + emp.getNAME()
			+ "\t" + emp.getAGE() + "\t" + emp.getSALARY());
		}
		
		return this.empDB;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection read(ColumnNames col, int value) {
		Collection<Employee> result = new LinkedHashSet<Employee>();
		
		System.out.println("-----------Employee Database---------");
		System.out.println(ColumnNames.ID + "\t" + ColumnNames.NAME 
				+ "\t\t" + ColumnNames.AGE + "\t" + ColumnNames.SALARY);
		
		Iterator<Employee> itr;
		switch(col) {
		case ID : 
			itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee temp = itr.next();
				if(temp.getID() == value) {
					result.add(temp);
					System.out.println(temp.getID() + "\t" + temp.getNAME()
					+ "\t" + temp.getAGE() + "\t" + temp.getSALARY());
				}
			}
			break;
		case AGE :
			itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee temp = itr.next();
				if(temp.getAGE() == value) {
					result.add(temp);
					System.out.println(temp.getID() + "\t" + temp.getNAME()
					+ "\t" + temp.getAGE() + "\t" + temp.getSALARY());
				}
			}
			break;
		case SALARY :
			itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee temp = itr.next();
				if(temp.getSALARY() == value) {
					result.add(temp);
					System.out.println(temp.getID() + "\t" + temp.getNAME()
					+ "\t" + temp.getAGE() + "\t" + temp.getSALARY());
				}
			}
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection read(ColumnNames col, String value) {
		Collection<Employee> result = new LinkedHashSet<Employee>();
		System.out.println("-----------Employee Database---------");
		System.out.println(ColumnNames.ID + "\t" + ColumnNames.NAME 
				+ "\t\t" + ColumnNames.AGE + "\t" + ColumnNames.SALARY);
		
		switch(col) {
		case NAME :
			Iterator<Employee> itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee temp = itr.next();
				if(temp.getNAME().equals(value)) {
					result.add(temp);
					System.out.println(temp.getID() + "\t" + temp.getNAME()
					+ "\t" + temp.getAGE() + "\t" + temp.getSALARY());
				}
			}
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case SALARY:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;
		}
		
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Collection read(ColumnNames col, double value) {
		Collection<Employee> result = new LinkedHashSet<Employee>();
		System.out.println("-----------Employee Database---------");
		System.out.println(ColumnNames.ID + "\t" + ColumnNames.NAME 
				+ "\t\t" + ColumnNames.AGE + "\t" + ColumnNames.SALARY);
		
		switch(col) {
		case SALARY :
			Iterator<Employee> itr = empDB.iterator();
			while(itr.hasNext()) {
				Employee temp = itr.next();
				if(temp.getSALARY() == value) {
					result.add(temp);
					System.out.println(temp.getID() + "\t" + temp.getNAME()
					+ "\t" + temp.getAGE() + "\t" + temp.getSALARY());
				}
			}
			break;
		case AGE:
			System.out.println("Invalid Input Value");
			break;
		case ID:
			System.out.println("Invalid Input Value");
			break;
		case NAME:
			System.out.println("Invalid Input Value");
			break;
		default:
			System.out.println("Invalid Column Name");
			break;			
		}
		
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Collection read(Employee emp) {
		Collection<Employee> list= new LinkedHashSet<Employee>();
		for(Employee t : empDB) {
			if( emp.getID() == -1 || emp.getID() == t.getID()) {
				if(emp.getNAME() == null || emp.getNAME().equals(t.getNAME())) {
					if(emp.getAGE() == -1 || emp.getAGE() == t.getAGE()) {
						if(emp.getSALARY() == -1 || emp.getSALARY() == t.getSALARY()) {
							list.add(t);
						}
					}
				}
			}
		}
		return list;
	}
	
}
