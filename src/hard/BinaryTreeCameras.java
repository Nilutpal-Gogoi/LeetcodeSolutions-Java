package hard;

public class BinaryTreeCameras {
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
	
	static int camera = 0;
	// state = 0 -> Camera present
	// state = 1 -> i'm cover
	// state = 2 -> i'm unsafe
	
	public int minCamera(TreeNode root) {
		if(root == null) return 1;
		
		int lstate = minCamera(root.left);
		int rstate = minCamera(root.right);
		if(lstate == 1 && rstate == 1) {
			return 2;
		} else if(lstate == 2 || rstate == 2) {
			camera++;
			return 0;
		} else {
			return 1;
		}
	}
	
	public int minCameraCover(TreeNode root) {
		camera = 0;
		int state = minCamera(root);
		if(state == 2) camera++;
		
		return camera;
	}
}
