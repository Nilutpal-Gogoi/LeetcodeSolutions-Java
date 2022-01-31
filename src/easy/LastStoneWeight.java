package easy;

import java.util.*;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        while(pq.size() > 1){
            int y = pq.remove();
            int x = pq.remove();
            if(x == y){
                continue;
            }else{
                pq.add(y-x);
            }
        }
        if(pq.size() == 0) return 0;
        return pq.peek() == 0 ? 0 : pq.remove();
    }
}
