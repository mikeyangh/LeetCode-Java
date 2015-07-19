
public class ReverseNodesaIn_K_Group 
{
	public ListNode reverseKGroup(ListNode head, int k)
	{
		if (k == 1)
			return head;
		ListNode prehead = new ListNode(0);
		prehead.next = head;
		ListNode current = prehead;
		while (true)
		{
			ListNode tailNode = current.next;
			for (int i = 0; i < k; i ++)
			{
				if (tailNode == null)
				{
					return prehead.next;
				}
				tailNode = tailNode.next;
			}

			ListNode first2last = current.next;
			for (int i = 0; i < k - 1; i++)
			{
				ListNode temp = current.next;
				current.next = temp.next;
				temp.next = tailNode;
				tailNode = temp;
			}
			current.next.next = tailNode;
			current = first2last;
		}
    }
	public static void main(String[] args)
	{
		ListNode head = new ListNode(-1);
		for (int i = 0; i < 10; i++)
		{
			ListNode node = new ListNode(i);
			node.next = head.next;
			head.next = node;
		}
		ListNode p = head.next;
		for (int i = 0; i < 10; i++)
		{
			System.out.print(p.val+" ");
			p = p.next;
		}
		System.out.println();
		ReverseNodesaIn_K_Group test = new ReverseNodesaIn_K_Group();
		p = test.reverseKGroup(head.next, 4);
		//p = head.next;
		for (int i = 0; i < 10; i++)
		{
			System.out.print(p.val+" ");
			p = p.next;
		}
	}
}
