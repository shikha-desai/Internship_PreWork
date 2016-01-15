
public class GarbageTest {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize method of Garbage Test Class");
		super.finalize();
	}
	
	

}
