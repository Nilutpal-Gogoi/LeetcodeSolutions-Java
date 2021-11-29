package medium;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] arr) {
    	int lo = 0;
    	int hi = arr.length-1;
    	
    	int res = Integer.MAX_VALUE;
    	while(lo <= hi) {
    		int mid = (lo+hi)/2;
    		if(arr[mid] < res) {
    			res = arr[mid];
    		} 
    		
    		if(arr[lo] <= arr[mid]) {
    			if(arr[mid] > arr[hi]) {
    				lo = mid+1;
    			} else {
    				hi = mid-1;
    			}
    		} else if(arr[mid] <= arr[hi]) {
    			if(arr[lo] > arr[mid]) {
    				hi = mid-1;
    			} else {
    				lo = mid + 1;
    			}
    		}
    	}
    	
    	return res;
    }
}
