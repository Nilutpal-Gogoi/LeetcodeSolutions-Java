package medium;

import java.util.*;

public class MinimumNoOfArrowsToBurstBalloons {
	  class Pair implements Comparable<Pair>{
	        int st;
	        int end;
	        
	        Pair(int st, int end){
	            this.st = st;
	            this.end = end;
	        }
	        
	        public int compareTo(Pair o){
	            return this.st-o.st;
	        }
	    }
	    public int findMinArrowShots(int[][] points) {
	    	Pair[] list = new Pair[points.length];
	        for(int i = 0; i<points.length ; i++){
	            list[i] = new Pair(points[i][0], points[i][1]);
	        }
	        
	        Arrays.sort(list);
	        
	        Stack<Pair> st = new Stack<>();
	        for(Pair i : list) {
	        	if(st.size() == 0) {
	        		st.push(i);
	        	}else {
	        		int nst = i.st;
	        		int nend = i.end;
	        		int oend = st.peek().end;
	        		if(nst < oend) {
	        			if(nend > oend) {
	        				st.peek().end = nend;
	        			}
	        		}else {
	        			st.push(i);
	        		}
	        	}
	        }
	        return st.size();
	    }
}
