package LinkedList;

public class DeleteDuplicates {
	
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode pre = head, cur = head;
		while (cur != null && cur.next != null) {
			while (cur.next != null && cur.val == cur.next.val) {
				cur = cur.next;
			}
			if (pre.equals(cur)) {
				tail.next = pre;
				tail = tail.next;
			}
			pre = cur.next;
			cur = cur.next;
		}
		tail.next = cur;
		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur = cur.add(1);
		cur = cur.add(1);
		cur = cur.add(2);
		cur = cur.add(2);
		cur = cur.add(3);
		head = new DeleteDuplicates().deleteDuplicates(head);
		while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
}
