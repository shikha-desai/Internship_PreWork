
public class ShutDownHookClass extends Thread {

	@Override
	public void run() {
		
		System.out.println("This is shut down hook...cleaning before closing...");
		
	}	

}
