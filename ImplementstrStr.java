
public class ImplementstrStr {
	public int strStr(String haystack, String needle) 
    {
        if (needle.length() == 0)
            return 0;
        int index = -1;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++)
        {
            int k = i;
            for (int j = 0; j < needle.length() && haystack.charAt(k++) == needle.charAt(j++);)
            {
                if (j == needle.length())
                    return i;
            }
        }
        return index;
    }
}
