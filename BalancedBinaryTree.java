
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) 
	{
		if (root == null)
			return true;
		if (Math.abs(depth(root.left)-depth(root.right)) <=1)
		{
			return isBalanced(root.left) && isBalanced(root.right);
		}
		else
			return false;
    }
	
	
	private int depth(TreeNode root)
	{
		if (root == null)
			return 0;
		return 1+Math.max(depth(root.left), depth(root.right));
	}
}
