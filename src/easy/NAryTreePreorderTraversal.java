package easy;

import java.util.*;
import java.io.*;

public class NAryTreePreorderTraversal {
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
    public static List<Integer> preorder(Node root) {
        ArrayList<Integer> lst = new ArrayList<>();
        if(root == null){
            return lst;
        }
        ArrayList<Integer> res = preorderTree(root, lst);
        return res;
    }
    
    public static ArrayList<Integer> preorderTree(Node root, ArrayList<Integer> lst){
        lst.add(root.val);
        for(Node child:root.children){
            preorderTree(child, lst);
        }
        return lst;
    }
}
