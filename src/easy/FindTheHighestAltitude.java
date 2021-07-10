package easy;

public class FindTheHighestAltitude {
    public static void main(String[] args){
        int[] arr = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(arr));
    }
    public static int largestAltitude(int[] gain){
        int[] arr = new int[gain.length+1];
        arr[0] = 0;
        int max = 0;
        for(int i=1;i<gain.length+1;i++){
            arr[i] = arr[i-1]+gain[i-1];
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
}
