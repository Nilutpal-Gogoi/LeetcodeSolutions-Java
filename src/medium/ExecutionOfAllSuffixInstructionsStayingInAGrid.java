package medium;

public class ExecutionOfAllSuffixInstructionsStayingInAGrid {
	
	public int[] executeInstructions(int n, int[] startPos, String s) {
		int[] res = new int[s.length()];
		for(int i=0; i<s.length(); i++) {
			res[i] = travelMatrix(n, startPos, i, s);
		}
		return res;
	}
	
	public int travelMatrix(int n, int[] startPos, int i, String s) {
		int count = 0;
		
		int row = startPos[0];
		int col = startPos[1];
		while(row >= 0 && row < n && col >= 0 && col < n && i<s.length()) {
            if(s.charAt(i) == 'R') {
                if(col+1<n){
                    count++;
                    col++;
                    i++;
                }else{
                    break;
                }
			}else if(s.charAt(i) == 'D') {
                if(row + 1 < n){
                    count++;
                    row++;
                    i++;
                }else{
                    break;
                }
			}else if(s.charAt(i) == 'L') {
                if(col - 1 >= 0){
                    count++;
                    col--;
                    i++;
                }else{
                    break;
                }
			}else{
                if(row-1>=0){
                    count++;
                    row--;
                    i++;
                }else{
                    break;
                }
			}
		}
		
		return count;
	}
}
