import java.util.Collection;

@SuppressWarnings("rawtypes")
public interface DBInterface {
	
		void create(Object obj);
		void create(Collection list);
		
		Collection readAll();
		Collection read(ColumnNames col,int value);
		Collection read(ColumnNames col,String value);
		Collection read(ColumnNames col,double value);
		Collection read(Employee emp);
		
		void update(ColumnNames col,int value, Object obj);
		void update(ColumnNames col,String value, Object obj);
		void update(ColumnNames col,double value, Object obj);
		
		void delete(ColumnNames col,int value);
		void delete(ColumnNames col,String value);
		void delete(ColumnNames col,Float value);
		void delete(Employee emp);		
		void deleteAll();

}
