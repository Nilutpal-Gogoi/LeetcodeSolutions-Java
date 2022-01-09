package easy;

import java.util.*;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
	public static boolean checkValid(int[][] matrix) {
		for(int i = 0; i<matrix.length; i++) {
			int res = check(matrix, i);
			if(res < matrix.length) return false;
		}
		return true;
	}
	
	public static int check(int[][] matrix, int row) {
		HashSet<Integer> set = new HashSet<>();
		for(int i =0; i<matrix[0].length; i++) {
			set.add(matrix[row][i]);
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,2},{3,1,2},{2,3,1}};
		System.out.println(checkValid(matrix));
	}
}
