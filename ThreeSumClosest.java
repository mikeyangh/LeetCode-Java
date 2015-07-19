import java.util.Arrays;


public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) 
    {
        int length = num.length;
		//int error = Integer.MAX_VALUE;
		int minError = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < length-2; i++)
		{
			int remain = target-num[i];
			int low = i+1;
			int high = length-1;
			while (low < high)
			{
				int error = num[low]+num[high]-remain;
				if (Math.abs(error) < Math.abs(minError))
				{
					minError = error;
				}	
				if (error > 0)
				{
					high--;
				}
				else if (error < 0)
				{
					low++;
				}
				else
				{
					return target;
				}
				//System.out.println(error);
			}
		}
		return target+minError;
        
    }
}
