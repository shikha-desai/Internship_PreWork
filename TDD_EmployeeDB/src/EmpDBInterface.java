public interface EmpDBInterface {
	
	void create(Employee emp);
	
	void read();
	
	void update(ColumnNames col,int value, Employee emp);
	void update(ColumnNames col,String value, Employee emp);
	void update(ColumnNames col,Float value, Employee emp);
	
	void delete(ColumnNames col,int value);
	void delete(ColumnNames col,String value);
	void delete(ColumnNames col,Float value);

}
