package easy;

import java.util.*;

public class MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsoluteDifference(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(arr);
        
        for(int i = 0; i<arr.length-1; i++){
            min = Math.min(min, arr[i+1]-arr[i]);
        }
        
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] + min == arr[i+1]){
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        
        return res;
	}
}
