import java.util.LinkedList;
import java.util.Queue;


public class SurroundedRegions {
	public void solve(char[][] board) 
	{
		int m = board.length;
		if (m == 0)
			return;
		int n = board[0].length;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if (i == 0 || i == m-1 || j == 0 || j == n-1)
				{
					if (board[i][j] == 'O')
					{
						Queue<Integer> queue = new LinkedList<>();
						queue.add(i*n+j);
						while (!queue.isEmpty())
						{
							int poll = queue.poll();
							int row = poll/n;
							int col = poll%n;
							board[row][col] = '.';
							if (row > 0 && board[row-1][col] == 'O')
							{
								queue.add(poll-n);
								board[row-1][col] = '.';
							}
							if (row < board.length-1 && board[row+1][col] == 'O')
							{
								queue.add(poll+n);
								board[row+1][col] = '.';
							}
							if (col > 0 && board[row][col-1] == 'O')
							{
								queue.add(poll-1);
								board[row][col-1] = '.';
							}
							if (col < board[0].length-1 && board[row][col+1] == 'O')
							{
								queue.add(poll+1);
								board[row][col+1] = '.';
							}
						}
					}
				}
			}
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
			{
				if (board[i][j] == '.')
					board[i][j] = 'O';
				else
					board[i][j] = 'X';
			}
	}
}
