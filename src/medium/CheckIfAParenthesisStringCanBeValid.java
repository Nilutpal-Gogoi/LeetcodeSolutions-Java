package medium;

import java.util.*;

public class CheckIfAParenthesisStringCanBeValid {
	static class Pair{
		char ch;
		char indx;
		
		Pair(char ch, char indx){
			this.ch = ch;
			this.indx = indx;
		}
	}
	
    public static boolean canBeValid(String s, String locked) {
        Stack<Pair> st = new Stack<>();
        
        if(s.length() == 1) {
        	return false;
        }
        
        for(int i = 0; i<s.length(); i++) {
        	char par = s.charAt(i);
        	System.out.print(par + " -> "+ locked.charAt(i) + "  ");
        	if(par == '(') {
    			System.out.println(" D");
        		st.push(new Pair(par, locked.charAt(i)));
        	}else {
        		if(st.size() > 0 && st.peek().ch == '(') {
        			System.out.println(" A");
        			st.pop();
        			continue;
        		}else if(st.size() > 0 && st.peek().ch == ')' && st.peek().indx == '0') {
        			System.out.println(" B");
        			st.pop();
        			continue;
        		}else {
        			System.out.println(" c");
        			st.push(new Pair(par, locked.charAt(i)));
        		}
        	}
        }
        
        
        
        if(st.size() > 0) {
        	return false;
        }
        return true;
        
    }
    
    public static void main(String[] args) {
    	String s = "))()))";
    	String locked = "010100";
    	System.out.println(canBeValid(s, locked));
    }
}
