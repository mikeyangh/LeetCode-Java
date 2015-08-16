import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning 
{
	public List<List<String>> partition(String s) {
        return subPartition(s, s.length()-1);
    }
	
	private List<List<String>> subPartition(String s, int end)
	{
		List<List<String>> result = new LinkedList<>();
		List<String> list = new LinkedList<>();
		if (end == -1)
		{
			result.add(list);
			return result;
		}
		if (end == 0)
		{
			list.add(s.substring(0, 1));
			result.add(list);
			return result;
		}
		for (int i = 0; i <= end; i++)   //scan from left to right, find palindrome
		{
			boolean flag = true;
			for (int j = i, k = end; j <= k; j++, k--)
			{
				if (s.charAt(j) != s.charAt(k))
				{
					flag = false;
					break;
				}
			}
			if (flag)           // combine palindrome tail and backtrack
			{
				String tail = s.substring(i, end+1);
				List<List<String>> last = subPartition(s, i-1);
				for (List<String> head : last)
				{
					head.add(tail);
					result.add(head);
				}
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		System.out.println(test.partition("aabcb"));
	}
	
	
}
