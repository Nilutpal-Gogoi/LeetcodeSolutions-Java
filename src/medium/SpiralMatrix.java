package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> solution = spiralOrder(matrix);
        System.out.println(solution);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rmin = 0;
        int cmin = 0;
        int rmax = matrix.length-1;
        int cmax = matrix[0].length-1;
        
        int tele = matrix.length*matrix[0].length;
        
        while(tele>0){
//             top wall 
            for(int i=cmin; i<=cmax && tele>0; i++){
                res.add(matrix[rmin][i]);
                tele--;
            }
            rmin++;
            
//             right wall
            for(int i=rmin; i<=rmax && tele>0; i++){
                res.add(matrix[i][cmax]);
                tele--;
            }
            cmax--;
            
//             bottom wall
            for(int i = cmax; i>=cmin && tele>0; i--){
                res.add(matrix[rmax][i]);
                tele--;
            }
            rmax--;
            
//             left wall 
            for(int i = rmax; i>=rmin && tele>0; i--){
                res.add(matrix[i][cmin]);
                tele--;
            }
            cmin++;
        }
        return res;
    }
}


