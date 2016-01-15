
public class WorkerThread implements Runnable {

	String message;
	
	
	public WorkerThread(String message) {
		super();
		this.message = message;
	}


	@Override
	public void run() {
		
		System.out.println("Worker Thread " + Thread.currentThread().getName()
				+ " (Start) message = " + message);
		processMessage();
		System.out.println("Worker Thread " + Thread.currentThread().getName()
				+ " (End) message = " + message);
		
	}
	
	private void processMessage() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
