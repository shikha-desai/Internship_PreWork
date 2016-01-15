
public class ThreadDaemon extends Thread{

	@Override
	public void run() {
		
		if(Thread.currentThread().isDaemon())	System.out.println(Thread.currentThread().getName() + " is daemon");
		else	System.out.println(Thread.currentThread().getName() + " is user thread");
		
		System.out.println("");
				
	}

}
