
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) 
	{
		if (root == null)
			return true;
		if (!isValidBST(root.left) || !isValidBST(root.right))
			return false;
		if (root.left != null && rightmost(root.left) >= root.val)
			return false;
		if (root.right != null && leftmost(root.right) <= root.val)
			return false;
		return true;
    }
	
	private int rightmost(TreeNode root)
	{
		TreeNode node = root;
		while (node.right != null)
			node = node.right;
		return node.val;
	}
	
	private int leftmost(TreeNode root)
	{
		TreeNode node = root;
		while (node.left != null)
			node = node.left;
		return node.val;
	}
}
