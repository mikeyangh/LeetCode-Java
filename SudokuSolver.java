import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;


public class SudokuSolver 
{
	
	public void solveSudoku(char[][] board) 
	{
		solvable(board, 0, 0);
    }
	private boolean solvable(char[][] board, int x, int y)
	{
		if (x == 9)
		{
			x = 0;
			y++;	
		}
		if (y == 9)
			return true;
		if (board[x][y] != '.')
			return solvable(board, x+1, y);
		else
		{
			for (Character ch : candidate(board, x, y))
			{
				board[x][y] = ch;
				if (solvable(board, x, y))
					return true;
			}
			board[x][y] = '.';
			return false;
		}
		
		
	}
	
	private HashSet<Character> candidate(char[][] board, int x, int y)
	{
		HashSet<Character> hash = new HashSet<>();
		for (int i = 0; i < 9; i++)
		{
			hash.add(board[x][i]);
		}
		for (int i = 0; i < 9; i++)
		{
			hash.add(board[i][y]);
		}
		for (int i = x/3*3; i < x/3*3+3; i++)
		{
			for (int j = y/3*3; j < y/3*3+3; j++)
			{
				hash.add(board[i][j]);
			}
		}
		HashSet<Character> candidates = new HashSet<>();
		for (int i = 1; i < 10; i++)
		{
			char ch = (char) (i + 48);
			if (!hash.contains(ch))
				candidates.add(ch);
		}
		return candidates;
	}
	
	private boolean isValidStep(char[][] board, int x, int y)
	{
		HashSet<Character> hash1 = new HashSet<>();
		for (int i = 0; i < 9; i++)
		{
			char ch = board[x][i];
			if (ch != '.' && hash1.contains(ch))
				return false;
			else
				hash1.add(ch);
		}
		HashSet<Character> hash2 = new HashSet<>();
		for (int i = 0; i < 9; i++)
		{
			char ch = board[i][y];
			if (ch != '.' && hash2.contains(ch))
				return false;
			else
				hash2.add(ch);
		}
		return isValidBox(x/3, y/3, board);
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
	public static void main(String[] args) 
	{
		char[][] board = new char[9][9];
		board[0] = new char[] {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
		board[1] = new char[] {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
		board[2] = new char[] {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
		board[3] = new char[] {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
		board[4] = new char[] {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
		board[5] = new char[] {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
		board[6] = new char[] {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
		board[7] = new char[] {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
		board[8] = new char[] {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
		
		SudokuSolver test = new SudokuSolver();
		test.solveSudoku(board);
		//board[0] = new char[] {'5', '3', '1', '2', '7', '3', '.', '.', '.'};
		
		
		for (int i = 0; i < 9; i++)
		{
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
		
	}
}
