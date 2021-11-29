package medium;

import java.util.*;



public class FindCelebrity {
	public boolean knows(int i, int j) {
		// defined in question
		return true;     
	}
	public int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
    	for(int i = 0 ; i< n; i++) {
    		st.push(i);
    	}

        int candidate = -1;
    	// elimination
    	while(st.size() > 1) {
            int i = st.pop();
            int j = st.pop();
    		if(knows(i, j)) {
    			// i is not celebrity
    			st.push(j);
    		} else {
    			// j is not celebrity
    			st.push(i);
    		}
    	}
    	
    	candidate = st.pop();
    	
    	// check row and column
    	// check row
    	for(int i = 0; i<n; i++) {
    		if(knows(candidate, i)) {
    			System.out.println("none");
    			return -1;
    		}
    	}
    	
    	// check column
    	for(int i = 0 ; i<n; i++) {
    		if(i != candidate && !knows(i, candidate)) {
    			System.out.println("none");
    			return -1;
    		}
    	}
    	
    	return candidate;
    }
}
