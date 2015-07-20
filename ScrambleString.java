import java.util.Arrays;


public class ScrambleString {
	/*
    public boolean isScramble(String s1, String s2) 
	{
		if(s1==null || s2==null) return false;
		if (s1.equals(s2))
			return true;
		if (s1.length() != s2.length())
			return false;
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		if (!Arrays.equals(array1, array2))
			return false;
		for (int i = 1; i < s1.length(); i++)
		{
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
					&& isScramble(s1.substring(i), s2.substring(i)))
					return true;
			if (isScramble(s1.substring(0, i), s2.substring(s2.length()-i)) 
					&& isScramble(s2.substring(0, i), s1.substring(s1.length()-i)))
				return true;
		}
		return false;
		
    }*/
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;
        for(int i=1; i<s1.length(); i++)
        {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i)))                   return true;
        }
        return false;
    }
}
