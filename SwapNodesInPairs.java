
public class SwapNodesInPairs 
{	
	public ListNode swapPairs(ListNode head) 
	{
		ListNode prehead = new ListNode(0);
		prehead.next = head;
		ListNode current = prehead;
		while (current.next != null && current.next.next != null)
		{
			ListNode secondNode = current.next.next;
			current.next.next = secondNode.next;
			secondNode.next = current.next;
			current.next = secondNode;
			current = current.next.next;
		}
		return prehead.next;
    }
	public static void main(String[] args)
	{
		
	}
}
