import java.util.LinkedList;
import java.util.List;


public class UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) 
	{
		List<TreeNode> result = new LinkedList<>();
		if (n == 0)
		{
			result.add(null);
			return result;
		}
		if (n == 1)
		{
			TreeNode root = new TreeNode(1);
			result.add(root);
			return result;
		}
		for (int i = 0; i < n; i++)
		{
			for (TreeNode left : generateTrees(i))
			{
				for (TreeNode right : generateTrees(n-i-1))
				{
					TreeNode leftside = clone(left);
					TreeNode rightside = clone(right, i);
					//increase(rightside, i);
					TreeNode newNode = new TreeNode(n);
					newNode.left = rightside;
					
					if (leftside != null)
					{
						TreeNode node = leftside;
						while (node.right != null)
							node = node.right;
						node.right = newNode;
						result.add(leftside);
					}
					else
					{
						result.add(newNode);
					}
						
				}	
			}		
		}
		return result;
    }
	
	private TreeNode clone(TreeNode root)
	{
		if (root == null)
			return null;
		TreeNode clone = new TreeNode(root.val);
		clone.left = clone(root.left);
		clone.right = clone(root.right);
		return clone;
	}
	
	private TreeNode clone(TreeNode root, int offset)
	{
		if (root == null)
			return null;
		TreeNode clone = new TreeNode(root.val + offset);
		clone.left = clone(root.left, offset);
		clone.right = clone(root.right, offset);
		return clone;
	}
}
