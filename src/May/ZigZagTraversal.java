package may;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import utils.TreeNode;

public class ZigZagTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		zigzagLevelOrder(root);
	}

	static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			Stack<Integer> stack = null;
			if (count % 2 == 0)
				stack = new Stack<>();

			for (int i = 0; i < size; i++) {
				TreeNode node = null;
				node = queue.poll();

				if (node.right != null)
					queue.offer(node.right);
				if (node.left != null)
					queue.offer(node.left);
				if (count % 2 != 0)
					list.add(node.val);
				else
					stack.push(node.val);
			}

			if (count % 2 == 0) {
				while (!stack.isEmpty()) {
					list.add(stack.pop());
				}
			}

			result.add(list);
			count++;
		}

		return result;
	}
}
