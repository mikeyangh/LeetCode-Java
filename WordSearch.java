
public class WordSearch {
	public boolean exist(char[][] board, String word) 
	{
		if (word.length() == 0)
			return true;
		int m = board.length;
		int n = board[0].length;
		boolean[][] marked = new boolean[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				//boolean[][] marked = new boolean[m][n];  //no need
				if (validPath(m, n, i, j, board, word, marked, 0))
					return true;
			}
		return false;
    }
	
	boolean validPath(int m, int n, int i, int j, char[][] board, String word, boolean[][] marked, int index)
	{
		if (word.length() == index)
			return true;
		if (i < 0 || j < 0 || i >= m || j >= n || marked[i][j])
			return false;
		if (board[i][j] != word.charAt(index))
			return false;
		marked[i][j] = true;

		boolean result = validPath(m, n, i-1, j, board, word, marked, index+1) ||
		validPath(m, n, i+1, j, board, word, marked, index+1) ||
		validPath(m, n, i, j-1, board, word, marked, index+1) ||
		validPath(m, n, i, j+1, board, word, marked, index+1);
		marked[i][j] = false;
		return result;
	}
}
