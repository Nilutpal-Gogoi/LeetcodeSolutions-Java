package medium;

import java.util.*;

public class DecodeString {
    public static String decodeString(String s) {
    	Stack<Integer> vstack = new Stack<>();
    	Stack<String> temp = new Stack<>();
    	String res = "";
    	
        int indx = 0;
        while( indx < s.length()){
            if(Character.isDigit(s.charAt(indx))) {
            	int count = 0;
            	while(Character.isDigit(s.charAt(indx))){
            		count = count*10 + (s.charAt(indx)-'0');
            		indx++;
            	}
            	vstack.push(count);
            }else if(s.charAt(indx) == '[') {
            	temp.push(res);
            	res = "";
            	indx++;
            }else if(s.charAt(indx) == ']') {
            	StringBuilder str = new StringBuilder(temp.pop());
            	int count = vstack.pop();
            	for(int i = 0 ; i<count; i++) {
            		str.append(res);
            	}
            	res = str.toString();
            	indx++;
            }else {
            	res += s.charAt(indx);
            	indx++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	String s = "3[a]12[c]";
    	System.out.println(decodeString(s));
    }
}
