package may;

import utils.ListNode;

public class ReverseList {

	public static void main(String[] args) {
		ListNode  head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		head = reverseList(head);
		while(head != null) {
			System.out.println(head.val + "-> ");
		}
	}

	static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        else{
            ListNode node = head;
            while(node.next != null){
                System.out.println("Current node -- > " + node.val);
                ListNode temp = node.next;
                node.next = temp.next;
                temp.next = head;
                head = temp;
                System.out.println("head -- > " + head.val);
            }
            return head;
        }
    }
}
