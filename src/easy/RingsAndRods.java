package easy;

import java.util.*;

public class RingsAndRods {
    public static int countPoints(String rings) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i<rings.length(); i+=2){
            char col = rings.charAt(i);
            int rodNo = rings.charAt(i+1)-'0';
            if(rodNo > max) max = rodNo;
            if(map.containsKey(col)){
                map.get(col).add(rodNo);
            }else{
                map.put(col, new HashSet<Integer>());
                map.get(col).add(rodNo);
            }
        }
        
        if(map.size() < 3) {
        	return 0;
        }
        
        int res = 0;
        for(int i = 0; i<=max; i++){
            int count = 0;
            count += map.get('R').contains(i) == true ? 1 : 0;
            count += map.get('B').contains(i) == true ? 1 : 0;
            count += map.get('G').contains(i) == true ? 1 : 0;
            
            if(count == 3) res++;
        
        }
        
        return res;
    }
    
    public static void main(String[] args) {
    	int res = countPoints("B9R9G0R4G6R8R2R9G9");
    	System.out.println(res);
    }
}
