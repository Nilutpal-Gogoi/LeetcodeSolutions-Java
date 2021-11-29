package easy;

import java.util.*;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        
        long val = 1;
        for(int r = 0; r <= rowIndex ; r++) {
        	res.add((int) val);
        	val =  val * (rowIndex-r)/(r+1);
        }
        	
        return res;
    }
}
