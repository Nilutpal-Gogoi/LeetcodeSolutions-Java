package easy;

import java.util.*;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        int[][] pair= new int[len][2];
        for(int i = 0 ; i<len; i++){
            pair[i][0] = score[i];
            pair[i][1] = i;
        }
        Arrays.sort(pair, (a,b) -> (b[0]-a[0]));
        String[] result = new String[len];
        for(int i = 0 ; i<len; i++){
            if(i==0){
                result[pair[i][1]] = "Gold Medal";
            }else if(i == 1){
                result[pair[i][1]] = "Silver Medal";
            }else if(i == 2){
                result[pair[i][1]] = "Bronze Medal";
            }else{
                result[pair[i][1]] = (i+1) + "";
            }
        }
        return result;
    }
}
