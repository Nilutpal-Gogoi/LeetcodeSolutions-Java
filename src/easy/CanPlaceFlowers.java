package easy;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for(int i = 0; i<flowerbed.length && res < n; i++){
            int x = i-1 >= 0 ? flowerbed[i-1] : 0;
            int y = i+1 < flowerbed.length ? flowerbed[i+1] : 0;
            if(flowerbed[i] == 0 && x == 0 && y == 0){
                flowerbed[i] = 1;
                res++;
            }
        }
        return n <= res;
    }
}
