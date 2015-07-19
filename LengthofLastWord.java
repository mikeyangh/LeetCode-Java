
public class LengthofLastWord {
	public int lengthOfLastWord(String s) 
    {
        for (int i = s.length()-1; i >= 0; i--)
        {
            if (s.charAt(i) != ' ')
            {
                int end = i;
                while (i >= 0 && s.charAt(i) != ' ')
                {
                    i--;
                }
                return end-i;
            }
        }
        return 0;
    }
}
