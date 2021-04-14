//https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
package Easy;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        int len = candies.length;
        List<Boolean> result=new ArrayList<Boolean>();
        for(int i=0;i<len;i++ ){
            if(candies[i]>max){
                max = candies[i];
            }
        }
        for(int i=0;i<len;i++){
            if(candies[i]+extraCandies >= max){
                result.add(true);
            }
            else
                result.add(false);
        }
        return result;
    }
}
