package easy;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
    	int len = arr.length;
    	if(len == 0) {
    		return false;
    	}
    	int i = 1;
    	for( ; i<len; i++) {
    		if(arr[i-1]<arr[i]) {
    			
    		}else {
    			break;
    		}
    	}
    	
    	if(i == 1 || i == len) {
    		return false;
    	}
    	
    	for(; i<len; i++) {
    		if(arr[i-1]>arr[i]) {
    			
    		}else {
    			break;
    		}
    	}
    	
    	return i==len;
    }
}
