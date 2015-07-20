import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BinaryTreeInorderTraversal {
	/*
    public List<Integer> inorderTraversal(TreeNode root) 
	{
		List<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		List<Integer> left = inorderTraversal(root.left);
		List<Integer> right = inorderTraversal(root.right);
		result.addAll(left);
		result.add(root.val);
		result.addAll(right);
		return result;
    }*/
    /*
    public List<Integer> inorderTraversal(TreeNode root) 
	{
		List<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while (true)
		{
			while (node != null)
			{
				stack.push(node);
				node = node.left;
			}
			TreeNode pop = stack.pop();
			result.add(pop.val);
			while (pop.right == null)
			{
				if (stack.isEmpty())
					return result;
				pop = stack.pop();
				result.add(pop.val);
			}
			node = pop.right;
		}
	}*/
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> result = new LinkedList<>();
		if (root == null)
			return result;
		TreeNode temp = null;
		while (root != null)
		{
			if (root.left == null)
			{
				result.add(root.val);
				root = root.right;
			}
			else
			{
				temp = root.left;
				while (temp.right != null && temp.right != root)
					temp = temp.right;
				if (temp.right == null)
				{
					temp.right = root;
					root = root.left;
				}
				else
				{
					temp.right = null;
					result.add(root.val);
					root = root.right;
				}
			}
		}
		return result;
	}
}
