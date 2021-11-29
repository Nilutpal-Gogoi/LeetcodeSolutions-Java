package medium;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int chunk = 0;
        int temp = 0;
        for(int i=0; i<arr.length; i++) {
        	temp = Math.max(temp, arr[i]);
        	if(temp == i) {
        		chunk++;
        	}
        }
        
        return chunk;
    }
}
