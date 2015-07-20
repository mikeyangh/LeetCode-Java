
public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
        if (root == null)
        	return;
        if (root.left != null)
        	root.left.next = root.right;
        if (root.right != null)
        {
        	if (root.next != null)
        	{
	        	if (root.next.left != null)
	        		root.right.next = root.next.left;
	        	else
	        		root.right = root.next.right;
        	}
        }
        connect(root.left);
        connect(root.right);
    }
}
