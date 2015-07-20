
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) 
	{
		if (root == null)
			return;
		TreeNode leftLast = root.left;
		if (leftLast != null)
		{
			while (leftLast.right != null || leftLast.left != null)
			{
				if (leftLast.right != null)
					leftLast = leftLast.right;
				else
					leftLast = leftLast.left;
			}
			flatten(root.left);
			flatten(root.right);
			leftLast.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		else
			flatten(root.right);
    }
}
