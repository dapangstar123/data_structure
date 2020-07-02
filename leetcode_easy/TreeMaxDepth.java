package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * @author pang
 *
 */
public class TreeMaxDepth {

	
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
		
		System.out.println(maxDepth(root));
		
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(root.getLeft());
			int rightDepth = maxDepth(root.getRight());
			return leftDepth >= rightDepth ? leftDepth + 1 : rightDepth + 1;
		}
	}
}
