package medium;

import java.util.*;

public class CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
        int[] trip = new int[1001];
		for(int i = 0; i<trips.length; i++) {
            trip[trips[i][1]] += trips[i][0];
            trip[trips[i][2]] -= trips[i][0];
		}
		
		int prefixSum = 0;
		for(int i = 0; i<trip.length; i++) {
			prefixSum += trip[i];
            if(prefixSum > capacity) return false;
		}
		
		return true;
	}
	

}
