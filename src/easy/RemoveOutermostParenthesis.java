package easy;

public class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String s) {
    	StringBuilder str = new StringBuilder();
    	
    	int op = 0;
    	int cl = 0;
    	int si = 0;
    	for(int i = 0; i<s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			op++;
    		}else {
    			cl++;
    		}
    		
    		if(op == cl) {
    			for(int j = si+1; j<i; j++) {
    				str.append(s.charAt(j));
    			}
    			op = 0;
    			cl = 0;
    			si = i+1;
    		}
    	}
    	
    	return str.toString();
    }
}
