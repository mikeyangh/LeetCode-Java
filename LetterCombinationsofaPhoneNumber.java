import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class LetterCombinationsofaPhoneNumber {
	private HashMap<Character, String> map = new HashMap<Character, String>();
	public List<String> letterCombinations(String digits) 
    {
        //HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return searchCombinations(digits);
    }
	private List<String> searchCombinations(String digits)
	{

		List<String> list = new LinkedList<>();
		if (digits.length() == 0)
		{
			return list;
		}
		if (digits.length() == 1)
		{
			String str = map.get(digits.charAt(0));
			for (int i = 0; i < str.length(); i++)
			{
				list.add(str.substring(i, i+1));
			}
			return list;
		}
		
		String last_digits = digits.substring(1);
		char head = digits.charAt(0);
		String headString = map.get(head);
		for (String str : searchCombinations(last_digits))
		{
			for (int i = 0; i < headString.length(); i++)
			{
				list.add(headString.substring(i, i+1).concat(str));
			}
		}
		return list;
	}
}
