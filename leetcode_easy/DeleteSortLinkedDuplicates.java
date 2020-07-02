package leetcode_easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * 
 * 
 * 示例 1: 输入: 1->1->2 输出: 1->2
 * 
 * 示例 2: 输入: 1->1->2->3->3 输出: 1->2->3
 * 
 * 
 * @author pang
 *
 */
public class DeleteSortLinkedDuplicates {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);
		head.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		printNode(head);
		System.out.println("**********************");
		// 去重
		deleteDuplicates(head);
		printNode(head);

	}

	public static ListNode deleteDuplicates(ListNode head) {
		// 循环 链表
		ListNode cur = head;
		while (cur != null && cur.next != null) {
			if (cur.next.val == cur.val) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
		return head;
	}

	public static void printNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

}