
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
        int[][] matrix = new int[s.length()+1][t.length()+1];
        matrix[0][0] = 1;
        for (int i = 1; i <= s.length(); i++)
        	matrix[i][0] = 1;
        for (int i = 1; i <= t.length(); i++)
        	matrix[0][i] = 0;
        for (int i = 1; i <= s.length(); i++)
        {
        	for (int j = 1; j <= t.length(); j++)
        	{
        		if (s.charAt(i-1) == t.charAt(j-1))
        		{
        			matrix[i][j] = matrix[i-1][j]+matrix[i-1][j-1];
        		}
        		else
        			matrix[i][j] = matrix[i-1][j];
        	}
        }
        return matrix[s.length()][t.length()];
    }
}
