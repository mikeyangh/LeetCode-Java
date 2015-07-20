
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) 
	{
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }
	
	private TreeNode buildTree(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd)
	{
		if (preStart >= preorder.length || inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int index;
		for (index = inStart; index <= inEnd; index++)
			if (inorder[index] == preorder[preStart])
				break;
		
		root.left = buildTree(preorder, preStart+1, inorder, inStart, index-1);
		root.right = buildTree(preorder, preStart+index-inStart+1, inorder, index+1, inEnd);
		return root;
	}
}
