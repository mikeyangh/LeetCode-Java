import java.util.Stack;


public class RecoverBinarySearchTree {
	public void recoverTree(TreeNode root) 
	{
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		TreeNode pre = new TreeNode(Integer.MIN_VALUE);
		boolean flag = true;
		TreeNode preNode = null;
		TreeNode curNode = null;
		while (true)
		{
			while (node != null)   //traverse left
			{
				stack.push(node);
				node = node.left;
			}
			TreeNode pop = stack.pop();   //pop and visit
			if (pop.val < pre.val)
			{
				if (flag)
				{
					preNode = pre;
					curNode = pop;
					flag = false;
				}
				else
				{
					swapNode(pop, preNode);
					return;
				}
			}
			pre = pop;
			while (pop.right == null)     //keep pop if right is null
			{
				if (stack.isEmpty())
				{
					swapNode(preNode, curNode);
					return;
				}
				pop = stack.pop();
				if (pop.val < pre.val)
				{
					if (flag)
					{
						preNode = pre;
						curNode = pop;
						flag = false;
					}
					else
					{
						swapNode(pop, preNode);
						return;
					}
				}
				pre = pop;
			}
			node = pop.right;     // if right is not null, keep the cycle
		}
	}
	
	private void swapNode (TreeNode a, TreeNode b)
	{
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}
}
