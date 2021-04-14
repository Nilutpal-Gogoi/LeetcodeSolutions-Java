package Easy;

import java.util.Arrays;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args){
        int[] input = {17,18,5,4,6,1};
        System.out.println(replaceElements(input));
    }
//    public static int[] replaceElements(int[] arr) {
//        int[] new_arr = new int[arr.length];
//        for(int i=0;i<arr.length;i++){
//            if(i==arr.length-1){
//                new_arr[i] = -1;
//            }
//            int[] subArr = Arrays.copyOfRange(arr, i+1, arr.length);
//            new_arr[i] = max(subArr);
//        }
//        return new_arr;
//    }
//    public static int max(int[] arr){
//        int max = Integer.MIN_VALUE;
//        for (int j : arr) {
//            if (j > max)
//                max = j;
//        }
//        return max;
//    }
    public static int[] replaceElements(int[] arr){
        int max = -1;
        for(int i=arr.length-1; i>=0; i--){
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}

