/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateList 
{
	public ListNode rotateRight(ListNode head, int k) 
	{
	    if (head == null)
	        return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		int count = 0;
		ListNode p = pre;
		ListNode q = pre;
		while (p.next != null)
		{
			count++;
			p = p.next;
		}
		k = k % count;
		if (k == 0)
		    return head;
		for (int i = 0; i < count-k; i++)
		{
			q = q.next;
		}
		pre.next = q.next;
		p.next = head;
		q.next = null;
		return pre.next;
    }
	public static void main(String[] args) 
	{
		RotateList test = new RotateList();
		
	}
}
