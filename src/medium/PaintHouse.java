package medium;

public class PaintHouse {
	/////// ------ recursive approach ----------------
    public static int minCost1(int[][] costs) {
    	int res = Integer.MAX_VALUE;
    	for(int i = 0; i<costs[0].length; i++) {
    		res = Math.min(minCostRec(costs, i, 0), res);
    	}
    	return res;
    }
    
    public static int minCostRec(int[][] cost, int lastCol, int indx) {
    	if(indx == cost.length) {
//    		return cost[indx-1][lastCol];
    		return 0;
    	}
    	
    	int i = indx;
    	int res = Integer.MAX_VALUE;
    	for(int j = 0; j < cost[i].length; j++) {
    		if(j != lastCol) {
    			res = Math.min(minCostRec(cost, j, indx+1), res);
    		}
    	}
    	
    	return res+cost[indx][lastCol];
    }
    
    public static int minCost(int[][] costs) {
    	int red = 0;
    	int blue = 0;
    	int green = 0;
    	
    	for(int i = 0; i<costs.length; i++) {
			int n_red = Math.min(blue, green);
			int n_blue = Math.min(red, green);
			int n_green = Math.min(blue, red);
			
			red = n_red+costs[i][0];
			blue = n_blue+costs[i][1];
			green = n_green+costs[i][2];
    	}
    	
    	return Math.min(red, Math.min(green, blue));
    }
    
    public static void main(String[] args) {
    	int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
    	System.out.println(minCost(costs));
    }
}
