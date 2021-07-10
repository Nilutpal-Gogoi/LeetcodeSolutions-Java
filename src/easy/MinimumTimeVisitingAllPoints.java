package easy;

//import java.util.*;
//import java.lang.Math;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args){
        int[][] arr = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.println(minTimeToVisitAllPoints(arr));
    }
    public static int minTimeToVisitAllPoints(int[][] points){
        int sum = 0, x_max = 0, y_max = 0, max = 0;
        int len1 = points.length;
        for(int i=1;i<len1;i++){
            x_max = Math.abs(points[i][0] - points[i-1][0]);
            y_max = Math.abs(points[i][1] - points[i-1][1]);
            max = (x_max > y_max) ? x_max : y_max;
            sum += max;
        }
        return sum;
    }
}
