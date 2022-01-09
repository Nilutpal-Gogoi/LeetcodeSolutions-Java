package medium;

import java.util.*;

public class BasicCalculatorII {
    public int priority(char ch){
        if(ch == '*' || ch == '/'){
            return 2;
        }else{
            return 1;
        }
    }
    
    public int calc(int val1, int val2, char op){
        if(op == '+'){
            return val1+val2;
        }else if(op == '-'){
            return val1-val2;
        }else if(op == '*'){
            return val1*val2;
        }else {
            return val1/val2;
        }
    }
    
    public int calculate(String s) {
        Stack<Character> ostack = new Stack<>();
        Stack<Integer> res = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' '){
                continue;
            }else if(ch >= '0' && ch <= '9' ){
				StringBuilder n = new StringBuilder();
				while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					n.append(s.charAt(i));
					i++;
				}
				i--;
				int val = Integer.parseInt(n.toString());
                res.push(val);
            }else{
                while(ostack.size() > 0 && priority(ostack.peek()) >= priority(ch)){
                    int val2 = res.pop();
                    int val1= res.pop();
                    char op = ostack.pop();
                    
                    int val = calc(val1, val2, op);
                    res.push(val);
                }
                ostack.push(ch);
            }
        }
        
        while(ostack.size() > 0){
            int val2 = res.pop();
            int val1= res.pop();
            char op = ostack.pop();
            
            int val = calc(val1, val2, op);
            res.push(val);
        }

        
        return res.pop();
    }
}
