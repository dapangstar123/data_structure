package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:  给定二叉树，以及目标和 sum = 22
 * 
 * @author pang
 *
 */
public class TreeHasPathSum {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(1);
		
		root.setLeft(node1);
		root.setRight(node2);
		
		node1.setLeft(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);
		
		node5.setRight(node8);
		
		System.out.println(hasPathSum(root, 21));
		System.out.println(hasPathSum(root, 22));
		
	}
	
	
	public static Boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		sum -= root.getVal();
		if (root.getLeft() == null && root.getRight() == null) {
			return sum == 0;
		}
		return hasPathSum(root.getLeft(), sum) || hasPathSum(root.getRight(), sum);
	}
}
