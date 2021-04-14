////https://leetcode.com/problems/lucky-numbers-in-a-matrix/
//
//package Easy;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class LuckyNumbersInAMatrix {
//    public static void main(String[] args){
////        int[][] matrix = {{3, 7, 8},{ 9, 11, 13 },{ 15, 16, 17 }};
//        int[][] matrix = {{1, 10, 4, 2},{ 9, 3, 8, 7 },{ 15, 16, 17, 12 }};
////        int[][] matrix = {{7,8},{1,2}};
//        System.out.println(luckyNumbers(matrix));
//    }
//    public static List<Integer> luckyNumbers(int[][] matrix){
//        List<Integer> R_min = new ArrayList<>();
//        List<Integer> C_max = new ArrayList<>();
//        List<Integer> arr = new ArrayList<>();
//        arr.add(-1);
//        int k = -1;
//        int row = matrix.length;
//        int column = matrix[0].length;
//        for(int i=0;i<row;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j=0;j<column;j++){
//                if(matrix[i][j]<min){
//                    min = matrix[i][j];
//                    k = j;
//                }
//            }
//            R_min.add(k);
//        }
//        for(int i=0;i<row;i++){
//            int max = Integer.MIN_VALUE;
//            for(int j=0;j<R_min.size();j++){
//                if()
//            }
//        }
//    }
//}
