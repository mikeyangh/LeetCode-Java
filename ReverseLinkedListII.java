
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) 
	{
		if (m == n)
			return head;
		ListNode pre = new ListNode(-1);
		pre.next = head;
		while (m < n)
		{
		    ListNode p = pre;
			for (int i = 1; i <= m-1; i++)
			{
				p = p.next;
			}
			ListNode q = p;
			for (int i = m; i <= n; i++)
			{
				p = p.next;
			}
			ListNode tail = p;
			ListNode remove = q.next;
			q.next = remove.next;
			remove.next = tail.next;
			tail.next = remove;
			n--;
		}
		return pre.next;
    }
}
