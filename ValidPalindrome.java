
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s.length() == 0)
        	return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length()-1; j >= i; i++, j--)
        {
        	while (i < s.length()-1 && !isAlphanumeric(s.charAt(i)))
        		i++;
        	while (j >= 0 && !isAlphanumeric(s.charAt(j)))
        		j--;
        	if (i <= j)
        	{
        		if (s.charAt(i) != s.charAt(j))
        			return false;
        	}
        }
        return true;
    }
	
	public boolean isAlphanumeric(char ch)
	{
		if (ch >= 'a' && ch <= 'z')
			return true;
		if (ch >= '0' && ch <= '9')
			return true;
		return false;
	}
}
