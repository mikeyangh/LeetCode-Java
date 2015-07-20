import java.util.Stack;


public class LargestRectangleinHistogram {
	/*
    public int largestRectangleArea(int[] height) 
	{
	    int length = height.length;
		Stack<Integer> stack = new Stack<>();
		int maxArea = 0;
		for (int i = 0; i <= length; i++)
		{
			int h = 0;
			if (i != length)
				h = height[i];
			if (stack.isEmpty() || height[stack.peek()] <= h)
				stack.push(i);
			else
			{	//i is right small index
				//stack.peek() is left small index
				int maxIndex = stack.pop();
				maxArea = Math.max(maxArea, height[maxIndex]*(stack.isEmpty()? i : i-stack.peek()-1));
				i--;  // recompute i
			}				
		}
		return maxArea;
    }*/
    public int largestRectangleArea(int[] height) 
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
			    stack.pop();
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
