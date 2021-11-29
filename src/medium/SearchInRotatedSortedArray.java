package medium;

public class SearchInRotatedSortedArray {
    public int search(int[] arr, int target) {
        int lo = 0;
    	int hi = arr.length-1;
    	
    	while(lo <= hi) {
    		int mid = (lo+hi)/2;
    		
    		if(arr[mid] == target) {
    			return mid;
    		} else if(arr[lo] <= arr[mid]) {
    			if(target >= arr[lo] && arr[mid] > target) {
    				hi = mid-1;
    			} else {
    				lo = mid + 1;
    			}
    		} else if(arr[mid] <= arr[hi]) {
    			if(target > arr[mid] && arr[hi] >= target) {
    				lo = mid+1;
    			} else {
    				hi = mid-1;
    			}
    		}
    	}
    	
    	return -1;
    }
}
