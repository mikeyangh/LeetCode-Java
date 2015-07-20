import java.util.LinkedList;
import java.util.List;


public class GrayCode {
	public List<Integer> grayCode(int n) 
	{
		List<Integer> result = new LinkedList<>();
		if (n == 0)
		{
		    result.add(0);
		    return result;
		}
		if (n == 1)
		{
			result.add(0);
			result.add(1);
			return result;
		}
		List<Integer> lastList = grayCode(n-1);
		result.addAll(lastList);
		int add = 1;
		for (int i = 0; i < n-1; i++)
		{
			add = add*2;
		}
		for (int i = lastList.size()-1; i >= 0; i--)
		{
			result.add(add+lastList.get(i));
		}
		return result;
    }
}
