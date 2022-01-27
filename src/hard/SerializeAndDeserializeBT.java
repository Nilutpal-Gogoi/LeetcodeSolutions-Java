package hard;

import java.util.Stack;

public class SerializeAndDeserializeBT {
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
	 
	 // SERIALIZE -> Encodes a tree to a single string
	 public void serialize_(TreeNode root, StringBuilder sb) {
		 if(root == null) {
			 sb.append("null#");
			 return;
		 }
		 
		 sb.append(root.val + "#");
		 serialize_(root.left, sb);
		 serialize_(root.right, sb);
	 }
	 
	 public String serialize(TreeNode root) {
		 StringBuilder sb = new StringBuilder();
		 serialize_(root, sb);
		 return sb.toString();
	 }
	 
	 // DESERIALIZE -> Encodes a single string to tree
	 
	 public class SPair{
		 TreeNode node;
		 int state;
		 
		 public SPair(TreeNode node, int state) {
			 this.node = node;
			 this.state = state;
		 }
	 }
	 
	 public TreeNode deserialize(String str) {
		 if(str.equals("null#")) return null;
		 String[] data = str.split("#");
		 int indx = 1;
		 TreeNode root = new TreeNode(Integer.parseInt(data[0]));
		 
		 Stack<SPair> st = new Stack<>();
		 st.push(new SPair(root, 0));
		 
		 while(indx < data.length) {
			 if(st.peek().state == 0) {
				 if(data[indx].equals("null") == true) {
					 st.peek().state++;
					 indx++;
				 } else {
					 TreeNode nn = new TreeNode(Integer.parseInt(data[indx])); 
					 indx++;
					 st.peek().state++;
					 st.peek().node.left = nn;
					 st.push(new SPair(nn, 0));
				 }
			 } else if(st.peek().state == 1) {
				 if(data[indx].equals("null") == true) {
					 st.peek().state++;
					 indx++;
				 } else {
					 TreeNode nn = new TreeNode(Integer.parseInt(data[indx])); 
					 indx++;
					 st.peek().state++;
					 st.peek().node.right = nn;
					 st.push(new SPair(nn, 0));
				 }
			 } else {
				 st.pop();
			 }
		 }
		 
		 return root;
	 }
}
