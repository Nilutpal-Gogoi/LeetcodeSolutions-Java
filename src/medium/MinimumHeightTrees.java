package medium;

import java.util.*;

public class MinimumHeightTrees {
	public ArrayList<Integer>[] construct(int n , int[][] edges) {
		ArrayList<Integer>[] graph = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<edges.length; i++) {
			int v1 = edges[i][0];
			int v2 = edges[i][1];
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		return graph;
	}
	
	public int findHeight(int n, ArrayList<Integer>[] graph, boolean[] vis) {
		int ht = -1;
		vis[n] = true;
		for(int i : graph[n]) {
			if(vis[i] == false) {
				ht = Math.max(findHeight(i, graph, vis), ht);
			}
		}
		vis[n] = false;
		return ht+1;
	}
	
	public List<Integer> findMinHeightTrees(int n, int[][] edges){
		ArrayList<Integer> res = new ArrayList<>();
		ArrayList<Integer>[] graph = construct(n, edges);
		
        if(n == 1){
            res.add(0);
            return res;
        }
        
        if(n == 2){
            res.add(edges[0][0]);
            res.add(edges[0][1]);
            return res;
        }
        
		boolean[] vis = new boolean[n];
		int minHeight = Integer.MAX_VALUE;
		for(int i = 0; i<n; i++) {
			int height = 0;
			height = findHeight(i, graph, vis);
			if(height < minHeight) {
				minHeight = height;
				res.clear();
				res.add(i);
			}else if(height == minHeight) {
				res.add(i);
			}
		}
		return res;
	}
	
	// ----------------- Optimized Approach ----------------------------------
	public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
	    if (n == 1) {
	    	ArrayList<Integer> arr = new ArrayList<>();
	    	arr.add(0);
	    	return arr;
	    }

	    List<Set<Integer>> adj = new ArrayList<>(n);
	    for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
	    for (int[] edge : edges) {
	        adj.get(edge[0]).add(edge[1]);
	        adj.get(edge[1]).add(edge[0]);
	    }

	    List<Integer> leaves = new ArrayList<>();
	    for (int i = 0; i < n; ++i)
	        if (adj.get(i).size() == 1) leaves.add(i);

	    while (n > 2) {
	        n -= leaves.size();
	        List<Integer> newLeaves = new ArrayList<>();
	        for (int i : leaves) {
	            int j = adj.get(i).iterator().next();
	            adj.get(j).remove(i);
	            if (adj.get(j).size() == 1) newLeaves.add(j);
	        }
	        leaves = newLeaves;
	    }
	    return leaves;
	}
}
