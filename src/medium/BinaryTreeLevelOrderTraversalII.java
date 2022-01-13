package medium;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
	public static class TreeNode {
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> qu = new ArrayDeque<>();
        Stack<List<Integer>> temp = new Stack<>();
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
        	temp.add(list);
        }
        
        while(temp.size() != 0) {
        	res.add(temp.pop());
        }
        
        return res;
    }
}
