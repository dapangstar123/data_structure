package leetcode_easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data_structure.TreeNode;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 
 * 例如： 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * 
 * [ [15,7], [9,20], [3] ]
 * 
 * @author pang
 *
 */
public class TreeLevelOrderBottom {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		TreeNode node1 = new TreeNode(9);
		TreeNode node2 = new TreeNode(20);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(7);

		root.setLeft(node1);
		root.setRight(node2);
		node2.setLeft(node3);
		node2.setRight(node4);

		List<List<Integer>> levelOrderBottom = levelOrderBottom(root);
		System.out.println(levelOrderBottom.toString());

	}

	/**
	 * 对树从下到上层析遍历
	 * 
	 * @param root
	 *            待遍历的树
	 * @return List<List<Integer>>
	 */
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		// 结果
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null) {
			return result;
		}
		// 队列
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<Integer>();
			// 当前队列的大小
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				// 弹出队里的第一个元素，并删除
				TreeNode node = queue.poll();
				list.add(node.getVal());
				// 向队列中压入下一层的节点
				if (node.getLeft() != null) {
					queue.add(node.getLeft());
				}
				if (node.getRight() != null) {
					queue.add(node.getRight());
				}
			}
			result.add(0, list);
		}
		return result;
	}
}
