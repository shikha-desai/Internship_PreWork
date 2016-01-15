
public enum ColumnNames {
	ID,NAME,AGE,SALARY;
	
	public String toString() {
		switch(this) {
		case ID :
			return "id";
		case NAME :
			return "name";
		case AGE :
			return "age";
		case SALARY :
			return "salary";
			default :
				return null;
		}
	}
}
