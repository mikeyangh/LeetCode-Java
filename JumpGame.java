
public class JumpGame 
{
	public boolean canJump(int[] A) 
	{
		int start = 0;
		int end = 0;
		boolean[] reachable = new boolean[A.length];
		//reachable[0] = true;
		while (reachable[A.length-1] != true && end >= start)
		{
			int max = Integer.MIN_VALUE;
			int maxindex = -1;
			for (int i = start; i <= end; i++)
			{
				reachable[i] = true;
				if (A[i]+i > max)
				{
					max = A[i]+i;
					maxindex = i;
				}
			}
			start = end + 1;
			end = Math.min(maxindex + A[maxindex], A.length-1);
			
		}
		return reachable[A.length-1];
    }
	public static void main(String[] args) 
	{
		//int[] num = {3,2,1,0,4};
		int[] num = {2,3,1,1,4};
		JumpGame test = new JumpGame();
		System.out.println(test.canJump(num));
	}
}
