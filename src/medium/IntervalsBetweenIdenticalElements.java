package medium;

import java.util.*;

public class IntervalsBetweenIdenticalElements {
    public static long[] getDistancesBruteForce(int[] arr) {
    	long[] res = new long[arr.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
        	if(!map.containsKey(arr[i])) {
        		map.put(arr[i], new ArrayList<>());
        	}
        	map.get(arr[i]).add(i);
        }
        
        System.out.println(map.size());
        
        for(int i = 0 ; i < arr.length; i++) {
        	int x = arr[i];											
        	long count = 0;
        	ArrayList<Integer> temp = map.get(arr[i]);
        	for(Integer indx : temp) {
        		if(indx != i) {
        			count += Math.abs(indx-i);
        		}
        	}
        	res[i] = count;
        }
        
        return res;
    }
    
//    public static long[] getDistances(int[] arr) {
//    	
//    }
    
    public static void main(String[] args) {
//    	int[] arr = {10,5,10,10};
//    	long[] res = getDistances(arr);
//    	System.out.println(Arrays.toString(res));
    }
}
