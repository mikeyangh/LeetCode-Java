import java.util.HashSet;


public class ValidSudoku 
{
	public boolean isValidSudoku(char[][] board) 
	{
		if (board.length != 9)
			return false;
		if (board[0].length != 9)
			return false;
		for (int i = 0; i < 9; i++)
		{
			HashSet<Character> hash = new HashSet<>();
			for (int j = 0; j < 9; j++)
			{
				char ch = board[i][j];
				if (ch != '.' && hash.contains(ch))
					return false;
				else
					hash.add(ch);
			}
		}
		
		for (int i = 0; i < 9; i++)
		{
			HashSet<Character> hash = new HashSet<>();
			for (int j = 0; j < 9; j++)
			{
				char ch = board[j][i];
				if (ch != '.' && hash.contains(ch))
					return false;
				else
					hash.add(ch);
			}
		}
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (!isValidBox(i, j, board))
					return false;
			}
		}
        return true;
    }
	private boolean isValidBox(int x, int y,char[][] board)
	{
		HashSet<Character> hash = new HashSet<>();
		for (int i = x*3; i < x*3+3; i++)
		{
			for (int j = y*3; j < y*3+3; j++)
			{
				char ch = board[i][j];
				if (ch != '.' && hash.contains(ch))
					return false;
				else
					hash.add(ch);
			}
		}
		return true;
	}
	public static void main(String[] args) {
		
	}
}
