import java.util.Arrays;


public class SearchforaRange 
{
	public int[] searchRange(int[] A, int target) 
    {
        int i = searchIndex(A, target, 0, A.length-1);
        if (i == -1)
        	return new int[] {-1, -1};
        for (int j = i; j < A.length && A[j] == target; j++){}
        int j, k;
        j = i;
        k = i;
        while(j < A.length && A[j] == target){j++;}
        while(k >= 0 && A[k] == target){k--;}
        return new int[] {k+1, j-1};   
    }
	/*
	private int searchIndex(int[] A, int target, int start, int end)
	{
		if (start > end)
			return -1;
		if (A[start] == target)
			return start;
		else
		{
			int mid = (start+end)/2;
			if (target == A[mid])
				return mid;
			else if (target < A[mid])
				return searchIndex(A, target, start, mid-1);
			else
				return searchIndex(A, target, mid+1, end);
		}
	}*/
	private int searchIndex(int[] A, int target, int start, int end)
	{
		while (end >= start)
		{
			int mid = (start+end)/2;
			if (target == A[mid])
				return mid;
			else if (target < A[mid])
				end = mid-1;
			else
				start = mid+1;
		}
		return -1;
	}
	public static void main(String[] args) 
	{
		SearchforaRange test = new SearchforaRange();
		int[] A = {5, 7, 7, 8, 8, 10};
		System.out.println(Arrays.toString(test.searchRange(A, 10)));
	}
}
