
public class Searcha2DMatrix 
{
	public boolean searchMatrix(int[][] matrix, int target) 
	{
		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0;
		int high = m-1;
		
		
		if (target < matrix[0][0] || target > matrix[m-1][n-1])
			return false;
		int row = -1;
		while (high >= low)
		{
			int mid = (low+high)/2;
			if (target >= matrix[mid][0] && target <= matrix[mid][n-1])
			{
				row = mid;
				break;
			}
			else if (target < matrix[mid][0])
			{
				high = mid-1;
			}
			else if (target > matrix[mid][n-1])
			{
				low = mid+1;
			}
		}
		
		low = 0;
		high = n-1;
		while (high >= low)
		{
			int mid = (low+high)/2;
			if (target == matrix[row][mid])
				return true;
			else if (target < matrix[row][mid])
				high = mid-1;
			else if (target > matrix[row][mid])
				low = mid+1;
		}
		return false;
    }
}
