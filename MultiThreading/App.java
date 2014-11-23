/*
This program shows the use of the 'volatile' keyword.
Its used to stop the threads from caching the variables.
When the variable used by one thread has to be modified by another 
thread, this volatile comes handy.
In the program below, the main thread changes the value of a variable which is
being used by the thread t1 which we spawned.
*/

import java.io.*;
import java.util.*;

class Processor extends Thread{

	private volatile boolean running = true;

	public void run(){
		while(running){
			System.out.println("hello");

			try{
				Thread.sleep(100);
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public void shutdown(){
		running = false;
	}

}


class App{

	public static void main(String args[]){

		Processor proc1 = new Processor();
		proc1.start();

		System.out.println("Press return to stop...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();

		proc1.shutdown();


}

}
