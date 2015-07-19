import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Permutations {
	public List<List<Integer>> permute(int[] num) 
	{
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
			swap(temp, i, num.length-1);
			int[] subarray = Arrays.copyOf(temp, num.length-1);
			for (List<Integer> list : permute(subarray))
			{
				list.add(temp[num.length-1]);
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
		int[] num = {1,2,3};
		Permutations test = new Permutations();
		System.out.println(test.permute(num).toString());
	}
}
