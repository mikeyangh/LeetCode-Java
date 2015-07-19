import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class SetMatrixZeroes
{
	public void setZeroes(int[][] matrix) 
	{
		int m = matrix.length;
		int n = matrix[0].length;
		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> cols = new HashSet<>();
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (matrix[i][j] == 0)
				{
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for (Integer i : rows)
		{
			for (int j = 0; j < n; j++)
				matrix[i][j] = 0;
		}
		for (Integer j : cols)
		{
			for (int i = 0; i < m; i++)
				matrix[i][j] = 0;
		}
    }
	public static void main(String[] args) 
	{
		
	}
}
