/*
IPvalidation:
Given a string such that 1st part : Start of the subnet 
						 2nd part : End of the subnet
						 3rd part : The IP to validate

Splitting on . requires \\ escape characters.
*/

import java.io.*;
import java.util.*;

class IPvalidator{

	public boolean isValidIP(String s){

		String[] threeIPs = s.split(" ");
		String[] startIP = threeIPs[0].split("\\.");
		//System.out.println(startIP.length);
		String[] endIP = threeIPs[1].split("\\.");
		String[] checkIP = threeIPs[2].split("\\.");
		int[] startIParr = new int[startIP.length];
		int[] endIParr = new int[endIP.length];
		int[] checkIParr = new int[checkIP.length];

		for(int i = 0 ; i < 4; i++){
			startIParr[i] = Integer.parseInt(startIP[i]);
			endIParr[i] = Integer.parseInt(endIP[i]);
			checkIParr[i] = Integer.parseInt(checkIP[i]);

		}
		//System.out.println("ThreeIP length:"+threeIPs.length);
		//System.out.println(startIParr.length);

		if(startIParr.length!=4||endIParr.length!=4||checkIParr.length!=4||threeIPs.length!=3||
			startIParr[0]<=0||startIParr[0]>255||
			endIParr[0]<=0||endIParr[0]>255||
			checkIParr[0]<=0||checkIParr[0]>255){
			//System.out.println("FirstLoop");
			return false;
		}
			

		for(int i = 0 ; i < 4 ; i++){
			if((startIParr[i]>checkIParr[i])||(checkIParr[i]>endIParr[i]) || (checkIParr[i]>255)||(checkIParr[i]<0)
				||(startIParr[i]>255)||(startIParr[i]<0)||(endIParr[i]>255)||(endIParr[i]<0)){
				//System.out.println("SecLoop");
				return false;
			}
				
		}

		return true;

	}
	public static void main(String args[])throws IOException{
		System.out.println("Enter the String : StartIP EndIP ValidateIP");
		Scanner myScan = new Scanner(System.in);
		String s = myScan.nextLine();

		IPvalidator obj = new IPvalidator();
		if(obj.isValidIP(s))
			System.out.println("IP valid");
		else
			System.out.println("IP invalid");

	}
}

/*
mohan@mohans ~/javaPgms $ java IPvalidator
Enter the String : StartIP EndIP ValidateIP
192.0.0.0 192.0.0.255 192.0.0.110
IP valid
mohan@mohans ~/javaPgms $
*/