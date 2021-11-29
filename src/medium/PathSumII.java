package medium;

import java.util.*;

public class PathSumII {
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
	
	public void pathSum(TreeNode root, int targetSum, int ssf, List<Integer> psf, List<List<Integer>> res) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			if(ssf+root.val == targetSum) {
				// create a duplicate
				List<Integer> duplicate = new ArrayList<>();
				for(int val:psf) {
					duplicate.add(val);
				}
				// insert root.val in duplicate
				duplicate.add(root.val);
				// add duplicate in res
				res.add(duplicate);
			}
		}
		
		psf.add(root.val);
		
		pathSum(root.left, targetSum, ssf+root.val, psf,res);
		pathSum(root.right, targetSum, ssf+root.val, psf,res);
		
		psf.remove(psf.size() -1);
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int targetSum){
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subres = new ArrayList<>();
		
		pathSum(root, targetSum, 0, subres, res);
		
		return res;
	}
}
