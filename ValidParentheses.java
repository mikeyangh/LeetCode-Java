
public class ValidParentheses 
{
	public boolean isValid(String s) 
    {
		if (s.length() == 0)
			return true;
        if (s.charAt(0) == '(')
        {
        	for (int i = 0; i < s.length(); i++)
        	{
        		if(s.charAt(i) == ')')
        		{
        			if (isValid(s.substring(1, i)) && isValid(s.substring(i+1)))
        			{
        				return true;
        			}
        		}
        	}
        	return false;
        }
        else if (s.charAt(0) == '{')
        {
        	for (int i = 0; i < s.length(); i++)
        	{
        		if(s.charAt(i) == '}')
        		{
        			if (isValid(s.substring(1, i)) && isValid(s.substring(i+1)))
        			{
        				return true;
        			}
        		}	
        	}
        	return false;
        }
        else if (s.charAt(0) == '[')
        {
        	for (int i = 0; i < s.length(); i++)
        	{
        		if(s.charAt(i) == ']')
        		{
        			if (isValid(s.substring(1, i)) && isValid(s.substring(i+1)))
        			{
        				return true;
        			}
        		}	
        	}
        	return false;
        }
        return false;
    }
	public static void main(String[] args)
	{
		String str = "[({(())}[()])]";
		String newstr = str.substring(14);
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid(str));
		System.out.println(test.isValid(newstr));
	}
}
