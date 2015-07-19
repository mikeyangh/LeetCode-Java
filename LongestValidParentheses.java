import java.util.Arrays;


public class LongestValidParentheses {
	/*
	public int longestValidParentheses(String s) 
    {
		if (s.length() == 0)
			return 0;
		int left = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
				left++;
			else
			{
				//left--;
				if (--left >= 0)
					count += 2;
			}
			if (left < 0)
			{
				break;
			}
			if (i == s.length()-1)
			{
				return count;
			}
		}
		System.out.println(count);
		int next = longestValidParentheses(s.substring(count+1));
		return count > next ? count : next;
    }*/
	/*
	public int longestValidParentheses(String s)
	{
		if (s.length() == 0)
			return 0;
		if (s.charAt(0) == ')')
			return longestValidParentheses(s.substring(1));
		else
		{
			if (s.charAt(s.length()-1) == ')')
				return 2 + longestValidParentheses(s.substring(0,s.length()-1));
			else
				return longestValidParentheses(s.substring(0, s.length()-1));
		}
	}*/
	public int longestValidParentheses(String s)
	{
		if (s.length() == 0)
			return 0;
		int[] V = new int[s.length()];
		int left = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				left++;
				V[i] = 0;
			}
			else
			{
				//left--;
				if (left > 0)
				{
					left--;
					int temp = V[i-1] + 2;
					//System.out.println(i-temp);
					if (i - temp < 0)
						V[i] = temp;
					else
						V[i] = V[i - temp] + temp;
					
					if (V[i] > max)
						max = V[i];
				}
				else
				{
					V[i] = 0;
				}
			}	
		}
		//System.out.println(Arrays.toString(V));
		return max;
	}
	public static void main(String[] args)
	{
		LongestValidParentheses test = new LongestValidParentheses();
		//String str = ")()())()()(()))))";
		String str = "()(()";
		System.out.println(test.longestValidParentheses(str));
	}
}
