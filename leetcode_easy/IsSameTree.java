package leetcode_easy;

import data_structure.TreeNode;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 
 * @author pang
 *
 */
public class IsSameTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(1);
		TreeNode root3 = new TreeNode(1);

		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);

		// tree1
		root1.setLeft(node1);
		root1.setRight(node2);

		// tree2
		root2.setLeft(node1);
		root2.setRight(node2);

		// tree3
		root3.setLeft(node1);
		root3.setRight(node3);

		System.out.println(isSameTree(root1, root2));
		System.out.println(isSameTree(root1, root3));

	}

	public static Boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.getVal() != q.getVal()) {
			return false;
		}
		return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
	}
}
