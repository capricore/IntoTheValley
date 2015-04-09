package LinkedList;

public class ReverseKGroup
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		if (k <= 1)
		{
			return head;
		}
		ListNode cur = head, pre = dummy;
		int count = 0;
		while (cur != null)
		{
			count++;
			if (count % k == 0)
			{
				pre = reverse(pre,cur.next);
				cur = pre.next;
			}else {
				cur = cur.next;
			}
		}
		return dummy.next;
	}
	
	public ListNode reverse(ListNode head, ListNode next)
	{
		ListNode last = head.next;
		ListNode cur = last.next;
		while(cur != next)
		{
			last.next = cur.next;
			cur.next = head.next;
			head.next = cur;
			cur = last.next;
		}
		return last;
	}
	
	public static void main(String[] args)
	{
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur = cur.add(2);
		cur = cur.add(3);
		cur = cur.add(4);
		cur = cur.add(5);
		head = new ReverseKGroup().reverseKGroup(head, 3);
		while(head != null)
		{
			System.out.println(head.val);
			head = head.next;
		}
	}
}
