import java.util.Arrays;


public class RotateImage 
{
	public void rotate(int[][] matrix) 
	{
		int n = matrix.length;
		int plus = 0;
		if (n%2 != 0)
			plus = 1;
		for (int i = 0; i < n/2 + plus; i++)
		{
			for (int j = 0; j < n/2; j++)
			{
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
    }
	public static void main(String[] args) 
	{
		int matrix[][] = new int[4][4];
		int x = 1;
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				matrix[i][j] = x;
				x++;
			}
		for (int i = 0; i < 4; i++)
			System.out.println(Arrays.toString(matrix[i]));
		RotateImage test = new RotateImage();
		test.rotate(matrix);
		for (int i = 0; i < 4; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

}
