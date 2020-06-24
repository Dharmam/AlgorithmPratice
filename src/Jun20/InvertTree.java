package Jun20;

import utils.TreeNode;

public class InvertTree {

	public static void main(String[] args) {

	}
	
	 TreeNode inOrder(TreeNode node){
	        if(node == null)return null;
	        
	        TreeNode left = inOrder(node.left);
	        TreeNode right = inOrder(node.right);
	        
	        node.right = left;
	        node.left = right;
	        
	        return node;

	    }
}
