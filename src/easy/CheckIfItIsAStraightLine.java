package easy;

import java.util.*;

public class CheckIfItIsAStraightLine {
	public static boolean checkStraightLine(int[][] coordinates) {
		int xdiff = 0;
		int ydiff = 0;
		int x1 = coordinates[0][0];
		int y1 = coordinates[0][1];
		double tang;
		
		HashSet<Double> xtang = new HashSet<>();
		for(int i=1; i<coordinates.length; i++) {
			int x2 = coordinates[i][0];
			int y2 = coordinates[i][1];
			
			xdiff = x2-x1;
			ydiff = y2-y1;
			y1 = y2;
			x1 = x2;
			if(xdiff == 0) {
				tang = (double) Integer.MAX_VALUE;
			}else if(ydiff == 0){
				tang = 0.0;
			}else {
				tang = (double) ydiff / xdiff;				
			}
			System.out.println(i + " " + xdiff + " " + ydiff+ " " +tang);
			xtang.add(tang);
		}
		
		if(xtang.size()>1) {
			return false;
		}
		return true;
	}
	
	public static boolean onLine(int[] p1, int[] p2, int[] p3) {
		int x = p1[0];
		int y = p1[1];
		int x1 = p2[0];
		int y1 = p2[1];
		int x2 = p3[0];
		int y2 = p3[1];
		
		return (((y-y1)*(x2-x1)) == ((y2-y1)*(x-x1)));
	}
	
	public static boolean checkStraightLine1(int[][] coordinates) {
		if(coordinates.length == 2) {
			return true;
		}
		
		for(int i = 2; i<coordinates.length; i++) {
			return onLine(coordinates[i-2], coordinates[i-1], coordinates[i]);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] coord = {{-3,-2}, {-1,-2}, {2,-2}, {-2,-2},{0,-2}};
		System.out.println(checkStraightLine(coord));
	}
}
