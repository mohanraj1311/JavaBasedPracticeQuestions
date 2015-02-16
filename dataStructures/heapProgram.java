/*
Implement heap data structure. The main methods implemented are :
1. insert
2. remove
3. trickleup 
4. trickledown
5. changekey

insert calls the trickleUp.
remove calls the trickleDown.
changekey may call either of trickleUp or trickleDown.
TrickleUp is simpler becos it invloves comparison with only 1 node, i.e parent
TrickelDown involves finding the larger of the two child and then copying.

*/

class node{
	private int data;
	public node(int key){
		this.data = key;
	}

	public int getkey(){
		return data;
	}

	public void setkey(int key){
		this.data = key;
	}
}


// Begin : class heap

class heap{
	private node[] nodeArray;
	private int maxsize;
	private int currentsize;

	public node[] heapArray;

	public heap(int mx){
		this.heapArray = new node[mx];
		this.maxsize = mx;
		currentsize = 0;
	}

	public boolean insert(int key){
		if(currentsize==maxsize)
			return false;

		node newNode = new node(key);
		heapArray[currentsize] = newNode;
		trickleup(currentsize++);
		return true;
	}

	public void trickleup(int index){
		int parent = (index - 1)/2;
		node bottom = heapArray[index];
		while(index > 0 && heapArray[parent].getkey() < bottom.getkey()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent - 1) / 2;
		}
		heapArray[index] = bottom;
	}

	public node remove(){
		node root = heapArray[0];
		heapArray[0] = heapArray[currentsize--];
		trickledown(0);
		return root;
	}

	public void trickledown(int index){
		int largerChild;
		node top = heapArray[index];
		while(index < currentsize/2){
			int leftchild = 2*index+1;
			int rightchild = leftchild + 1;
			if(rightchild < currentsize && heapArray[leftchild].getkey() < heapArray[rightchild].getkey())
				largerChild = rightchild;
			else
				largerChild = leftchild;

			if(top.getkey() >= heapArray[largerChild].getkey())
				break;

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}

		heapArray[index] = top;
	}

	public void changekey(int index, int newValue){
		if(index < 0 || index > currentsize)
			return;
		int oldValue = heapArray[index].getkey();
		heapArray[index].setkey(newValue);
		if(oldValue < newValue)
			trickleup(index);
		else
			trickledown(index);
		
	}

	public void displayheap(){
		for (int i = 0 ; i < heapArray.length; i++)
			if(heapArray[i]!=null)
				System.out.print(heapArray[i].getkey()+ " ");
	}

}
// End : class heap
	class heapProgram{

		public static void main(String args[]){
		heap heapObj = new heap(10);
		heapObj.insert(1);
		heapObj.insert(2);
		heapObj.insert(3);
		heapObj.insert(4);
		heapObj.insert(5);
		heapObj.insert(6);

		heapObj.displayheap();
		heapObj.changekey(2,9);
		System.out.println("\nAfter changekey");
		heapObj.displayheap();
		System.out.println("");


	}

}

/*
mohan@mohans ~/javaPgms/dataStructures $ java heapProgram 
6 4 5 1 3 2 
After changekey
9 4 6 1 3 2 
mohan@mohans ~/javaPgms/dataStructures $
*/