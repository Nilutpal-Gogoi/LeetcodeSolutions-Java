package easy;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double max = 0.0;
        for(int i = 0; i<points.length-2; i++){
            for(int j = i+1; j<points.length-1; j++){
                for(int k = j+1; k<points.length; k++){
                    double area = Math.abs(findArea(points[i], points[j], points[k]));
                    if( area > max){
                        max = area;
                    }
                }
            }
        }
        return max;
    }
    
    public double findArea(int[] x, int[] y, int[] z){
        return (x[0]*(y[1]-z[1])+y[0]*(z[1]-x[1])+z[0]*(x[1]-y[1]))/2.0;
    }
}
