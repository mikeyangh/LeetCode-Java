import java.util.LinkedList;
import java.util.List;


public class SpiralMatrix 
{
	public List<Integer> spiralOrder(int[][] matrix) 
    {
		List<Integer> result = new LinkedList<>();
        int height = matrix.length;
        if (height == 0)
            return result;
        int width = matrix[0].length;
        int i = 0;
        int j = 0;
        int count = 0;
        while (width > 0 && height > 0)
        {
        	if (count % 4 == 0)
        	{
	        	for (int k = 0; k < width; k++)
	        	{
	        		result.add(matrix[i][j]);
	        		j++;
	        	}
	        	j--;
	        	height--;
	        	i++;
        	}
        	else if (count % 4 == 1)
        	{
	        	for (int k = 0; k < height; k++)
	        	{
	        		result.add(matrix[i][j]);
	        		i++;
	        	}
	        	i--;
	        	width--;
	        	j--;
        	}
        	else if (count % 4 == 2)
        	{
	        	for (int k = 0; k < width; k++)
	        	{
	        		result.add(matrix[i][j]);
	        		j--;
	        	}
	        	j++;
	        	height--;
	        	i--;
        	}
        	else
        	{
	        	for (int k = 0; k < height; k++)
	        	{
	        		result.add(matrix[i][j]);
	        		i--;
	        	}
	        	i++;
	        	width--;
	        	j++;
        	}
        	count++;
        }
        return result;
    }
	public static void main(String[] args) 
	{
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		SpiralMatrix test = new SpiralMatrix();
		System.out.println(test.spiralOrder(matrix).toString());
	}
}
