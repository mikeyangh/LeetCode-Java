

public class RemoveElement 
{
	public int removeElement(int[] A, int elem) 
	{
		int length = A.length;
		for (int i = 0; i < length; i++)
		{
			if (A[i] == elem)
				A[i--] = A[length-- -1];
		}
		return length;		
    }
	public static void main(String[] args)
	{
		
	}
}
