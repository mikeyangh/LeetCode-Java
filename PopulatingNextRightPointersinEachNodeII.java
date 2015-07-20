
public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) 
	{
	    if (root == null)
	        return;
		subConnect(root);
		TreeLinkNode start = getStart(root);
		
		while (start != null)
		{
			TreeLinkNode temp = start;
			while (temp != null)
			{
				subConnect(temp);
				temp = temp.next;
			}
			start = getStart(start);
		}
		
	}
	private void subConnect(TreeLinkNode root) 
	{
        TreeLinkNode rightNode = null;
        if (root.next != null)
		{
			rightNode = root.next;
			while (rightNode.next != null && rightNode.left == null && rightNode.right == null)
			{
				rightNode = rightNode.next;
			}
		}
        if (root.left != null)
        {
        	if (root.right != null)
        		root.left.next = root.right;
        	else 
        	{
        		if (root.next != null)
        		{
	        		if (rightNode.left != null)
	        			root.left.next = rightNode.left;
	        		else
	       				root.left.next = rightNode.right;
        		}
        	}
        }
        if (root.right != null)
        {
        	if (root.next != null)
        	{
        		if (rightNode.left != null)
        			root.right.next = rightNode.left;
        		else
       				root.right.next = rightNode.right;
        	}
        }
        //connect(root.left);
        //connect(root.right);
    }
	
	private TreeLinkNode getStart(TreeLinkNode root)
	{
		TreeLinkNode start = root;
		while (start.next != null && start.left == null & start.right == null)
			start = start.next;
		if (start.left != null)
			return start.left;
		else
			return start.right;
	}
}
