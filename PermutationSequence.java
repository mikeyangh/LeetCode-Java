
public class PermutationSequence 
{
	public String getPermutation(int n, int k) 
	{
		int num = 1;
		boolean[] mark = new boolean[n+1];
		for (int i = 2; i <= n; i++)
		{
			num *= i;
		}
		StringBuilder prefix = new StringBuilder();
		int time = 0;
		while (k != 0 && time < n)
		{
		    num = num / (n-time);
			int order;
			if (k % num == 0)
				order = k/num;
			else
				order = k/num + 1;
			int count = 0;
			int head = 0;
			for (int i = 1; i <= n; i++)
			{
				if (!mark[i])
				{
					count++;
					if (count == order)
					{	
						head = i;
						mark[i] = true;
						break;
					}
				}
			}
			prefix.append(head);
			k = k % num;
			//num = num / (n-time);
			time++;
		}
		for (int i = n; i >= 1; i--)
		{
			if (!mark[i])
				prefix.append(i);
		}
		return prefix.toString();
    }
		
	public static void main(String[] args) 
	{
		PermutationSequence test = new PermutationSequence();
		System.out.println(test.getPermutation(3, 4));
	}
}
