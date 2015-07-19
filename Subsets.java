import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Subsets {
	public List<List<Integer>> subsets(int[] nums) 
    {
        Arrays.sort(nums);
        return recursiveSubsets(nums, nums.length);
    }
	private List<List<Integer>> recursiveSubsets(int[] nums, int length)
	{
		List<List<Integer>> result = new LinkedList<>();
        if (length == 0)
        {
        	List<Integer> list = new LinkedList<>();
        	result.add(list);
        	return result;
        }
        for (List<Integer> list : recursiveSubsets(nums, length-1))
        {
        	result.add(list);
        }
        for (List<Integer> list : recursiveSubsets(nums, length-1))
        {
        	list.add(nums[length-1]);
        	result.add(list);
        }
        return result;
	}
}
