package LinkedList;

public class GetCircleLength
{
	public int getCircleLength(ListNode head)
	{
		ListNode slow = head;
		if (slow == null || slow.next == null)
		{
			return 0;
		}
		ListNode fast = slow.next.next;
		if (fast.next != null && fast != null)
		{
			if (slow == fast)
			{
				return getLength(fast);
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return 0;
	}
	
	public int getLength(ListNode head)
	{
		ListNode cur = head;
		int length = 1;
		while (cur.next != head)
		{
			length++;
			cur = cur.next;
		}
		return length;
	}
}
