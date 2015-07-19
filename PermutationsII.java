import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) 
	{
		/*
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (num.length == 1)
		{
			List<Integer> first = new LinkedList<Integer>();
			first.add(num[0]);
			result.add(first);
		}
		
		for (int i = 0; i < num.length; i++)
		{
			int[] temp = Arrays.copyOf(num, num.length);
			Arrays.sort(temp);
			int j = i;
			while (j+1 < num.length && temp[j+1] == temp[j])
			{
				j++;
			}
			i = j;
			//System.out.println(j);
			swap(temp, j, num.length-1);
			int[] subarray = Arrays.copyOf(temp, num.length-1);
			for (List<Integer> list : permuteUnique(subarray))
			{
				list.add(temp[num.length-1]);
				result.add(list);
			}
		}
		return result;*/
		return recursivePermute(num, num.length-1);
    }
	private List<List<Integer>> recursivePermute(int[] num, int end)
	{
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (end == 0)
		{
			List<Integer> first = new LinkedList<Integer>();
			first.add(num[0]);
			result.add(first);
		}
		
		for (int i = 0; i <= end; i++)
		{
			int[] temp = Arrays.copyOf(num, end+1);
			Arrays.sort(temp);
			int j = i;
			while (j+1 <= end && temp[j+1] == temp[j])
			{
				j++;
			}
			i = j;
			//System.out.println(j);
			swap(temp, j, end);
			//int[] subarray = Arrays.copyOf(temp, num.length-1);
			for (List<Integer> list : recursivePermute(temp, end - 1))
			{
				list.add(temp[end]);
				result.add(list);
			}
		}
		return result;
	}
	private void swap(int[] num, int i, int j)
	{
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
    }
	public static void main(String[] args) 
	{
		PermutationsII test = new PermutationsII();
		int[] num = new int[] {1,1,2};
		System.out.println(test.permuteUnique(num).toString());
	}
}
