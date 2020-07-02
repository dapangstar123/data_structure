package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 
 * 本题中，一棵高度平衡二叉树定义为：
 * 
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 
 * @author pang
 *
 */
public class IsBalancedTree {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		// // 树1 平衡
		// node1.setLeft(node2);
		// node1.setRight(node3);
		// node3.setLeft(node4);
		// node3.setRight(node5);
		// System.out.println(isBalanced(node1));

		// 树2 不平衡
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node4.setLeft(node6);
		node4.setRight(node7);
		System.out.println(isBalanced(node1));

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return Math.abs(maxHeight(root.getLeft()) - maxHeight(root.getRight())) < 2 && isBalanced(root.getLeft())
				&& isBalanced(root.getRight());
	}

	/**
	 * 树的最大高度
	 * 
	 * @param root
	 * @return
	 */
	public static int maxHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftHeight = maxHeight(root.getLeft());
			int rightHeight = maxHeight(root.getRight());
			return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
		}

	}
}
