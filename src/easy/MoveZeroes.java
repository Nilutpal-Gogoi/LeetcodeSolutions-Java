package easy;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args){
        int[] array = {1,9,8,4,0,0,2,7,0,6,0};
        solution(array);
        System.out.println(Arrays.toString(array));
    }

    public static void solution(int[] array){
        int i = 0;
        for(int j = i;j<array.length;j++){
            if(array[j] != 0){
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
            }
        }
    }
}
