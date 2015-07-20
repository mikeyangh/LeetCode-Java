
public class UniqueBinarySearchTrees {
	public int numTrees(int n) 
	{
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int[] numTrees = new int[n+1];
		numTrees[0] = 1;
		numTrees[1] = 1;
		for (int i = 2; i <= n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				numTrees[i] += numTrees[j]*numTrees[i-j-1];
			}
		}
		return numTrees[n];
    }
}
