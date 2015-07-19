import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class CombinationSum 
{
	public List<List<Integer>> combinationSum(int[] candidates, int target) 
	{
		Arrays.sort(candidates);
		return recursiveSum(candidates, target, 0);
    }
	private List<List<Integer>> recursiveSum(int[] candidates, int target, int index)
	{
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (target == 0)
		{
			List<Integer> originallist = new LinkedList<Integer>();
			result.add(originallist);
			return result;
		}
		//if (candidates.length == 0)
		if (index == candidates.length)
			return result;

		int first = candidates[index];
		//int[] remain = Arrays.copyOfRange(candidates, 1, candidates.length);
		for (int j = 0; j*first <= target; j++)
		{		
			for (List<Integer> list : recursiveSum(candidates, target - j*first, index+1))
			{
					//System.out.println("!!!");
					for (int i = 0; i < j; i++)
					{
						list.add(0, first);
					}
					result.add(list);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		int[] num = new int[] {2,3,6,7};
		int target = 7;
		//int[] num = new int[] {1};
		//int target = 2;
		CombinationSum test = new CombinationSum();
		System.out.println(test.combinationSum(num, target));
	}
}
