import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Anagrams 
{
	public List<String> anagrams(String[] strs) 
	{
		List<String> result = new LinkedList<>();
		HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
		for (String str : strs)
		{
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String orderStr = String.valueOf(ch);
			if (hash.containsKey(orderStr))
			{
				List<String> list = hash.get(orderStr);
				list.add(str);
			}
			else
			{
				List<String> list = new LinkedList<>();
				list.add(str);
				hash.put(orderStr, list);
			}
		}
		//System.out.println(hash.toString());
		for (String str : hash.keySet())
		{
			if (hash.get(str).size() > 1)
			{
				result.addAll(hash.get(str));
			}
		}
		return result;
    }
	
	public static void main(String[] args) 
	{
		/*
		String str = "";
		char[] ch = str.toCharArray();
		System.out.println(Arrays.toString(ch));
		String s = new String(ch);
		System.out.println(s);*/
		String[] strs = {"",""};
		Anagrams test = new Anagrams();
		System.out.println(test.anagrams(strs));
	}
}
