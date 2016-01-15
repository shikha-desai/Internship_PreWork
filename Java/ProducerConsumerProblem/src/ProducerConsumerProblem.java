
public class ProducerConsumerProblem {
	
	static int MaxSize = 10;
	static SharedBuffer sbuffer;
	
	public static void main(String[] args) {
		
		System.out.println("------------------------------ Producer Consumer Problem ---------------------------");
		
		sbuffer = new SharedBuffer();
		
		Producer p = new Producer();
		Consumer c = new Consumer();
		
		p.start();
		c.start();
		
		//Test1 -> buffer is full and producer trying to add more, it should wait till consumed
		/*Producer p1 = new Producer();
		Consumer c1 = new Consumer();
		p1.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c1.start();*/
		
		//Test2 -> buffer is empty and consumer trying to consume, it should wait till produced
		/*Producer p2 = new Producer();
		Consumer c2 = new Consumer();
		c2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p2.start();*/
		
	}

}
