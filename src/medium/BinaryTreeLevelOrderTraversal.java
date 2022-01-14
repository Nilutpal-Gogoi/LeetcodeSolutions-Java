package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import medium.BinaryTreeLevelOrderTraversalII.TreeNode;

public class BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> qu = new ArrayDeque<>();
        qu.add(root);
        while(qu.size() != 0) {
            int size = qu.size();
        	List<Integer> list = new ArrayList<>();
        	while(size > 0) {
        		TreeNode rem = qu.remove();
        		list.add(rem.val);
        		if(rem.left != null)
        			qu.add(rem.left);
        		if(rem.right != null)
        			qu.add(rem.right);
        		size--;
        	}
        	res.add(list);
        }
        
        
        return res;
    }

}
