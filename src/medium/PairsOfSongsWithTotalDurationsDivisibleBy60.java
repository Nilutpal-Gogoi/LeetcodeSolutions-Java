package medium;

import java.util.*;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {

//	--------- Approach 1 : Brute Force || O(n2) -------------------------
	
	public int numPairsDivisibleBy60_1(int[] time) {
        int sum = 0;
        for(int i = 0; i<time.length; i++) {
        	for(int j = i+1; j<time.length; j++) {
        		int r = time[i]+time[j];
        		if(r%60 == 0) {
        			sum++;
        		}
        	}
        }
        
        return sum;
    }
	
//	----------- Approach 2 : Optimized Approach || Two Sum || O(n) -------------------------
	public int numPairsDivisibleBy60(int[] time) {
        int sum = 0;
        int[] arr = new int[60];
        for(int i : time){
            int rem = i%60;
            arr[rem]++;
        }
        
        for(int i = 1 ; i<30 ; i++){
            sum += (arr[i] * arr[60-i]);
        }
        
        if(arr[0] > 0){
            sum += ((arr[0] * (arr[0]-1))/2);
        }
        
        if(arr[30] > 0){
            sum += ((arr[30] * (arr[30]-1))/2);
        }
        return sum;
	}
}
