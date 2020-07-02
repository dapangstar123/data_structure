package leetcode_easy;

import data_structure.TreeNode;
import data_structure.TreeTraverse;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，
 * 
 * @author pang
 *
 */
public class SortedArrayToBST {

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode root = sortedArrayToBST(nums);
		// 中序遍历
		TreeTraverse.inorderTraversal(root);

	}

	/**
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树
	 * 
	 * @param nums
	 *            升序排列的有序数组
	 * @return 高度平衡的二叉搜索树
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return createTree(nums, 0, nums.length - 1);
	}

	/**
	 * 递归创建一个树
	 * 
	 * @param nums
	 *            传入的数组
	 * @param left
	 *            低位索引
	 * @param right
	 *            高位索引
	 * @return 返回root节点
	 */
	public static TreeNode createTree(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.setLeft(createTree(nums, left, mid - 1));
		root.setRight(createTree(nums, mid + 1, right));
		return root;
	}
}
