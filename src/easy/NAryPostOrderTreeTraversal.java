package easy;

import java.util.*;
import java.io.*;

public class NAryPostOrderTreeTraversal {
	public static class Node {
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
	
    public static List<Integer> postorder(Node root) {
        ArrayList<Integer> lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        postOrderTree(root, lst);
        return lst;
    }
    
    public static void postOrderTree(Node root, ArrayList<Integer> lst){
        for(Node child : root.children){
            postOrderTree(child, lst);
        }
        lst.add(root.val);
    }
}
