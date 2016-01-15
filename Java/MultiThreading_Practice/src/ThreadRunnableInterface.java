
public class ThreadRunnableInterface implements Runnable {

	@Override
	public void run() {
		
		System.out.println("This is Runnable Interface  : " + Thread.currentThread().getName()
				+ " with id : " + Thread.currentThread().getId());
		
	}

}
