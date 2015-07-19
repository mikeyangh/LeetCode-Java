import java.util.Arrays;


public class RemoveDuplicatesfromSortedArray 
{	
	public int removeDuplicates(int[] A) 
    {
		if (A.length == 0)
			return 0;
		int i = 0;
		for (int j = 0; j < A.length; j++)
		{
			if (A[i] != A[j])
			{
				i++;
				A[i] = A[j];
			}
		}
		return ++i;    
    }
	public static void main(String[] args)
	{
		int[] array = {1,1,2,2,2,3,3,3,3,3,3,3,5,5,5,5};
		int count = 0;
		for (int i = 0; i < array.length; i++)
		{
			count++;
			int num = array[i];
			for (int j = i+1; j < array.length; j++)
			{
				if (array[j] != array[i])
				{
					int interval = j - i;
					while(j < array.length)
					{
						array[j-interval+1] = array[j];
						j++;
					}
					array = Arrays.copyOfRange(array, 0, array.length-interval+1);
					//System.out.println(array.toString());
					break;
				}
				if (j == array.length - 1)
				{
					array = Arrays.copyOfRange(array, 0, i+1);
				}
				
			}

		}
		/*
		for (int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}*/
		
		System.out.println(count);
	}
}
