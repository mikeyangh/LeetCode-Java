
public class SearchinRotatedSortedArray 
{
	public int search(int[] A, int target) 
	{
		return searchRotate(A, target, 0, A.length-1);
    }

	private int searchRotate(int[] A, int target,int start, int end)
	{
		if (end < start)
        	return -1;
        if (target == A[start])
        	return start;
        else
        {
        	int mid = (start+end)/2;
        	if (A[mid] == target)
        	    return mid;
        	//System.out.println("start = "+ A[start]);
        	//System.out.println("mid ="+ A[mid]);
        	if (A[mid] >= A[start])
        	{
		        if ((target > A[start] && target < A[mid]))
		        {
		        	return searchRotate(A, target, 1, mid-1);
		        }
		        else
		        {
		        	return searchRotate(A, target, mid+1, end);
		        }
        	}
        	else
        	{
        		if (target > A[mid] && target < A[start])
        		{	        	
        			return searchRotate(A, target, mid+1, end);
        		}
        		else
		        {
        			return searchRotate(A, target, 1, mid-1);
		        }
        	}
        }
	}
	public static void main(String[] args)
	{
		SearchinRotatedSortedArray test = new SearchinRotatedSortedArray();
		int[] A = {4,5,6,7,0,1,2}; 
		System.out.println(test.search(A, -1));
	}
}
