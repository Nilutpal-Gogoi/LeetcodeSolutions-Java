package medium;

import java.util.Stack;

public class MinimumNumberOfSwapsToMakeTheStringBalanced {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack();
    	int res = 0;
    	for(int i = 0; i<s.length(); i++) {
    		char ch = s.charAt(i);
    		if(st.size() > 0 && ch == ']' && st.peek() == '['){
    			st.pop();
    		} else {
    			st.push(ch);
    		}
    	}
    	
    	int pair = st.size() / 2;
        return (int)Math.ceil(pair/2.0) ;
    }
}
