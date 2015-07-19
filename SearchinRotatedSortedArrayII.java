
public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target)
	{
		int start = 0;
		int end = nums.length-1;
		while (end >= start)
		{
			int mid = (start+end)/2;
			if (nums[mid] == target)
				return true;
			if (nums[mid] < nums[start]) // right half is sorted
			{
				if (nums[mid] < target && nums[end] >= target)
					start = mid+1;
				else
					end = mid-1;
			}
			else if (nums[mid] > nums[start]) // left half is sorted
			{
				if (nums[start] <= target && nums[mid] > target)
					end = mid-1;
				else
					start = mid+1;
			}
			else
				start++;
		}
		return false;
	}
}
