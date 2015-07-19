
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) 
	{
	    if (nums.length == 0)
	        return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++)
        {
        	if (j == nums.length-1)
        	{
        		nums[i++] = nums[j];
        		break;
        	}
        	else if (nums[j+1] == nums[j])
        	{
        		j++;
        		while (j < nums.length-1 && nums[j+1] == nums[j])
        		{
        			j++;
        		}
        		nums[i++] = nums[j];
        		nums[i++] = nums[j];
        	}
        	else
        	{
        		nums[i++] = nums[j];
        	}
        }
        return i;
    }
}
