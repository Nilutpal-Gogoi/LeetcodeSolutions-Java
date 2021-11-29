package medium;

public class RecoverBST {
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
	
	public void recover_Tree(TreeNode root, TreeNode[] pointers) {
		if(root == null) return;
		
		recover_Tree(root.left, pointers);
		if(pointers[0] == null) {
			// prev == null
			pointers[0] = root;
		} else {
			pointers[1] = root;
			if(pointers[0].val > pointers[1].val) {
				// prev > curr
				if(pointers[3] == null) {
					// first encounter
					pointers[2] = pointers[0];
					pointers[3] = pointers[1]; 
				} else {
					// second encounter
					pointers[3] = root;
				}
			}
			// move prev and current
			pointers[0] = root;
		}
		recover_Tree(root.right, pointers);
	}
	
    public void recoverTree(TreeNode root) {
    	TreeNode[] pointers = new TreeNode[4];
    	recover_Tree(root, pointers);
    	// swap value for a and b, i.e. pointers[2], pointers[3]
    	int temp = pointers[2].val;
    	pointers[2].val = pointers[3].val;
    	pointers[3].val = temp;
    }
}
