package may;

import java.util.*;

import utils.ListNode;

public class MergeKSortedList {
	public static void main(String[] args) {
		ArrayList<ListNode> al = new ArrayList<>();
		Collections.sort(al, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return Integer.compare(o1.val, o2.val);
			}
		});
	}
}
