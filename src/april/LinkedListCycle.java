package april;

import java.util.HashSet;
import java.util.Set;

import utils.ListNode;

public class LinkedListCycle {

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(2);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(-4);
		node.next.next.next.next = node.next;

		System.out.println(detectCycle(node).val);

	}

	static ListNode detectCycle(ListNode head) {
		ListNode p1 = head == null ? null : head;
		ListNode p2 = head == null ? null : head;
		boolean isCycle = false;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				isCycle = true;
				break;
			}
		}

		if (isCycle) {
			p2 = head;
			while (p1 != p2) {
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}
		return null;
	}

	// No duplicates.
	static ListNode detectCycle1(ListNode head) {
		Set<Integer> set = new HashSet<Integer>();
		while (head != null) {
			if (!set.add(head.val))
				break;
			head = head.next;
		}
		return head;
	}

}
