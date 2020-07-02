package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * @author pang
 *
 */
public class IsSymmetricTree {

	public static void main(String[] args) {
		// 创建节点
		TreeNode root1 = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(3);

		root1.setLeft(node1);
		root1.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);

		System.out.println(isSymmetricTree(root1));

	}

	public static boolean isSymmetricTree(TreeNode root) {
		// 空树
		if (root == null) {
			return true;
		}
		return check(root.getLeft(), root.getRight());
	}

	// 递归调用
	public static boolean check(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null) {
			return true;
		}
		if (leftNode == null || rightNode == null) {
			return false;
		}
		return leftNode.getVal() == rightNode.getVal() && check(leftNode.getLeft(), rightNode.getRight())
				&& check(leftNode.getRight(), rightNode.getLeft());
	}
}
