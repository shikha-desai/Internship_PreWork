
public class ThreadClass extends Thread{

	@Override
	public void run() {
		//super.run();
		System.out.println("This is Thread Class : " + Thread.currentThread().getName()
				+ " with id : " + Thread.currentThread().getId());
	}

	
	
}
