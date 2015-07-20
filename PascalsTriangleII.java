import java.util.LinkedList;
import java.util.List;


public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        if (rowIndex == 0)
        {
        	result.add(1);
        	return result;
        }
        List<Integer> last = getRow(rowIndex-1);
        result.add(1);
        for (int i = 1; i < last.size(); i++)
        {
        	result.add(last.get(i-1)+last.get(i));
        }
        result.add(1);
        return result;
    }
}
