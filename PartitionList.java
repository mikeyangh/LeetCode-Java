
public class PartitionList {
	public ListNode partition(ListNode head, int x) 
	{
	    if (head == null)
	        return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode p = pre;
		while (p.next != null && p.next.val < x)
		{
			p = p.next;
		}
		ListNode q = p.next;
		ListNode cur = p;
		while (cur.next != null)
		{
			if (cur.next.val < x)
			{
				ListNode delete = cur.next;
				cur.next = delete.next;
				p.next = delete;
				delete.next = q;
				p = delete;
			}
			else
				cur = cur.next;
		}
		return pre.next;
    }
}
