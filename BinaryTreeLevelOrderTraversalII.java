import java.util.LinkedList;
import java.util.List;


public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
	{
		List<List<Integer>> result = new LinkedList<>();
		DFSTraversal(root, result, 0);
		return result;
    }
	
	private void DFSTraversal(TreeNode root, List<List<Integer>> result, int level)
	{
		if (root == null)
			return;
		if (level >= result.size())
		{
			List<Integer> list = new LinkedList<>();
			result.add(0, list);
		}
		result.get(result.size()-1-level).add(root.val);
		DFSTraversal(root.left, result, level+1);
		DFSTraversal(root.right, result, level+1);
	}
}
