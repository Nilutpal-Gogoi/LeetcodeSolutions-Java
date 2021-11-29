package hard;

import java.util.*;

public class BusRoutes {
	private void makeMapWithStandAndBus(int[][] routes, HashMap<Integer, ArrayList<Integer>> map) {
		
        for(int r = 0; r < routes.length; r++) {            // r -> bus number
        	for(int c = 0; c < routes[r].length; r++) {
        
        		int stand = routes[r][c];
        		
        		if(map.containsKey(stand) == true) {
        			// key is already present, so ust add value i.e. bus number with that bus stop
        			map.get(stand).add(r);
        		} else {
        			ArrayList<Integer> busNo = new ArrayList<>();
        			busNo.add(r);
        			map.put(stand, busNo);
        		}
        		
        	}
        }
        
	}
	
	public int numBusesToDestination(int[][] routes, int source, int target) {
    	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    	makeMapWithStandAndBus(routes, map);
    	
    	HashSet<Integer> visBus = new HashSet<>();
    	HashSet<Integer> visStand = new HashSet<>();
    	
    	Queue<Integer> qu = new LinkedList<>();
    	qu.add(source);
    	int level = -1;
    	
    	while(qu.size() > 0) {
    		
    		int size = qu.size();
    		level++;
    		
    		while(size-- > 0) {
    			int rem = qu.remove();
    			
    			if(rem == target) {
    				return level;
    			}
    			
    			for(int busNum : map.get(rem)) {
    				if(visBus.contains(busNum) == true) {
    					continue;
    				} else {
    					for(int busStand : routes[busNum]) {
    						if(visStand.contains(busStand) == false) {
    							visStand.add(busStand);
    							qu.add(busStand);
    						}
    					}
    					visBus.add(busNum);
    				}
    			}
    		}
    	}
    	
    	return -1;
    }
}
