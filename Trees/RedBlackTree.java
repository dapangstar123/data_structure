package com.rbtree;

/**
 * 红黑树的特性 
 * 		1.每个节点要么是黑色，要么是红色 
 * 		2.根节点是黑色
 * 		3.每个叶子节点（NIL）是黑色。（注意：这里叶子节点，是指为空（NIL或NULL）的叶子节点) 
 * 		4.如果一个节点是红色的，则它的子节点必须是黑色的
 * 		5.从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点
 * 
 * 特性5保证了没有一条路径会比其他路径长出两倍，因而，红黑树是相对接近平衡的二叉树 
 * 具体实现参考 算法导论
 * 
 * @author pang
 *
 */
public class RedBlackTree {
	// 定义节点颜色
	private final String RED = "red";
	private final String BLACK = "black";
	private final Node nil = new Node(0);
	private Node root = nil;
	
	public Node getRoot() {
		return root;
	}

	/**
	 * 中序遍历
	 * 
	 * @param node
	 */
	public void inorderTreeWalk(Node node) {
		if (node != nil) {
			inorderTreeWalk(node.left);
			if (node.value != 0) {
				System.out.println("value: " + node.value + ", parent: " + node.parent.value + ", color: " + node.color);
			}
			inorderTreeWalk(node.right);
		}
	}

	/**
	 * 左旋
	 * 
	 * @param node
	 */
	void leftRotate(Node node) {
		Node y = node.right;
		node.right = y.left;
		if(y.left != nil){
			y.left.parent = node;
		}
		y.parent = node.parent;
		if(node.parent == nil){
			root = y;
		}
		else if(node == node.parent.left){
			node.parent.left = y;
		}
		else{
			node.parent.right = y;
		}
		y.left = node;
		node.parent = y;
	}

	/**
	 * 右旋
	 * 
	 * @param node
	 */
	void rightRotate(Node node) {
		Node y = node.left;
		node.left = y.right;
		if(y.right != nil){
			y.right.parent = node;
		}
		y.parent = node.parent;
		if(node.parent == nil){
			root = y;
		}
		else if(node == node.parent.right){
			node.parent.right = y;
		}
		else{
			node.parent.left = y;
		}
		y.right = node;
		node.parent = y;
	}

	/**
	 * 插入节点 1：红黑树为空树 
	 * 		   2：插入结点的父结点为黑结点 
	 *         3：插入结点的父结点为红结点 
	 *            3.1：叔叔结点存在并且为红结点
	 *            3.2：叔叔结点不存在或为黑结点，并且插入结点的父亲结点是祖父结点的左子结点 
	 *                 3.2.1：插入结点是其父结点的左子结点
	 *                 3.2.2：插入结点是其父结点的右子结点 
	 *            3.3：叔叔结点不存在或为黑结点，并且插入结点的父亲结点是祖父结点的右子结点
	 *                 3.3.1：插入结点是其父结点的右子结点 
	 *                 3.3.2：插入结点是其父结点的左子结点
	 * 
	 * @param node
	 */
	public void insert(Node node) {
		// init node
		node.left = nil;
		node.right = nil;
		node.parent = nil;

		Node y = nil;
		// 将x设置为红黑树的根节点
		Node x = root;
		// 找出要插入的节点在二叉树中的位置
		while (x != nil) {
			y = x;
			if (node.value < x.value) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		// 找到位置之后，将node的perent指向y
		node.parent = y;
		if (y == nil) {
			root = node;
		} else if (node.value < y.value) {
			y.left = node;
		} else {
			y.right = node;
		}
		node.color = RED;
		insertFixup(node);
	}

	/**
	 * 插入节点后，调整节点使其平衡
	 * @param node
	 */
	private void insertFixup(Node node) {
		//插入节点的父亲节点是红色
		while(node.parent.color == RED){
			//如果插入节点的父亲是其祖父节点的左孩子
			if(node.parent == node.parent.parent.left){
				//y为插入节点的叔叔节点
				Node y = node.parent.parent.right;
				// 叔叔节点为红色
				if(y.color == RED){
					node.parent.color = BLACK;
					y.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}
				// 叔叔节点为黑色
				else{
					// 插入节点是父亲节点的右子节点
					if(node == node.parent.right){
						node = node.parent;
						leftRotate(node);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rightRotate(node.parent.parent);
				}
			}
			// 插入节点的父亲节点使其祖父节点的右孩子
			else{
				Node y = node.parent.parent.left;
				if(y.color == RED){
					node.parent.color = BLACK;
					y.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				}
				else{
					if(node == node.parent.left){
						node = node.parent;
						rightRotate(node);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					leftRotate(node.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}
	
	/**
	 * 删除节点
	 * @param node
	 */
	public void delete(Node node){
		//y为要替代删除的节点
		Node y = node;
		//x记录要删除节点的后继节点
		Node x = nil;
		//记录原始y节点的颜色
		String yOriginalColor = y.color;
		// 左孩子为nil
		if(node.left == nil){
			x = node.right;
			transplant(node, node.right);
		}
		// 右孩子为nil
		else if(node.right == nil){
			x = node.left;
			transplant(node, node.left);
		}
		//有两个子节点
		else{
			//先获取要删除节点的后继节点,此时y可能有右子节点，不可能有左子节点
			y = treeMinNum(node);
			//记录颜色
			yOriginalColor = y.color;
			x = y.right;
			//分情况
			// 如果y的parent就是要删除的节点
			if(y.parent == node){
				x.parent = y;
			}
			else{
				//删除节点y和其parent之间的指向，并建立节点y.right与y的parent之间的指向
				transplant(y, y.right);
				y.right = node.right;
				y.right.parent = y;
			}
			transplant(node, y);
			y.left = node.left;
			y.left.parent = y;
			y.color = node.color;
		}
		if(yOriginalColor == BLACK){
			deleteFixup(x);
		}
		
	}
	
	/**
	 * 删除节点后的调整,通过旋转使其成为新的平衡的红黑树
	 * @param x
	 */
	private void deleteFixup(Node x) {
		while(x != root && x.color == BLACK){
			if(x == x.parent.left){
				//兄弟节点w
				Node w = x.parent.right;
				//case1:
				if(w.color == RED){
					w.color = BLACK;
					x.parent.color = RED;
					leftRotate(x.parent);
					// new w
					w = x.parent.right;
				}
				//case2:
				if(w.left.color == BLACK && w.right.color == BLACK){
					w.color = RED;
					x = x.parent;
				}
				else{
					//case3:
					if(w.right.color == BLACK){
						w.left.color = BLACK;
						w.color = RED;
						rightRotate(w);
						w = x.parent.right;
					}
					//case4:
					w.color = x.parent.color;     
					x.parent.color = BLACK; 
					w.right.color = BLACK;      
					leftRotate(x.parent);       
					x = root; 
				}
			}
			else{
				Node w = x.parent.left;
				if(w.color == RED){
					w.color =BLACK;
					x.parent.color = RED;
					rightRotate(x.parent);
					w = x.parent.left;
				}
				if(w.right.color == BLACK && w.left.color == BLACK){
					w.color = RED;
					x = x.parent;
				}
				else{
					if(w.left.color == BLACK){
						w.right.color = BLACK;
						w.color = RED;
						leftRotate(w);
						w = x.parent.left;
					}
					w.color = x.parent.color;
					x.parent.color = BLACK;
					w.left.color = BLACK;
					rightRotate(x.parent);
					x = root;
				}
			}
		}
		x.color = BLACK;
	}

	/**
	 * 删除节点u和其parent之间的指向，并建立节点v与u的parent之间的指向
	 * 
	 * @param u
	 * @param v
	 */
	void transplant(Node u, Node v) {
		if (u.parent == nil) {
			root = v;
		} else if (u == u.parent.left) {
			u.parent.left = v;
		} else {
			u.parent.right = v;
		}
		v.parent = u.parent;
	}
	
	/**
	 * 获取树中最小的节点
	 * @param node
	 */
	Node treeMinNum(Node node){
		while(node.left != nil){
			node = node.left;
		}
		return node;
	}

}

class Node {
	int value = 0;
	String color = "black";
	Node left = null;
	Node right = null;
	Node parent = null;

	public Node(int value) {
		this.value = value;
	}
}