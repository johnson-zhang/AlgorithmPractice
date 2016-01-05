package sen;
/*
 * Given a N*N chess board, a robot starts from the left-up corner and ends at right-down corner. It can only move one cell per time and the direction must be right or down.
Give the algorithm that count all possible paths. 
 */
public class MatrixPath {
	public static int getPaths(int x, int y) {
		if(x == 1 || y == 1 ) return 1;
		return (getPaths(x-1, y) + getPaths(x, y-1));
	}
	public static void main(String[] args) {
		System.out.println("test 1x1 matrix: " + getPaths(1,1) );
		System.out.println("test 1x2 matrix: " + getPaths(1,2) );
		System.out.println("test 2x1 matrix: " + getPaths(2,1) );
		System.out.println("test 2x2 matrix: " + getPaths(2,2) );
		System.out.println("test 7x8 matrix: " + getPaths(7,7) );
	}

}
