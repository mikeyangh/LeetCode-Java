
public class SpiralMatrixII 
{
	public int[][] generateMatrix(int n)  
	{
		int[][] matrix = new int[n][n];
		int num = 1;
		int width = n;
		int height = n;
		int i = 0;
		int j = 0;
		int count = 0;
		while(width > 0 && height > 0)
		{
			if (count % 4 == 0)
			{
				for (int a = 0; a < width; j++, a++)
				{
					matrix[i][j] = num;
					num++;
				}
				j--;
				i++;
				height--;	
			}
			else if (count % 4 == 1)
			{
				for (int a = 0; a < height; i++, a++)
				{
					matrix[i][j] = num;
					num++;
				}
				i--;
				j--;
				width--;
			}
			else if (count % 4 == 2)
			{
				for (int a = 0; a < width; j--, a++)
				{
					matrix[i][j] = num;
					num++;
				}
				j++;
				i--;
				height--;
			}
			else
			{
				for (int a = 0; a < height; i--, a++)
				{
					matrix[i][j] = num;
					num++;
				}
				i++;
				j++;
				width--;
			}
			count++;
		}
		return matrix;
	}
	public static void main(String[] args) 
	{
		
	}
}
