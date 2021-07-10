package easy;

public class TransposeOfAMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; 
		int[][] res = transpose(matrix);
		System.out.println(res);
	}
	
    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[m][n];
        int row = 0;
        int col = 0;
        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                res[row][col] = matrix[i][j];
                col++;
                if(col==n){
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }

}
