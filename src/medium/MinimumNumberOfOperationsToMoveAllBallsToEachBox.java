package medium;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int ahead = 0;
        int behind = 0;
        int[] res = new int[boxes.length()];
        for(int i = 0;i<boxes.length();i++) {
        	if(boxes.charAt(i) == '1') {
        		ahead++;
        		res[0] += i;
        	}
        }
        
        if(boxes.charAt(0) == '1') {
        	ahead--;
        	behind++;
        }
        
        for(int i = 1; i<boxes.length();i++) {
        	res[i] = res[i-1]-ahead+behind;
        	if(boxes.charAt(i)=='1') {
        		ahead--;
        		behind++;
        	}
        }
        
        return res;
    }
}
