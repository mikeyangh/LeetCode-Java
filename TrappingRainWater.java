import java.util.Stack;


public class TrappingRainWater 
{
	public int trap(int[] A) 
	{
		if (A.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int maxindex = 0;
		for (int i = 0; i < A.length; i++)
		{
			if (A[i] > max)
			{
				max = A[i];
				maxindex = i;
			}
		}
		
		int result = 0;
		int level = A[0];
		for (int i = 0; i < maxindex; i++)
		{
			result += (level - A[i]);
			//System.out.println("i = " + i + " " + "result = " + result);
			if (level < A[i+1])
			{
				level = A[i+1];
			}
		}
		level = A[A.length-1];
		for (int i = A.length-1; i > maxindex; i--)
		{
			result += (level - A[i]);
			if (level < A[i-1])
			{
				level = A[i-1];
			}
		}
		return result;
    }
	/*
	 * public int trap(int[] A) {

    int left = 0, right = A.length-1;

    int level = 0, result = 0;

    while (left<right){

        level = Math.max(Math.min(A[left], A[right]), level);

        if (A[left]<=A[right]){
            result += level-A[left];
            left++;
        }
        else{
            result += level-A[right];
            right--;
        }
    }

    return result;

}
	 */
	public static void main(String[] args) {
		TrappingRainWater test = new TrappingRainWater();
		int[] A = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(test.trap(A));
	}
}
