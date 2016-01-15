
public class SleepThread extends Thread{

	@Override
	public void run() {
	
		for(int i = 0;i < 5;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(i+1 + " in Thread : " + Thread.currentThread().getName()
				+ " with id : " + Thread.currentThread().getId());
		}
	
	}

}
