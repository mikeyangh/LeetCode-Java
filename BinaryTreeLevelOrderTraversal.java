import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) 
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		List<TreeNode> preList = new LinkedList<>();
		preList.add(root);
		while (preList.size() != 0)
		{
			List<Integer> item = new LinkedList<>();
			int length = preList.size();
			for (int i = 0; i < length; i++)
			{
				TreeNode node = preList.get(0);
				item.add(node.val);
				if (node.left != null)
					preList.add(node.left);
				if (node.right != null)
					preList.add(node.right);
				preList.remove(0);
			}
			result.add(item);
		}
		return result;
    }
}
