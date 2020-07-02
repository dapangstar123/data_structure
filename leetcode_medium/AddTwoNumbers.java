package leetcode_medium;

import data_structure.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 
 * @author pang
 *
 */

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(7);

		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(0);
		ListNode node4 = new ListNode(8);

		head1.setNext(node1);
		node1.setNext(node2);

		head2.setNext(node3);
		node3.setNext(node4);

		ListNode addTwoNumbers = addTwoNumbers(head1, head2);
		// 输出
		ListNode p = addTwoNumbers;
		while (p != null) {
			System.out.println(p.getVal());
			p = p.getNext();
		}

	}

	/**
	 * 两个链表数据相加
	 * 
	 * @param l1
	 *            链表1
	 * @param l2
	 *            链表2
	 * @return 返回一个结果链表
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 定义一个新的链表用于保存输出的结果
		ListNode result = new ListNode(0);

		ListNode p = l1;
		ListNode q = l2;
		ListNode current = result;
		// 进位
		int carry = 0;
		while (p != null || q != null) {
			int x = (p != null) ? p.getVal() : 0;
			int y = (q != null) ? q.getVal() : 0;
			int sum = x + y + carry;
			// 生成结果链表的节点
			current.setNext(new ListNode(sum % 10));
			current = current.getNext();
			// 重置进位
			carry = sum / 10;
			// 节点后移
			if (p != null) {
				p = p.getNext();
			}
			if (q != null) {
				q = q.getNext();
			}
		}
		// 判断最后的进位
		if (carry > 0) {
			current.setNext(new ListNode(carry));
		}
		return result.getNext();
	}
}
