import java.util.LinkedList;
import java.util.List;


public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		List<TreeNode> preList = new LinkedList<>();
		preList.add(root);
		boolean isOdd = true;
		while (preList.size() != 0)
		{
			List<Integer> item = new LinkedList<>();
			int length = preList.size();
			if (isOdd)
				for (int i = length-1; i >= 0; i--)
				{
					TreeNode node = preList.get(i);
					item.add(node.val);
					if (node.left != null)
						preList.add(node.left);
					if (node.right != null)
						preList.add(node.right);
					preList.remove(i);
				}
			else
				for (int i = length-1; i >= 0; i--)
				{
					TreeNode node = preList.get(i);
					item.add(node.val);
					if (node.right != null)
						preList.add(node.right);
					if (node.left != null)
						preList.add(node.left);
					preList.remove(i);
				}
			isOdd = !isOdd;
			result.add(item);
		}
		return result;
    }
}
