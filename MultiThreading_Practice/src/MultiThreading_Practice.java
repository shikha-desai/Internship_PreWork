import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading_Practice {

	public static void main(String[] args) {
		
		System.out.println("Hello user");
		System.out.println("Enter your choice : ");
		System.out.println("1. Mutithreading");
		System.out.println("2. Synchronization");
		
		Scanner scanner = new Scanner(System.in);
		int ch = scanner.nextInt();
		
		switch(ch)
		{
		case 1 :
			{
				System.out.println("----------------Multi Threading------------------");
				
				ThreadClass t1 = new ThreadClass();
				
				//System.out.println("State of thread1 : " + t1.getState());
				//t1.start();
				System.out.println("State of thread1 : " + t1.getState());
				
				//Allowed but in the same call stack of this class instead of separate call stack: 
				t1.run();
				
				System.out.println("State of thread1 : " + t1.getState());
				
				ThreadRunnableInterface r1 = new ThreadRunnableInterface();
				Thread t2 = new Thread(r1);
				t2.start();
				
				//This is to print "testing sleep method" correctly after runnable
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\nTesting sleep method : ");
				SleepThread t3 = new SleepThread();
				SleepThread t4 = new SleepThread();
				t3.start();
				t4.start();
				
				System.out.println("State of thread2 : " + t2.getState());
				//IllegalThreadStateExecution Exception (can't start again) : t2.start();
				
				//This join is just to see the result of t5 and t6 after t4 instead of all together
				try {
					t4.join();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("\nTesting join method : ");
				SleepThread t5 = new SleepThread();
				SleepThread t6 = new SleepThread();
				t5.start();
				try {
					t5.join(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				t5.setName("Joined Thread");
				t6.start();
				
				try {
					Thread.sleep(3500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("");
				ThreadDaemon t9 = new ThreadDaemon();
				t9.setDaemon(true);
				t9.start();
				System.out.println("");
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Status of daemon " + t9.getState());
				System.out.println("");
				
				SleepThread t7 = new SleepThread();
				SleepThread t8 = new SleepThread();
				System.out.println("Priority of thread : " + Thread.currentThread().getName() 
						+ " is "+ Thread.currentThread().getPriority()
						+ " compared to normal priority " + Thread.NORM_PRIORITY);
				t7.setPriority(Thread.MIN_PRIORITY);
				t8.setPriority(Thread.MAX_PRIORITY);
				t7.start();
				t8.start();
				System.out.println("Priority of thread : " + t7.getName() 
						+ " is "+ t7.getPriority()
						+ " compared to min priority " + Thread.MIN_PRIORITY);
				System.out.println("Priority of thread : " + t8.getName() 
						+ " is "+ t8.getPriority()
						+ " compared to max priority " + Thread.MAX_PRIORITY);
				System.out.println("");
				
				System.out.println("Status of daemon " + t9.getState());
				System.out.println("");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nTesting Thread Pool");
				ExecutorService executor = Executors.newFixedThreadPool(5);
				for(int i = 0;i < 10;i++)
				{
					Runnable worker = new WorkerThread(""+i);
					executor.execute(worker);
				}
				executor.shutdown();
				while(!executor.isTerminated()) {}
				System.out.println("Finished all threads of threadpool");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\nTesting Thread Group");
				ThreadRunnableInterface r2 = new ThreadRunnableInterface();
				
				ThreadGroup tg1 = new ThreadGroup("Parent Group");
				
				Thread t1tg1 = new Thread(tg1,r2,"One");
				Thread t2tg1 = new Thread(tg1,r2,"Two");
				Thread t3tg1 = new Thread(tg1,r2,"Three");
				
				t1tg1.start();
				t2tg1.start();
				t3tg1.start();
				
				System.out.println("Number of threads running in group " + tg1.getName() + " : " + tg1.activeCount());
				tg1.list();
				
				//Using shutdown hook
				Runtime r = Runtime.getRuntime();
				r.addShutdownHook(new ShutDownHookClass());
				//The shutdown sequence can be stopped by invoking the halt(int) method of Runtime class.
				
				try {
					Runtime.getRuntime().exec("gedit"); //Creates this process as a separate process
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("");
				System.out.println("No. of available processors : " + r.availableProcessors());
				System.out.println("Total JVM memory : " + r.totalMemory());
				System.out.println("Free JVM memory : " + r.freeMemory());
				
				GarbageTest gt1 = new GarbageTest();
				GarbageTest gt2 = new GarbageTest();
				gt1 = gt2;
				System.gc();
				gt2 = null;
				
				System.out.println("After garbage collection");
				System.out.println("Total JVM memory : " + r.totalMemory());
				System.out.println("Free JVM memory : " + r.freeMemory());
				System.out.println("");
			}
			break;
		case 2 :
			{
				System.out.println("----------------Synchronization------------------");
				
			}
			break;
			default :
				System.out.println("Wrong choice");
				break;
		}
		
		//It can be seen that the gc for gt2 is not called, this shows that it is not always necessary that gc is called
		
		System.out.println("Now JVM closing....");
		
	}

}
