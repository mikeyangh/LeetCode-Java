
public class SortColors 
{
	public void sortColors(int[] A) 
	{
		int i = 0;
		int low = 0;
		int high = A.length-1;
		while (low <= high)
		{
			if (A[i] == 0)
				swap(A, i++, low++);
			else if (A[i] == 2)
				swap(A, i, high--);
			else
				i++;
		}
    }
	private void swap(int[] A, int x, int y)
	{
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
}
