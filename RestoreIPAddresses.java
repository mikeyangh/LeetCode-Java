import java.util.LinkedList;
import java.util.List;


public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) 
	{
		return seperateString(s, 0, 4);
    }
	
	private List<String> seperateString(String s, int start, int num)
	{
		List<String> result = new LinkedList<>();
		if (num*3 < s.length()-start || num > s.length()-start)
				return result;
		if (num == 1)
		{
			String last = s.substring(start);
			if (last.length() > 1 && last.charAt(0) == '0' || last.length() == 3 && last.compareTo("255") > 0)
				return result;
			result.add(last);
			return result;
		}
		List<String> list1 = seperateString(s, start+1, num-1);
		List<String> list2 = seperateString(s, start+2, num-1);
		List<String> list3 = seperateString(s, start+3, num-1);
		if (list1.size() != 0)
		{
			String preString = s.substring(start, start+1);
			for (String str : list1)
			{
				result.add(preString + "." + str);
			}
		}
		if (list2.size() != 0 && s.charAt(start) != '0')
		{
			String preString = s.substring(start, start+2);
			for (String str : list2)
			{
				result.add(preString + "." + str);
			}
		}
		if (list3.size() != 0 && s.substring(start, start+3).compareTo("255") <= 0 && s.charAt(start) != '0')
		{
			String preString = s.substring(start, start+3);
			for (String str : list3)
			{
				result.add(preString + "." + str);
			}
		}
		return result;
	}
}
