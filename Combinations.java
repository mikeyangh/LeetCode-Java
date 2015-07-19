import java.util.LinkedList;
import java.util.List;


public class Combinations {
	public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> result = new LinkedList<>();
        if (n == k)
        {
            List<Integer> list = new LinkedList<>();
            for (int i = 1; i <= n; i++)
                list.add(i);
            result.add(list);
            return result;
        }
        if (k == 0)
        {
            List<Integer> list = new LinkedList<>();
            result.add(list);
            return result;
        }
        for (List list : combine(n-1, k-1))
        {
            list.add(n);
            result.add(list);
        }
        for (List list : combine(n-1, k))
        {
            result.add(list);
        }
        return result;
    }
}
