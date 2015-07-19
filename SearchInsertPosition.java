
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) 
	{
		if (A.length == 0)
			return 0;
		int start = 0;
		int end = A.length - 1;
		int mid = 0;
		while (start <= end)
		{
			mid = (start+end) >> 1;
			if (A[mid] == target)
				return mid;
			else if (target < A[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}
		return target > A[mid] ? mid+1 : mid;
    }
	//private int search(int[] A, int target,)
	public static void main(String[] args) {
		int[] num = {1,3,5,6};
		SearchInsertPosition test = new SearchInsertPosition();
		System.out.println(test.searchInsert(num, 0));
	}
}
