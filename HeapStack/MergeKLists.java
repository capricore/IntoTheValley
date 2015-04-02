package HeapStack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
		next = null;
	}
}
public class MergeKLists {
	ListNode mergeKLists(ArrayList<ListNode> lists){
		int n = lists.size();
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val < o2.val) {
					return -1;
				}else if (o1.val > o2.val) {
					return 1;
				}else {
					return 0;
				}
			}
		};
		ListNode head = null, current = null;
		PriorityQueue<ListNode> heap = new PriorityQueue<>(n,comparator);
		for (int i = 0; i < n; i++) {
			ListNode node = lists.get(i);
			if (node != null) {
				heap.add(node);
			}
		}
		while (!heap.isEmpty()) {
			if (head == null) {
				head = heap.poll();
				current = head;
				if (current.next != null) {
					heap.add(current.next);
				}
			}else {
				ListNode node = heap.poll();
				current.next = node;
				current = node;
				if (current.next != null) {
					heap.add(current.next);
				}
			}
		}
		return head;
	}
}
