package medium;

public class NumberOfProvinces {
	private void connectedComp(int[][] graph, int src, boolean[] vis) {
		vis[src] = true;
		for(int nbr = 0; nbr < graph.length; nbr++) {
			if(graph[src][nbr] == 1 && vis[nbr]==false) {
				connectedComp(graph, nbr, vis);
			}
		}
	}
	
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		boolean[] vis = new boolean[n];
		
		int count = 0;
		for(int v=0; v<n; v++) {
			if(vis[v] == false) {
				count++;
				connectedComp(isConnected, v, vis);
			}
		}
		return count;
	}
}
