
public class Consumer extends Thread{

	@Override
	public void run() {

		for(int i = 1;i <= ProducerConsumerProblem.MaxSize;i++) {
			
			int item = this.consume();
			System.out.println("Consumed : "+item);
			
		}
		
		super.run();
	}
	
	private int consume() {
		return ProducerConsumerProblem.sbuffer.removeItem();
	}

}
