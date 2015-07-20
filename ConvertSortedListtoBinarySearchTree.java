import java.util.ArrayList;


public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) 
	{
		//HashMap<Integer, Integer> hash = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		ListNode p = head;
		while (p != null)
		{
			list.add(p.val);
			p = p.next;
		}
		return sortedListToBST(list, 0, list.size()-1);
    }
	
	private TreeNode sortedListToBST(ArrayList<Integer> list, int start, int end)
	{
		if (start > end)
			return null;
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = sortedListToBST(list, start, mid-1);
		root.right = sortedListToBST(list, mid+1, end);
		return root;
	}
}
