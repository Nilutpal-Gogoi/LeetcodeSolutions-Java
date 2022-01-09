package easy;

import java.util.*;

public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree = new int[n+1];
        
        for(int i = 0; i< trust.length; i++) {
        	int out = trust[i][0];
        	int in = trust[i][1];
        	indegree[in]++;
        	outdegree[out]++;
        }
        
        for(int i = 1; i<n+1; i++) {
        	if(indegree[i] == n-1 && outdegree[i] == 0) {
        		return i;
        	}
        }
        return -1;
    }

}
