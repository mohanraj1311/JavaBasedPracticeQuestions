/*
This program reverses the order words of a sentence.
For eg: 
input  : University of florida
Output : Florida of university
*/


import java.io.*;
import java.util.*;


class SentenceWordReversal{

public static void main(String args[])throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter String ");
String input = br.readLine();
StringBuffer output = new StringBuffer();

Stack<String> stackx = new Stack<String>();

String[] arrString = input.split(" ");

for(String s: arrString){
	//System.out.println(s);
	stackx.push(s);
}

while(stackx.size() > 0){
	//System.out.println(stackx.size());
	output = output.append(stackx.pop()+" ");

}

System.out.println("The reverse sentence is "+output);

}

}

/*
mohan@mohans ~/javaPgms $ java SentenceWordReversal 
Enter String 
Do or do not, there is no try.
The reverse sentence is try. no is there not, do or Do 
mohan@mohans ~/javaPgms $ 
*/
