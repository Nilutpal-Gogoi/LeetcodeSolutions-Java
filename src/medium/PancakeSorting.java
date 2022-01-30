package medium;

import java.util.*;

public class PancakeSorting {
	
    public List<Integer> pancakeSort(int[] arr) {
        int len = arr.length;
        List<Integer> res = new ArrayList<>();
        for(int i = len-1; i>=0; i--){
            if(i+1 != arr[i]){
                int max = find(arr, i+1);
                res.add(max+1);
                flip(arr, max+1);
                res.add(i+1);
                flip(arr, i+1);
            }
        }
        return res;
    }
    
    // -- to find the value -------
    public int find(int[] arr, int num){
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return 0;
    }
    
    // --- to flip the array ------
    public void flip(int[] arr, int indx){
        int st = 0;
        int end = indx-1;
        while(st<end){
            int temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;
            st++;
            end--;
        }
    }

}
