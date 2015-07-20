import java.util.LinkedList;
import java.util.List;


public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) 
	{
		List<List<Integer>> result = new LinkedList<>();
		if (numRows == 0)
			return result;
		if (numRows == 1)
		{
			List<Integer> list = new LinkedList<>();
			list.add(1);
			result.add(list);
			return result;
		}
		List<Integer> list = new LinkedList<>();
		list.add(1);
		result = generate(numRows-1);
		List<Integer> lastList = result.get(result.size()-1);
		for (int i = 1; i < lastList.size(); i++)
		{
			list.add(lastList.get(i-1)+lastList.get(i));
		}
		list.add(1);
		result.add(list);
		return result;
    }
}
