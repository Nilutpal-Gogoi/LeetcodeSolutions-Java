package hard;

import java.util.*;

public class RedundantConnectionII {

	private static int[] parent;
	private static int[] rank;
	
	private int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}
	
	private boolean union(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		
		if(lx == ly) {
			return true;
		} else {
			if(rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if(rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[ly] = lx;
				rank[lx]++;
			}
		}
		
		return false;
	}
	
	public int[] findRedundantDirectedConnection(int[][] edges) {
		int n = edges.length;
		int[] indegree = new int[n+1];   // because index in 1 based
		Arrays.fill(indegree, -1);
		
		int blackList1 = -1;
		int blackList2 = -1;
		
		for(int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			if(indegree[v] == -1) {
				indegree[v] = i;
			} else {
				blackList1 = i;
				blackList2 = indegree[v];
				break;
			}
		}
		
		parent = new int[n+1];
		rank = new int[n+1];
		for(int i = 0; i <= n ; i++) {
			parent[i] = i;
			rank[i] = 1;
		}
		
		// apply DSU and avoid blackList1 edge index, and check if graph is cyclic or not
		for(int i = 0; i < edges.length; i++) {
			if(i == blackList1) {
				continue;
			}
			int u = edges[i][0];
			int v = edges[i][1];
			
			boolean isCyclic = union(u, v);
			
			if(isCyclic == true) {
				if(blackList1 == -1) {
					return edges[i];
				} else {
					return edges[blackList2];
				}
			}
		}
		
		return edges[blackList1];
	}

}