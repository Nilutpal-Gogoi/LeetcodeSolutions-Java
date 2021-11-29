package medium;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
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
	
	private ArrayList<TreeNode> nodeToRootPathNodeType(TreeNode node, TreeNode data){
		ArrayList<TreeNode> mres = new ArrayList<>();
		if(node == null) return mres;
		
		if(node == data) {
			mres.add(node);
			return mres;
		}
		
		ArrayList<TreeNode> lres = nodeToRootPathNodeType(node.left, data);
		if(lres.size() > 0) {
			lres.add(node);
			return lres;
		}
		ArrayList<TreeNode> rres = nodeToRootPathNodeType(node.right, data);
		if(rres.size() > 0) {
			rres.add(node);
			return rres;
		}
		
		return mres;
	}
	
	private void kdown(TreeNode node, TreeNode blockage, int k, List<Integer> res) {
		if(node == null || node == blockage) return;
		
		if(k == 0) {
			res.add(node.val);
			return;
		}
		
		kdown(node.left, blockage, k-1, res);
		kdown(node.right, blockage, k-1, res);
	}
	
	public List<Integer> distancek(TreeNode root, TreeNode target, int k){
		ArrayList<TreeNode> n2rpath = nodeToRootPathNodeType(root, target);
		
		List<Integer> res = new ArrayList<>();
		TreeNode blockage = null;
		for(int i=0; i<n2rpath.size() && k-i >= 0; i++) {
			TreeNode node = n2rpath.get(i);
			kdown(node, blockage, k-i, res);
			blockage = node;
		}
		return res;
	}
}
