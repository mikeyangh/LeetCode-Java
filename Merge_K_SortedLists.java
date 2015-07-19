import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Merge_K_SortedLists 
{
	public ListNode mergeKLists(List<ListNode> lists) 
    {
		int n = lists.size();
		if (n == 0)
		    return null;
		ListNode head = new ListNode(0);
		ListNode tail = head;
		
		Comparator<ListNode> order = new Comparator<ListNode>(){
		public int compare(ListNode node1, ListNode node2)
		{
			return node1.val - node2.val;
		}
		};
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(n, order);
		for (ListNode node : lists)
		{
			if (node != null)
			{
				heap.offer(node);
			}
		}
		while (!heap.isEmpty())
		{
			tail.next = heap.poll();
			tail = tail.next;
			if (tail.next != null)
				heap.offer(tail.next);
		}
		return head.next;
	}


	public static void main(String[] args)
	{
		PriorityQueue<Integer> testQueue = new PriorityQueue<Integer>();
		//testQueue.add(1);
		testQueue.add(3);
		testQueue.add(5);
		testQueue.add(4);
		System.out.println(testQueue.poll());
	}
}
