package medium;

import java.util.*;

public class KthClosestPointsToOrigin {
	
	static class Pair implements Comparable<Pair>{
		int x;
		int y;
		int len;
		
		public Pair(int x, int y, int len) {
			this.x = x;
			this.y = y;
			this.len = len;
		}
		
		public int compareTo(Pair o) {
			return this.len-o.len;
		}
	}
	
	public static int[][] kClosest(int[][] points, int k){
		if(points.length == k && k == 1) {
			int[][] res = new int[k][2];
			res[0] = points[0];
			return res;
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<k ; i++) {
			int len = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
			pq.add(new Pair(points[i][0], points[i][1], len));
		}
        
        
		
		for(int i = k ; i<points.length; i++) {
			int len1 = ((points[i][0]*points[i][0]) + (points[i][1]*points[i][1]));
			int len2 = pq.peek().len;
			
			if(len1 < len2) {
				pq.remove();
				pq.add(new Pair(points[i][0], points[i][1], len1));
			}
		}
		
		int[][] res = new int[k][2];
		for(int i = 0; i<k; i++) {
			res[i][0] = pq.peek().x;
			res[i][1] = pq.remove().y;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
		int[][] res = kClosest(points, k);
		for(int i = 0; i<res.length ; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}
	}
}
