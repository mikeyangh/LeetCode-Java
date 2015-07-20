import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) 
	{
		Arrays.sort(nums);
		return subsets(nums, nums.length-1);
    }
	
	private List<List<Integer>> subsets(int[] nums, int index)
	{
		List<List<Integer>> result = new LinkedList<>();
		if (index == -1)
		{
			List<Integer> list = new LinkedList<>();
			result.add(list);
			return result;
		}
		int i;
		for (i = index-1; i >= 0 && nums[i] == nums[index]; i--) {};
		int count = index-i;
		result.addAll(subsets(nums,index-1));
		List<List<Integer>> lastList = subsets(nums, i);
		for (List<Integer> list : lastList)
		{
			for (int j = 0; j < count; j++)
			{
				list.add(nums[index]);
			}
			result.add(list);
		}
		return result;
	}
}
