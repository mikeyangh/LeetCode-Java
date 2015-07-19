
public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) 
	{
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p = head;
		ListNode tail = pre;
		while (p != null)
		{
			if (p.next == null)
				break;
			if (p.next.val != p.val )
			{
				tail = p;
				p = p.next;
			}
			else
			{
				while (p.next != null && p.next.val == p.val)
				{
					p = p.next;
				}
				tail = tail.next;				
				tail.next = p.next;
				p = p.next;
			}
		}
		return pre.next;
	}
}
