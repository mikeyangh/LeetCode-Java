
public class Sqrt 
{
	public int mySqrt(int x) 
    {
        if (x == 0 || x == 1)
        	return x;
        int low = 0;
        int high = x;
        /*
        while (low <= high)
        {
        	int candidate = (low+high)/2;
        	int floorNum = candidate*candidate;
        	int ceilNum = (candidate+1)*(candidate+1);
        	if (floorNum <= x && ceilNum > x)
        	    return candidate;
        	else if (floorNum > x)
        		high = candidate-1;
        	else
        		low = candidate+1;
        }*/
        while (low <= high)
        {
        	int mid = (low+high)/2;
        	if (x/mid >= mid && x/(mid+1) < mid+1)
        		return mid;
        	else if (x/mid < mid)
        		high = mid - 1;
        	else
        		low = mid + 1;
        }
        
        return 0;
    }
	public static void main(String[] args) 
	{
		Sqrt test = new Sqrt();
		System.out.println(test.mySqrt(234));
	}
}
