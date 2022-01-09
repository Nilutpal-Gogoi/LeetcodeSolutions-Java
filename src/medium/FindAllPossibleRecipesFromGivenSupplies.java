package medium;

import java.util.*;

public class FindAllPossibleRecipesFromGivenSupplies {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i<ingredients.size(); i++) {
        	for(int j = 0; j<ingredients.get(i).size(); j++) {
        		if(!map.containsKey(ingredients.get(i).get(j))) {
        			map.put(ingredients.get(i).get(j), new ArrayList<String>());
        		}
        		map.get(ingredients.get(i).get(j)).add(recipes[i]);
        		int deg = indegree.getOrDefault(recipes[i], 0);
        		indegree.put(recipes[i], deg+1);
        	}
        }
        

        List<String> res = new ArrayList<>();
        Queue<String> qu = new ArrayDeque<>();
        for(int i = 0; i<supplies.length; i++) {
        	qu.add(supplies[i]);
        }
        
        
        while(qu.size() > 0) {
        	String rem = qu.remove();
            List<String> ch = map.get(rem);
            if(ch == null){
                continue;
            }
        	for(String str : ch) {
        		int deg = indegree.get(str);
        		indegree.put(str, deg-1);
        		if(indegree.get(str) == 0) {
        			qu.add(str);
                    res.add(str);
        		}
        	}
        }
        return res;
    } 

}