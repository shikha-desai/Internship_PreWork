
public class Producer extends Thread {
	
	@Override
	public void run() {
		
		for(int i = 1;i <= ProducerConsumerProblem.MaxSize;i++) {	
			
			this.produce(i);
			System.out.println("Produced : " + i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		super.run();
	}
	
	private void produce(int item) {
		ProducerConsumerProblem.sbuffer.addItem(item);
	}

}
