package easy;

public class FindPivotIndex {
    public static void main(String[] args){
        int[] array = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findPivotIndex(array));
    }

    public static int findPivotIndex(int[] array){
        int sum = 0;
        int leftSum = 0;
        for(int i = 0;i<array.length;i++){
            sum += array[i];
        }
        for(int i=0;i<array.length;i++){
            sum -= array[i];
            if(leftSum == sum){
                return i;
            }
            leftSum += array[i];
        }
        return -1;
    }
}
