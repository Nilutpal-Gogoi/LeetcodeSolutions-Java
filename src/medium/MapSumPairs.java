package medium;

import java.util.HashMap;


public class MapSumPairs {
	private class Node{
		Node[] children;
		int impact;
		
		Node(){
			this.children = new Node[26];
			this.impact = 0;
		}
	}
	
	private HashMap<String, Integer> map;
	private Node root;
	
	public MapSumPairs() {
		root = new Node();
		map = new HashMap<>();
	}
	
	public void insert(String key, int val) {
		int oval = map.getOrDefault(key,  0);
		int nval = val;
		int impact = nval - oval;
		map.put(key,  val);
		
		Node ptr = root;
		
		for(int i = 0; i<key.length(); i++) {
			char ch = key.charAt(i);
			if(ptr.children[ch-'a'] == null) {
				ptr.children[ch-'a'] = new Node();
			}
			ptr = ptr.children[ch-'a'];
			ptr.impact += impact;
		}
	}
	
	public int sum(String prefix) {
		Node ptr = root;
		
		for(int i = 0; i<prefix.length(); i++) {
			char ch = prefix.charAt(i);
			if(ptr.children[ch-'a'] == null) {
				return 0;
			}
			ptr = ptr.children[ch-'a'];
		}
		return ptr.impact;
	}
}
