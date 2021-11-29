package easy;

public class ConstructStringFromBinaryTree {
	public class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	}
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder str = new StringBuilder();
        str.append(root.val);
        if(root.left != null && root.right != null) {
        	str.append("(");
        	fun(root.left, str);
        	str.append(")(");
        	fun(root.right, str);
        	str.append(")");
        } else if(root.left != null) {  
            str.append("(");
        	fun(root.left, str);
        	str.append(")");
        } else if(root.right != null){
        	str.append("()(");
        	fun(root.right, str);
        	str.append(")");
        }
        
        return str.toString();
    }
    
    private void fun(TreeNode root, StringBuilder str){
        str.append(root.val);
        if(root.left != null && root.right != null) {
        	str.append("(");
        	fun(root.left, str);
        	str.append(")(");
        	fun(root.right, str);
        	str.append(")");
        } else if(root.left != null) {  
            str.append("(");
        	fun(root.left, str);
        	str.append(")");
        } else if(root.right != null){
        	str.append("()(");
        	fun(root.right, str);
        	str.append(")");
        }
    }
}
