
public class ContainerWithMostWater {
	public int maxArea(int[] height) 
    {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        int tempArea;
        while (i < j)
        {
            int minIndex = minIndex(height, i, j);
            tempArea = (j-i)*height[minIndex];
            maxArea = max(maxArea, tempArea);
            if (i == minIndex)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return maxArea;
    }
    public int max(int a, int b)
    {
        if (a > b) return a;
        else return b;
    }
    public int minIndex(int[] height, int i, int j)
    {
        if (height[i] < height[j])
        {
            return i;
        }
        else return j;
    }
    
    /*
    public int maxArea(int[] height) 
    {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        int tempArea;
        while (i < j)
        {
            int minIndex = minIndex(height, i, j);
            tempArea = (j-i)*height[minIndex];
            if (tempArea > maxArea)
            {
                maxArea = tempArea;
            }
            if (i == minIndex)
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return maxArea;
    }
    public int minIndex(int[] height, int i, int j)
    {
        if (height[i] < height[j])
        {
            return i;
        }
        else return j;
    }
     */
}
