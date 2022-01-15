package hard;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
        	List<Integer> indices = map.getOrDefault(arr[i], new ArrayList<>());
        	indices.add(i);
        	map.put(arr[i], indices);
        }
        
        boolean[] vis = new boolean[arr.length];
        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(0);
        int level = 0;
        while(qu.size() != 0) {
        	int size = qu.size();
        	while(size-- > 0) {
        		Integer rem = qu.remove();
        		if(rem == arr.length-1) {
        			return level;
        		}
                
                if(rem < 0 || rem >= arr.length || vis[rem] == true){
                    continue;
                }
                if(rem-1 > 0 && !vis[rem-1]){
                    qu.add(rem-1);
                }
                if(rem+1 < arr.length && !vis[rem+1]){
                    qu.add(rem+1);
                }
                if(map.containsKey(arr[rem])){
                    for(int i : map.get(arr[rem])){
                        if(i >= 0 && i < arr.length && !vis[i]){
                            qu.add(i);
                        }
                    }
                    map.remove(arr[rem]);
                }
                vis[rem] = true;
        	}
        	level++;
        }
        return -1; 
    }
}
