
public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
        int sLength = s.length();
		int pLength = p.length();
		if (sLength == 0 && pLength == 0)
		{
			return true;
		}
		if (pLength == 0)
		{
			return sLength == 0;
		}
	
		
		return match(s, p, 0, 0);
    }
    
    
    public boolean match(String s, String p, int i, int j)
	{
	    if(i == s.length())
		{
			if(j+1 >= p.length() || p.charAt(j+1) != '*')
			{
				return false;
			}
			else
			{
				if(j+2 == p.length())
				{
					return true;
				}
				else
				{
					return match(s, p, i, j+2);
				}
			}
		}
	    
	    
		if (j+1 >= p.length() || p.charAt(j+1) != '*')
		{
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
			{
				if (i == s.length()-1 && j == p.length()-1)
				{
					return true;
				}
				else if (j == p.length()-1)
				{
					return false;
				}
				else
				{
					return match(s, p, i+1, j+1);
				}
			}
			else
			{
				return false;
			}
		}
		if (p.charAt(j+1) == '*')
		{
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
			{
				if (i == s.length()-1 && j == p.length()-2)
				{
					return true;
				}
				else if (i == s.length()-1)
				{
					return (match(s, p, i+1, j)||match(s, p, i, j+2));
				}
				else if (j == p.length()-2)
				{
					return match(s, p, i+1, j);
				}
				else
				{
					return (match(s, p, i, j+2) || match(s, p, i+1, j));
				}
			}
			else
			{
				if (j == p.length()-2)
				{
					return false;
				}
				else
				{
					return match(s, p, i, j+2);
				}
			}
		}
		return true;
	}
}
