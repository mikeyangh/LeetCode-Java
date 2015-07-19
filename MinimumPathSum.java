
public class MinimumPathSum 
{
	public int minPathSum(int[][] grid) 
    {
		int m = grid.length;
		int n = grid[0].length;
		int[][] minPathSum = new int[m][n];
		minPathSum[0][0] = grid[0][0];
		for (int i = 1; i < m; i++)
		{
			minPathSum[i][0] = minPathSum[i-1][0] + grid[i][0];
		}
		for (int i = 1; i < n; i++)
		{
			minPathSum[0][i] = minPathSum[0][i-1] + grid[0][i];
		}
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				minPathSum[i][j] = Math.min(minPathSum[i-1][j], minPathSum[i][j-1]) + grid[i][j];
		return minPathSum[m-1][n-1];
    }
	public static void main(String[] args) 
	{
		
	}
}
