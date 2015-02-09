/*
Simple thread pgm to print out the thread names.
We make 10 threads.
The name of the thread can be passed as "STRING" arguement.
"getName" method can be used to get the name of the current thread executing.
*/

import java.io.*;

class SimpleThread extends Thread{
	public static void main(String[] args)throws IOException{
		System.out.println(Thread.currentThread().getName());
		for(int i = 0 ; i < 10 ; i++){
			Thread myThread = new Thread(""+i){
				public void run(){
					System.out.println("This is thread : "+getName());
				}
			};
			myThread.start();
		}
	}
}

/*
output :

mohan@mohans ~/javaPgms/MultiThreading $ java SimpleThread
main
This is thread : 0
This is thread : 1
This is thread : 2
This is thread : 3
This is thread : 6
This is thread : 5
This is thread : 4
This is thread : 7
This is thread : 8
This is thread : 9


*/