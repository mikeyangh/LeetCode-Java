import java.util.List;


public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] minPath = new int[triangle.size()];
        int[] temp = new int[triangle.size()];
        minPath[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++)
        {
        	temp[0] = minPath[0]+triangle.get(i).get(0);
        	temp[i] = minPath[i-1]+triangle.get(i).get(i);
        	for (int j = 1; j <= i-1; j++)
        	{
        		temp[j] = Math.min(minPath[j-1], minPath[j])+triangle.get(i).get(j);
        	}
        	for (int j = 0; j <= i; j++)
        		minPath[j] = temp[j];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++)
        {
        	if (minPath[i] < min)
        		min = minPath[i];
        }
        return min;
    }
}
