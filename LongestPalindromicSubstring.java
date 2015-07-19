
public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        String palindromicString = null;
        int length = 0;
        int i, j, center;
        for (center = 0; center < s.length(); center++)
        {
            //odd
            i = center;
            j = center;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
            {
                if (j-i+1 > length)
                {
                    length = j-i+1;
                    palindromicString = s.substring(i,j+1);
                }
                i--;
                j++;
            }
            //even
            i = center;
            j = center+1;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j))
            {
                if (j-i+1 > length)
                {
                    length = j-i+1;
                    palindromicString = s.substring(i,j+1);
                }
                i--;
                j++;
            }
        }      
        return palindromicString;  
    }
}
