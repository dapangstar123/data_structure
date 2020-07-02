package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * @author pang
 *
 */
public class TreeMinDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node3);
		node2.setRight(node4);

		System.out.println(minDepth(root));
	}

	/**
	 * 二叉树的最小深度 与最大深度不同，如果左子树为空，则直接求右子树的最小深度
	 * 
	 * @param root
	 * @return
	 */
	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null) {
			return 1;
		}
		if (root.getLeft() == null) {
			return minDepth(root.getRight()) + 1;
		}
		if (root.getRight() == null) {
			return minDepth(root.getLeft()) + 1;
		}
		return Math.min(minDepth(root.getLeft()) + 1, minDepth(root.getRight()) + 1);
	}
}
