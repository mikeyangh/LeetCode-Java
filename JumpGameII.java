import java.util.Arrays;


public class JumpGameII 
{
	public int jump(int[] A) 
	{
		int[] jump = new int[A.length];
		for (int i = 0; i < A.length; i++)
			jump[i] = Integer.MAX_VALUE;
		jump[0] = 0;
		int count = 0;
		int start = 0;
		int end = 0;
		while(jump[A.length-1] == Integer.MAX_VALUE)
		{
			int max = Integer.MIN_VALUE;
			int index = -1;
			for (int i = start; i <= end; i++)
			{
				if (A[i]+i > max)
				{
					index = i;
					max = A[i]+i;
				}
			}
			count++;
			for (int i = end+1; i < A.length && i <= index + A[index]; i++)
			{
				jump[i] = count;
			}
			start = end+1;
			end = index + A[index];
		}
		//System.out.println(Arrays.toString(jump));
		return jump[A.length-1];
    }
	public static void main(String[] args) 
	{
		JumpGameII test = new JumpGameII();
		int[] A = {2,3,1,1,3,2,6,7};
		System.out.println(test.jump(A));
	}
}
