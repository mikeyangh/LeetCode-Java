import java.util.HashSet;


public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) 
	{
        HashSet<Integer> hash = new HashSet<>();
        for (int num : nums)
        	hash.add(num);
        int max = 0;
        for (int i = 0; i < nums.length; i++)
        {
        	int num = nums[i];
        	if (!hash.contains(num))
        		continue;     	
        	int temp = 1;
        	int right = num+1;
        	int left = num-1;
        	while (hash.contains(right))
        	{
        		hash.remove(right);
        		temp++;
        		right++;
        	}
        	while (hash.contains(left))
        	{
        		hash.remove(left);
        		temp++;
        		left--;
        	}
        	if (temp > max)
        		max = temp;
        }
        return max;
    }
}
