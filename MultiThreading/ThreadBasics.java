/*
This program shows how the threads can be implemented.
There are two methods: 1. Using subclass
					   2. By implementing the runnable interface.

*/
import java.io.*;


class myThreadClass extends Thread{
	
		public void run(){
			System.out.println("Thread using subclass");
		}
	
}

class myThreadByRunnableInterface implements Runnable {
	public void run(){
		System.out.println("Thread by runnable interface.");
	}
}

class ThreadBasics{
	public static void main(String[] args)throws IOException{
	System.out.println("-----------------------------------");

	myThreadClass myThreadByThreadExtension = new myThreadClass();
	myThreadByThreadExtension.start();



	System.out.println("-----------------------------------");

	Thread myThreadForRunnableInterface = new Thread(new myThreadByRunnableInterface());
	myThreadForRunnableInterface.start();
	}
}

/*
Output
-----------------------------------
-----------------------------------
Thread using subclass
Thread by runnable interface.


*/