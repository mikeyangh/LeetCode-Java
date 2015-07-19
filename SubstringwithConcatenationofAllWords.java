import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SubstringwithConcatenationofAllWords 
{
	public List<Integer> findSubstring(String S, String[] L) 
    {
		List<Integer> result = new ArrayList<Integer>();
		if (L.length == 0 || S.length() == 0)
			return result;
		int interval = L[0].length();
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : L)
		{
			if (!map.containsKey(str))
				map.put(str, 1);
			else
				map.put(str, map.get(str)+1);
		}
		for (int i = 0; i + interval*L.length-1 < S.length(); i++)
		{
			//int j = i;
			HashMap<String, Integer> newMap = new HashMap<>();
			for (int j = 0; j < L.length; j++)
			{
				String substring = S.substring(i+j*interval, i+(j+1)*interval);
				if (!map.containsKey(substring))
					break;
				newMap.put(substring, newMap.containsKey(substring)? newMap.get(substring)+1 : 1);
				if (newMap.get(substring) > map.get(substring))
					break;
			}
			if (newMap.equals(map))
				result.add(i);
		}
		
		return result;
    }
	public static void main(String[] args)
	{
		String S = "barfoothefoobarman";
		String[] L = {"foo","bar"};
		SubstringwithConcatenationofAllWords test = new SubstringwithConcatenationofAllWords();
		System.out.println(test.findSubstring(S, L).toString());
	}
}
