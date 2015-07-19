import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) 
    {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(num);
        int length = num.length;
        if (num.length < 3)
        {
        	return result;
        }
        for (int i = 0; i < length-2; i++)
        {
        	if (i==0 || num[i] != num[i-1])
        	{
        		int target = -num[i];
        		int low = i+1;
        		int high = length-1;
        		while (low < high)
        		{
        			if (num[low]+num[high] > target)
        			{
        				high--;
        			}
        			else if (num[low]+num[high] < target)
        			{
        				low++;
        			}
        			else
        			{
        				while (low+1 < high && num[low] == num[low+1])
        				{
        					low++;
        				}
        				while (low < high-1 && num[high] == num[high-1])
        				{
        					high--;
        				}
        				if (high > low)
        				{
        					result.add(Arrays.asList(num[i],num[low],num[high]));
        					low++;
        				}   					
        			}
        		}
        	}
        }
        return result;    
    }
}
