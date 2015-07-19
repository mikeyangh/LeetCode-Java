import java.util.Arrays;


public class MaximumSubarray {
	public int maxSubArray(int[] A) 
	{
		if (A.length == 0)
			return 0;
		int[] max = new int[A.length];
		max[0] = A[0];
		int result = max[0];
		for (int i = 1; i < A.length; i++)
		{
			max[i] = Math.max(max[i-1]+A[i], A[i]);
			if (max[i] > result)
			    result = max[i];
		}
		return result;
	}
	public static void main(String[] args) 
	{
		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray test = new MaximumSubarray();
		System.out.println(test.maxSubArray(num));
	}
}
