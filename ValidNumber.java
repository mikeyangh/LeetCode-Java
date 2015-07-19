
public class ValidNumber 
{
	public boolean isNumber(String s) 
	{
		s = s.trim();
		if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
		    s = s.substring(1);
		if (s.length() == 0)
			return false;
	
		boolean haveDot = false; //already have '.' ?
		boolean haveE = false;  //already have 'e' ?
		boolean haveNumber = false; //already have number?
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
			{
				haveNumber = true;
			}
			else if (s.charAt(i) == '.')
			{
				if (haveDot || haveE)
				    return false;
				if (!haveNumber && i == s.length()-1)
				    return false;
				haveDot = true;
			}
			else if (s.charAt(i) == 'e')
			{
				if (haveE)
				    return false;
				if (!haveNumber)
				    return false;
				if (i+1 < s.length() && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-'))
				    i++;
				if (i == s.length()-1)
				    return false;
				haveE = true;
			}
			else
				return false;
		}
		return true;
    }
	public static void main(String[] args) 
	{
		
	}
}
