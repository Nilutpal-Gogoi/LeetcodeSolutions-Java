package medium;

public class LongestWordDictionary {
	private class Node{
		Node[] children;
		String s;
		
		Node() {
			this.children = new Node[26];
		}
	}
	
	private void insert(Node root, String word) {
		for(int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(root.children[ch - 'a'] == null) {
				root.children[ch - 'a'] = new Node();
			}
			root = root.children[ch - 'a'];
		}
		root.s = word;
	}
	
	private String str;
	
	private void dfsTrie(Node node) {
		if(node.s == null) return;
		
		if(node.s.length() > str.length()) {
			str = node.s;
		}
		
		for(int i = 0; i<26; i++) {
			if(node.children[i] != null) {
				dfsTrie(node.children[i]);
			}
		}
	}
	
	public String longestWord(String[] words) {
		Node root = new Node();
		for(String word : words) {
			insert(root, word);
		}
		
		str = "";
		
		for(int i = 0; i<26; i++) {
			if(root.children[i] != null) {
				dfsTrie(root.children[i]);
			}
		}
		
		return str;
	}
}
