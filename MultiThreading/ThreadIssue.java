/*

This pgm shows the problems while using threads.
Using thread is fine, until they dont share the same resource.
Problem starts infact only the thread performs write operations.
We try to update the value of a variable with different threads.
"counter" is the variable we shall update.
Do declare this as a global variable otherwise the threads cant 
access it together.
We demo here how the final value and the order of processing the 
variable "counter" cant be determined. 

*/

import java.io.*;

class ThreadCreation extends Thread {

	public int counter = 0 ;

	public void demo() throws InterruptedException{

		

		Thread firstThread = new Thread("firstThread"){
			public void run(){
				System.out.println("Adding 10 by firstThread");
				counter = counter + 10;
				System.out.println("Current value of counter in 1st thread: "+counter);
			}
		};

		Thread secondThread = new Thread("secondThread"){
			public void run(){
				System.out.println("Adding 10 by secondThread");
				counter = counter + 10;
				System.out.println("Current value of counter in 2nd thread: "+counter);
			}
		};

		firstThread.start();
		secondThread.start();
		//firstThread.join();
		//secondThread.join();

		System.out.println("Current value of counter after both threads started: "+counter);
	}
}

class ThreadIssue{
	

	public static void main(String args[])throws IOException,InterruptedException{

		ThreadCreation obj = new ThreadCreation();
		obj.demo();
		
	}
}

/*

mohan@mohans ~/javaPgms/MultiThreading $ java ThreadIssue 
Current value of counter after both threads started: 0
Adding 10 by secondThread
Adding 10 by firstThread
Current value of counter in 1st thread: 20
Current value of counter in 2nd thread: 10

Ideally when the first thread processes it should find it 0.
But it finds it as 10.
Second thread finds it as 0.

*/