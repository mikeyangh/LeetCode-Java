import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class MinimumWindowSubstring 
{
	public String minWindow(String S, String T)
	{
		HashMap <Character, Integer> hashT = new HashMap<>();
		for (int i = 0; i < T.length(); i++)
		{
			char ch = T.charAt(i);
			if (hashT.containsKey(ch))
				hashT.put(ch, hashT.get(ch)+1);
			else
				hashT.put(ch, 1);
		}
		HashMap <Character, Integer> window = new HashMap<>();
		int end = 0;
		int start = 0;
		int count = 0;
		int length = Integer.MAX_VALUE;
		for (int i = 0, j = 0; j < S.length(); j++)
		{
			char ch = S.charAt(j);
			if (!hashT.containsKey(ch))
				continue;
			window.put(ch, window.containsKey(ch)? window.get(ch) + 1 : 1);
			if (window.get(ch) <= hashT.get(ch))
				count++;
			if (count == T.length())
			{
				while (i < S.length())
				{
					char remove = S.charAt(i);
					if (hashT.containsKey(remove))
					{
						if (window.get(remove) > hashT.get(remove))
						{
							window.put(remove, window.get(remove)-1);
						}
						else
							break;
					}
					i++;
				}
				char remove = S.charAt(i);
				if (j-i+1 < length)
				{
					length = j - i + 1;
					start = i;
					end = j+1;
				}
				
				i++;
				window.put(remove, window.get(remove)-1);
				count--;
				
			}
		}
		return S.substring(start, end);
	}
	
	
	public static void main(String[] args) 
	{
		String S = "ADOBECODEBANC";
		String T = "ABC";
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow(S, T));
	}
}
