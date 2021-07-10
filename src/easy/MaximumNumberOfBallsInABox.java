//https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

package easy;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBallsInABox {
    public static void main(String[] args){
        System.out.println(countBalls(79,9218));
    }
    public static int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=lowLimit; i<=highLimit; i++){
            int d = sum(i);
            map.put(d, map.getOrDefault(d,0)+1);
            res = Math.max(res, map.get(d));
        }
        return res;
    }
    public static int sum(int n){
        int x = 0;
        while(n>0){
            x += n%10;
            n = n/10;
        }
        return x;
    }
}
