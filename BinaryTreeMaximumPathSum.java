import java.util.HashMap;


public class BinaryTreeMaximumPathSum {
	public int maxPathSum(TreeNode root) {
        if (root == null)
        	return 0;
        HashMap<TreeNode, Integer> hash = new HashMap<>();
        hash.put(null, 0);
        maxRootSum(root, hash);
        return SubSum(root, hash);
    }
	
	private int SubSum(TreeNode root, HashMap<TreeNode, Integer> hash)
	{
		if (root == null)
			return 0;
		int middle = root.val;
		if (hash.get(root.left) > 0)
			middle += hash.get(root.left);
		if (hash.get(root.right) > 0)
			middle += hash.get(root.right);
		int max = middle;
		if (root.left != null)
		{
			int left = SubSum(root.left, hash);
			if (left > max)
				max = left;
		}
		if (root.right != null)
		{
			int right = SubSum(root.right, hash);
			if (right > max)
				max = right;
		}
	        return max;
	}
	
	private int maxRootSum(TreeNode root, HashMap<TreeNode, Integer> hash)
	{
		if (root == null)
			return 0;
		int sum = Math.max(root.val, root.val+Math.max(maxRootSum(root.left, hash), maxRootSum(root.right, hash)));
		hash.put(root, sum);
		return sum;
	}
}
