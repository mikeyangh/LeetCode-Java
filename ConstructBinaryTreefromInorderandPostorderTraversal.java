
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) 
	{
		return buildTree(inorder, 0, inorder.length-1, postorder, postorder.length-1);
    }
	
	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postEnd)
	{
		if (inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int index;
		for (index = inStart; index <= inEnd; index++)
			if (inorder[index] == postorder[postEnd])
				break;
		root.right = buildTree(inorder, index+1, inEnd, postorder, postEnd-1);
		root.left = buildTree(inorder, inStart, index-1, postorder, postEnd-inEnd+index-1);
		return root;
	}
}
