
public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) 
	{
		TreeNode copy = clone(root);
		Mirror(root);
		return isSameTree(copy, root);
    }
	
	private void Mirror(TreeNode root)
	{
		if (root == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}
	
	private TreeNode clone(TreeNode root)
	{
		if (root == null)
			return null;
		TreeNode node = new TreeNode(root.val);
		node.left = clone(root.left);
		node.right = clone(root.right);
		return node;
	}
	
	private boolean isSameTree(TreeNode p, TreeNode q) 
	{
        if (p == null && q == null)
        	return true;
        if (p != null && q != null)
        	return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else
        	return false;
    }
}
