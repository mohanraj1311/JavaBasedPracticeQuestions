//Serialization is shown in this program.
/*
Serialization is the process of turning an object into binary data.
and writing it into a file.
*/

import java.io.*;

class Person implements Serializable{
	private int id;
	private String name;

	public Person(int id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString(){
		return "Person [id="+id+ ",name="+name+"]";
	}
}

public class WriteObjects{
	public static void main(String[] args){
		System.out.println("Writing objects...");

		Person mohan = new Person(25,"Mohan");
		Person raj = new Person(123,"Raj");

		System.out.println(mohan);
		System.out.println(raj);

		try(FileOutputStream fs = new FileOutputStream("people.bin")){

			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(mohan);
			os.writeObject(raj);

			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}