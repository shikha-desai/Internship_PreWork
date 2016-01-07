import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {
	
	Queue<Integer> buffer;

	public SharedBuffer() {
		super();
		buffer = new LinkedList<Integer>();
	}
	
	synchronized public void addItem(Integer i) {
		
		if(buffer.size() == ProducerConsumerProblem.MaxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			buffer.add(i);
		}
		
		if(buffer.size() == 1) {
			notify();
		}		
	}
	
	synchronized public int removeItem() {
		
		int item;
		
		if(buffer.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		item = buffer.remove();
		
		if(buffer.size() == (ProducerConsumerProblem.MaxSize-1)) {
			notify();
		}		
		
		return item;
	}

}
