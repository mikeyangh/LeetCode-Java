import java.util.Arrays;


public class NextPermutation 
{	
	public void nextPermutation(int[] num) 
	{
		int length = num.length;
		int index1 = -1;
		int index2 = -1;
		if (length <= 1)
			return;
		
		//int maxIndex = length-1;
		for (int i = length-2; i >=0; i--)
		{
			int candidate = Integer.MAX_VALUE;
			if (num[i] < num [i+1])
			{
				for (int j = length-1; j > i; j--)
				{
					if (num[j] > num[i] && num[j] < candidate)
					{
						candidate = num[j];
						index2 = j;
						index1 = i;
					}
				}
				if (index1 != -1)
				{
					swap(num, index1, index2);
					break;
				}
			}
		}
		reverse(num, index1+1);
		/*
		for (int i = index1+1; i < length; i++)
		{
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for (int j = i; j < length; j++)
			{
				if (num[j] < min)
				{
					minIndex = j;
					min = num[j];
				}
			}
			swap(num, i, minIndex);
		}*/
    }
	private void swap(int[] num,int i, int j)
	{
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	private void reverse(int[] num,int index)
	{
		for (int i = index, j = num.length-1; i < j; i++, j--)
		{
			swap(num, i, j);
		}
	}
	public static void main(String[] args)
	{
		NextPermutation test = new NextPermutation();
		//int[] num = {7,5,2,3,6,1};
		//int[] num = {7,5,1,3,6,2};
		//int[] num = {4,2,0,2,3,2,0};
		int[] num = {1, 3, 2};
		test.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}
