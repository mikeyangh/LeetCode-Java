import java.util.Arrays;


public class FirstMissingPositive 
{
	public int firstMissingPositive(int[] A) 
    {
		for (int i = 0; i < A.length; i++)
		{
				int j = i;
				while (A[j] != j+1 && A[j] > 0 && A[j] <= A.length && A[j] != A[A[j]-1])
				{
						swap(A, j, A[j]-1);
						//j = A[j]-1;
				}
		}
		
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] != i+1)
			{
				return i+1;
			}
		}
		return 0;
    }
	private void swap(int[] A, int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public static void main(String[] args) 
	{
		//int[] num = {3,4,-1,1,5,7,6};
		int[] num = {1, 1};
		FirstMissingPositive test = new FirstMissingPositive();
		System.out.println(test.firstMissingPositive(num));
		System.out.println(Arrays.toString(num));
	}
}
