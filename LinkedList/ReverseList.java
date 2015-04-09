package LinkedList;



class ListNode
{
	int val; 
	ListNode next;
	ListNode(int val)
	{
		this.val = val;
		this.next = null;
	}
	ListNode add(int val)
	{
		ListNode node = new ListNode(val);
		next = node;
		return node;
	}
}
public class ReverseList
{
	//递归逆转链表
	public ListNode reverseList(ListNode head)
	{
		if ( head.next == null)
		{
			return head;
		}
		ListNode pre = head.next;
		ListNode newHead = reverseList(head.next);
		head.next = null;
		pre.next = head;//反转指针转向
		return newHead;//返回新的链表头
	}
	
	//非递归逆转链表
	public ListNode reverse(ListNode head)
	{
//		if (head == null)
//		{
//			return head;
//		}
//		ListNode p = head;
//		ListNode q = head.next;
//		p.next = null;//必须加上，否则新链表最后一个的next非空
//		while (q != null)
//		{
//			ListNode temp = q.next;
//			q.next = p;
//			p = q;
//			q = temp;
//		}
//		return p;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head.next;
		head.next = null;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = dummy.next;
			dummy.next = cur;
			cur = next;
		}
		return dummy.next;
	}
	
	public static void main(String[] args)
	{
		ReverseList reverseList = new ReverseList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode newHead = null;
		newHead = reverseList.reverse(head);
		while (newHead != null)
		{
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
