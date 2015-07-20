import java.util.Stack;


public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) 
	{
		if (matrix.length == 0)
	        return 0;
		int[][] heightMatrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++)
		{
			if (matrix[0][i] == '0')
				heightMatrix[0][i] = 0;
			else
				heightMatrix[0][i] = 1;
		}
		for (int i = 1; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == '0')
					heightMatrix[i][j] = 0;
				else
					heightMatrix[i][j] = heightMatrix[i-1][j]+1;
			}
		int result = 0;
		for (int i = 0; i < matrix.length; i++)
		{
			result = Math.max(result, largestRectangleArea(heightMatrix[i]));
		}
		return result;
	}
	
	private int largestRectangleArea(int[] height) 
	{
	    int length = height.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i <= length; i++)
		{
			int h = 0;
			if (i != length)
				h = height[i];
			if (stack.isEmpty() || height[stack.peek()] < h)
				stack.push(i);
			else if (height[stack.peek()] == h)
			{
				stack.pop();  //discard front index because we only use this as left boundary
			    stack.push(i);
			    continue;
			}
			else
			{	//i is right small index
				//stack.peek() is left small index
				int maxIndex = stack.pop();
				maxArea = Math.max(maxArea, height[maxIndex]*(stack.isEmpty()? i : i-stack.peek()-1));
				i--;  // recompute i
			}				
		}
		return maxArea;
    }
}
