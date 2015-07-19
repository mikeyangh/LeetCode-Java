
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode p, q;
        p = head;
        q = p;
        for (int i = 0; i <= n; i++)
        {
            if (q == null)
            {
                ListNode newhead = head.next;
                //head = null;
                return newhead;
            }
            q = q.next;
        }
        while (q != null)
        {
            p = p.next;
            q = q.next;
        }
        //ListNode deletenode = p.next;
        p.next = p.next.next;
        //deletenode = null;
        return head;
    }
}
