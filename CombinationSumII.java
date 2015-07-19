import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII 
{
	public List<List<Integer>> combinationSum2(int[] num, int target) 
	{
		Arrays.sort(num);
		return recursiveSum(num, target, 0);
    }
	private List<List<Integer>> recursiveSum(int[] num, int target, int index)
	{
		System.out.println(index);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (target == 0)
		{
			LinkedList<Integer> firstList = new LinkedList<Integer>();
			result.add(firstList);
		}
		
		if (index == num.length || num[index] > target)
		{
			return result;
		}
		int first = num[index];
		
		int nextindex = index + 1;
		while (nextindex < num.length && num[nextindex] == num[index])
			nextindex++;
		for (int i = 0; i*first <=target && i <= nextindex-index; i++)
		{
			for (List<Integer> list : recursiveSum(num, target - i*first, nextindex))
			{
				for (int j = 0; j < i; j++)
				{
					list.add(0, first);
				}
				System.out.println(list);
				result.add(list);
			}
		}
		return result;
	}
	public static void main(String[] args) 
	{
		int[] num = new int[] {10,1,2,7,6,1,5};
		int target = 8;
		//int[] num = new int[] {1};
		//int target = 2;
		CombinationSumII test = new CombinationSumII();
		System.out.println(test.combinationSum2(num, target));
	}
}
