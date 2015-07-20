
public class DecodeWays {
	public int numDecodings(String s) 
	{
		if (s.length() == 0)
	        return 0;
		int[] ways = new int[s.length()+1];
		ways[0] = 1;
		ways[1] = (s.charAt(0) == '0'? 0 : 1);
		for (int i = 2; i <= s.length(); i++)
		{
			if (s.charAt(i-1) == '0')
			{
				if (s.charAt(i-2) > '0' && s.charAt(i-2) < '3')
					ways[i] = ways[i-2];
				else
					return 0;
			}
			else if (s.charAt(i-2) == '0')
				ways[i] = ways[i-1];
			else if (s.charAt(i-2) > '2')
				ways[i] = ways[i-1];
			else if (s.charAt(i-2) == '2' && s.charAt(i-1) > '6')
				ways[i] = ways[i-1];
			else
				ways[i] = ways[i-1] + ways[i-2];
		}
		return ways[ways.length-1];
    }
}
