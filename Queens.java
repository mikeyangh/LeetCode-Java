import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Queens {
	public List<String[]> solveNQueens(int n) 
	{
		List<String[]> result = new LinkedList<>();
		List<Integer> list = new LinkedList<>();
		char [][] matrix = new char[n][n];
		for (int a = 0; a < n; a++)
			for (int b = 0; b < n; b++)
				matrix[a][b] = '.';
		//boolean[] solvable = new boolean[n];
		int i = 0; 
		int j = 0;
		while (true)
		{
			if (j == n)
			{
				if (list.size() == 0)
					break;
				//solvable[i] = false;
				i--;
				int index = list.remove(list.size()-1);
				j = index+1;
				continue;
			}
			boolean flag = true;
			for (int k = 0; k < list.size(); k++)
			{
				int kj = list.get(k);
				if (k-i == kj-j || k-i == j-kj ||kj == j)					
				{
					flag = false;
					break;
				}
			}
			if (flag)
			{
				list.add(j);
				//solvable[i] = true;
				if (i < n-1)
				{
					i++;
					j = 0;
				}
				else
				{
					String[] str = new String[n];
					char [][] output = new char[n][n];
					for (int a = 0; a < n; a++)
						for (int b = 0; b < n; b++)
							matrix[a][b] = '.';
					for (int k = 0; k < n; k++)
						output[k] = matrix[k].clone();
					
					for (int k = 0; k < list.size(); k++)
						output[k][list.get(k)] = 'Q';
					for (int k = 0; k < n; k++)
						str[k] = String.valueOf(output[k]);
					result.add(str);
					
					j++;
					list.remove(list.size()-1);
					//solvable[i] = false;
				}
			}
			else
				j++;
		}	
		return result;
    }
	public static void main(String[] args) 
	{
		Queens test = new Queens();
		List result = test.solveNQueens(4);
		for (int i = 0; i < result.size(); i++)
		{
			String[] strs = (String[]) result.get(i);
			System.out.println(Arrays.toString(strs));
		}
		System.out.println(test.solveNQueens(4).toString());
	}
}
