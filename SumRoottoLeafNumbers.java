
public class SumRoottoLeafNumbers {
	int result = 0;
	public int sumNumbers(TreeNode root) {
		plus(root, 0);
        return result;
    }
	
	private void plus(TreeNode root, int num)
	{
		if (root == null)
			return;
		int temp = num*10+root.val;
		if (root.left != null)
		{
			plus(root.left, temp);
		}
		if (root.right != null)
		{
			plus(root.right, temp);
		}
		if (root.left == null && root.right == null)
			result += temp;
	}
}
