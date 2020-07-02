package data_structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的遍历
 * 
 * @author pang
 *
 */
public class TreeTraverse {

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.getLeft());
		System.out.println(root.getVal());
		inorderTraversal(root.getRight());
	}

	/**
	 * 中序遍历 非递归
	 * 
	 * @param node
	 * @return
	 */
	public static List<Integer> inorderTraversal2(TreeNode root) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curNode = root;

		while (curNode != null || !stack.empty()) {
			// 一直向左，但是不打印
			while (curNode != null) {
				stack.push(curNode);
				curNode = curNode.getLeft();
			}
			// 到达最左表，打印并改变方向
			if (!stack.empty()) {
				curNode = stack.pop();
				arrayList.add(curNode.getVal());
				curNode = curNode.getRight();
			}
		}
		return arrayList;
	}

}
