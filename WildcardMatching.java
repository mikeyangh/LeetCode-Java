
public class WildcardMatching 
{
	/*
	public boolean isMatch(String s, String p) 
	{
		
		if (s.length() == 0 && p.length() == 0)
		{
			return true;
		}
		if (p.length() == 0)
			return false;
		int i = 0;
		int j = 0;
		while (j < p.length())
		{
			if (p.charAt(j) != '*')
			{
				if (s.length() == i || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '?'))
				{
					return false;
				}
				else
				{
					i++;
					j++;
				}
			}
			else
			{
				if (i == s.length())
				{
					j++;
				}
				else
				{
					if (j+1 < p.length() && p.charAt(j+1) == '*')
						j++;
					else
						return  isMatch(s.substring(i+1), p.substring(j)) || isMatch(s.substring(i), p.substring(j+1));
				}
			}
		}
		if (i >= s.length())
			return true;
		else
			return false;
    }*/
	public boolean isMatch(String s, String p)
	{
		int i = 0;
		int j = 0;
		int lastStar = -1;
		int matched = 0;
		while (i < s.length())
		{
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)))
			{
				i++;
				j++;
			}
			else if (j < p.length() && p.charAt(j) == '*')
			{
				matched = i;
				lastStar = j;
				j++;
			}
			else if (lastStar != -1)
			{
				matched++;
				i = matched;
				j = lastStar + 1;
			}
			else
			{
				return false;
			}
		}
		while (j < p.length() && p.charAt(j) == '*')
			j++;
		return j == p.length();
	}
	public static void main(String[] args) 
	{
		WildcardMatching test = new WildcardMatching();
		//System.out.println(test.isMatch("aab", "c*a*b"));
		//System.out.println(test.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
		System.out.println(test.isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));
	}
}
