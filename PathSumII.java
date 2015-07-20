import java.util.LinkedList;
import java.util.List;


public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) 
	{
		List<List<Integer>> result = new LinkedList<>();
		if (root == null)
			return result;
		if (root.left == null && root.right == null && root.val == sum)
		{
			List<Integer> list = new LinkedList<>();
			list.add(sum);
			result.add(list);
		}
		for (List<Integer> list : pathSum(root.left, sum-root.val))
		{
			list.add(0, root.val);
			result.add(list);
		}
		for (List<Integer> list : pathSum(root.right, sum-root.val))
		{
			list.add(0, root.val);
			result.add(list);
		}
		return result;
    }
}
