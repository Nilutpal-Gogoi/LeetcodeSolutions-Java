package hard;

public class MaxChunkToMakeSortedII {
//	public int mini(int[] arr, int start, int end) {
//		int min = Integer.MAX_VALUE;
//		for(int i=start; i<=end; i++) {
//			if(arr[i]<min) {
//				min = arr[i];
//			}
//		}
//		return min;
//	}
//	
//	public int maxi(int[] arr, int start, int end) {
//		int max = Integer.MIN_VALUE;
//		for(int i=start; i<=end; i++) {
//			if(arr[i]>max) {
//				max = arr[i];
//			}
//		}
//		return max;
//	}
//	
//    public int maxChunksToSorted(int[] arr) {
//    	int chunk = 0;
//    	int max = 0;
//    	int min = Integer.MAX_VALUE;
//    	for(int i =0; i<arr.length; i++) {
//    		max = maxi(arr, 0, i);
//    		min = mini(arr, i+1, arr.length-1);
//    		if(min>max) {
//    			chunk++;
//    		}
//    	}
//    	return chunk;
//    }
	
	
	public int maxChunksToSorted(int[] arr) {
		int n = arr.length;
		int[] rightMin = new int[n+1];
		rightMin[n] = Integer.MAX_VALUE;
		
		int chunks = 0;
		
		// prepare right min
		for(int i=n-1; i>=0; i--) {
			rightMin[i] = Math.min(rightMin[i+1], arr[i]);
		}
		
		// solve count of using a leftmax variable
		int leftmax = Integer.MIN_VALUE;
		
		for(int i = 0; i<n; i++) {
			leftmax = Math.max(leftmax, arr[i]);
			if(leftmax <= rightMin[i+1]) {
				chunks++;
			}
		}
		
		return chunks;
	}
}
