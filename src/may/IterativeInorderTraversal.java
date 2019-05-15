package may;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.TreeNode;

public class IterativeInorderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.right = new TreeNode(7);
		connect(root);
	}

	public static TreeNode connect(TreeNode root) {

		if (root == null)
			return null;
		else {
			Queue<TreeNode> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				System.out.println("####### Level change...");
				for (int i = 0; i < size; i++) {
					TreeNode temp = queue.poll();
					System.out.println("Pop -> " + temp.val);
					if (i < size-1) {
						temp.next = queue.size() == 0 ? null : queue.peek();
						System.out.println(" Node : " + temp.val + " next : " + temp.next.val);
					}

					if (temp.left != null)
						queue.offer(temp.left);
					if (temp.right != null)
						queue.offer(temp.right);
				}
			}
		}

		return root;

	}

	public static List<Integer> inorderTraversal(TreeNode node) {
		if (node == null)
			return new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = node;

		while (cur != null || !stack.empty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			list.add(cur.val);
			cur = cur.right;
		}

		return list;
	}

}
