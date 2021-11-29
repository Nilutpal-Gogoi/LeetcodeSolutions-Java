package hard;

public class StreamOfCharacters {
	private class Node{
		Node[] children;
		boolean isEnd;
		
		Node(){
			this.children = new Node[26];
			this.isEnd = false;
		}
	}
	
	public void insert(Node node, String word) {
		for(int i=word.length()-1; i>=0; i--) {
			char ch = word.charAt(i);
			if(node.children[ch-'a'] == null) {
				node.children[ch-'a'] = new Node();
			}
			node = node.children[ch-'a'];
		}
		node.isEnd = true;
	}
	
	public Node root;
	public StringBuilder stream;
	
	public StreamOfCharacters(String[] words) {
		root = new Node();
		stream = new StringBuilder();
		for(String word:words) {
			insert(root, word);
		}
	}
	
	private boolean find() {
		Node temp = root;
		for(int i = stream.length()-1; i>=0; i--) {
			char ch = stream.charAt(i);
			if(temp.children[ch-'a'] == null) {
				return false;
			}
			temp = temp.children[ch-'a'];
			if(temp.isEnd) {
				return true;
			}
		}
		return false;
	}
	
	public boolean query(char letter) {
		stream.append(letter);
		return find();
	}
}
