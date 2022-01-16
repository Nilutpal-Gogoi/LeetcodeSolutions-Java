package easy;

public class CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for(int i = 0; i<arr.length-2; i++){
            for(int j = i+1; j<arr.length-1; j++){
                int ai = Math.abs(arr[i]-arr[j]);
                if(ai <= a){
                    for(int k = j+1; k<arr.length; k++){
                        int bi = Math.abs(arr[j]-arr[k]);
                        int ci = Math.abs(arr[i]-arr[k]);
                        if(bi <= b && ci <= c){
                            count++;
                        }else{
                            continue;
                        }
                    }
                }else{
                    continue;
                }
            }
        }
        return count;
    }
}
