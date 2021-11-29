package medium;

import java.util.Arrays;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n];   // duplicate array
		
		for(int i=0; i<n; i++) {
			arr[i] = nums[i];
		}
		
		Arrays.sort(arr);
		
		int j = n-1;
		int i =1;
		
		// fill odd index
		while(i<n) {
			nums[i] = arr[j];
			j--;
			i += 2;
		}
		
		// fill even index
		i = 0;
		while(i < n) {
			nums[i] = arr[j];
			j--;
			i+=2;
		}
	}
}
