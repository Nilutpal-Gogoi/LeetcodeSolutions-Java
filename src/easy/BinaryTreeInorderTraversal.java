package easy;

import java.util.*;

public class BinaryTreeInorderTraversal {
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
	
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root != null){
            inOrder(root, res);   
        }
        return res;
    }
    
    public void inOrder(TreeNode root, ArrayList<Integer> res){
        
        if(root.left != null) {
            inOrder(root.left, res);
        }
        res.add(root.val);
        if(root.right != null){
            inOrder(root.right, res);
        }
    }
}
