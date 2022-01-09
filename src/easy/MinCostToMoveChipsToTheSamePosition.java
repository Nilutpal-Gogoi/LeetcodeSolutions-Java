package easy;

public class MinCostToMoveChipsToTheSamePosition {
	public static int minCostToMoveChips(int[] position) {
        int odd = 0;
        for(int i : position){
            if(i%2!=0){
                odd++;
            }
        }
        
        return Math.min(odd, position.length-odd);
	}
	
	public static void main(String[] args) {
		int[] position = {1,1000000000};
		int res = minCostToMoveChips(position);
		System.out.println(res);
	}
}
