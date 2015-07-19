
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) 
    {
        StringBuilder longestCommonPrefix = new StringBuilder();
         int i = 0;
         if(strs.length == 0)
         {
             return "";
         }
         while (true)
         {
             char value;
             if(i == strs[0].length())
             {
                 return longestCommonPrefix.toString();
             }
             else 
             {
                 value = strs[0].charAt(i);
             }
             for (int j = 1; j < strs.length; j++)
             {
                 if (i == strs[j].length() || value != strs[j].charAt(i))
                 {
                     return longestCommonPrefix.toString();
                 }
             }
             longestCommonPrefix.append(value);
             i++;
         }
    }
}
