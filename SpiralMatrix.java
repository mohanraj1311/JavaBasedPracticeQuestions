/*
This program prints the spiral matrix.
Let the matrix be like below :

1   2   3   4
5   6   7   8
9   10  11 12
13  14  15 16
Algo: Declare for 4 variables: Top, right, left, down.
      Divide the matrix as 4 parts :
      Top left to right
      right top to down
      down right to left
      left down to top
with each iteration let the matrix shrink.
So keep on printing and checking.

while printing elements two things have to be kept in mind:
1. the direction of printing : left to right , top to down , right to left and down to up.
2. What remains a constant : row or column ?
3. Whatever remains constant: increase or decrease that
4. give break conditions with side printing.
	

*/

class SpiralMatrix {

	public void printSpiral(int[][] mat){
		int top = 0;
		int left = 0;
		int right = mat[top].length - 1;
		int down = mat.length - 1;
		//System.out.println(down);

		while(true){

			// print top left to right
			for(int i = left ; i <= right; ++i)
				System.out.print(mat[top][i]+" ");
			top++;

			if((top > down)||(left > right)) break;

			// print right top to down
			for(int i = top; i <= down ; ++i)
				System.out.print(mat[i][right]+" ");
			right--;

			if((top > down)||(left > right)) break;

			// print down right to left
			for(int i = right; i >= left ; --i)
				System.out.print(mat[down][i]+" ");
			down--;

			if((top > down)||(left > right)) break;

			// print left down to top
			for(int i = down; i >= top ; --i)
				System.out.print(mat[i][left]+ " ");
			left++;

			if((top > down)||(left > right)) break;


		}
	} 
	public static void main(String args[]){
	int [][] mat = {
					{1,   2,   3,   4},
					{5,   6,   7,   8},
					{9,   10,  11, 12},
					{13,  14,  15, 16}
					};	
	SpiralMatrix SpiralMatrixObj = new SpiralMatrix();
	SpiralMatrixObj.printSpiral(mat);
	System.out.println("");
	}
}

/*
SAMPLE OUTPUT : 
mohan@mohans ~/javaPgms $ java SpiralMatrix 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
mohan@mohans ~/javaPgms $ 
*/