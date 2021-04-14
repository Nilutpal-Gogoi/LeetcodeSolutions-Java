package Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> solution = spiralOrder(matrix);
        System.out.println(solution);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length;
        int column = matrix[0].length;
        int top = 0, bottom = rows-1, left = 0, right = column-1;
        int index = 0;
        List<Integer> result = new ArrayList<>();
        while((rows*column)>index){
            if(top>bottom)
                break;
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
                index++;
            }
            top++;

            if(left>right)
                break;
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
                index++;
            }
            right--;

            if(top>bottom)
                break;
            for(int i=right;i>=left;i--){
                result.add(matrix[bottom][i]);
                index++;
            }
            bottom--;

            if(left>right)
                break;
            for(int i=bottom;i>=top;i--){
                result.add(matrix[i][left]);
                index++;
            }
            left++;
        }
        return result;
    }
}


