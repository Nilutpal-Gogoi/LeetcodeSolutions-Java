package medium;

import java.util.*;

public class NaryTreeLevelOrderTraversal {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public List<List<Integer>> levelOrder(Node root){
		List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> qu = new ArrayDeque<>();
		qu.add(root);
		while(qu.size() > 0) {
			List<Integer> temp = new ArrayList<>();
			int size = qu.size();
			while(size > 0) {
				Node rem = qu.remove();
				temp.add(rem.val);
				for(Node i : rem.children) {
					qu.add(i);
				}
				size--;
			}
			size = qu.size();
			res.add(temp);
		}
		
		return res;
	}
}
