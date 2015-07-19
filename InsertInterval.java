import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class InsertInterval 
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) 
	{
		List<Interval> result = new LinkedList<>();
		int start = newInterval.start;
		int end = newInterval.end;
		boolean flag = false;
		for (int i = 0; i < intervals.size(); i++)
		{
			if (intervals.get(i).end < start)
			{
				result.add(intervals.get(i));
				continue;
			}
			flag = true;
			int st = Math.min(start, intervals.get(i).start);
			while (i < intervals.size() && intervals.get(i).start <= end)
			{
				end = Math.max(intervals.get(i).end, end);
				i++;
			}

			Interval interval = new Interval(st, end);
			result.add(interval);
			for (int j = i; j < intervals.size(); j++)
				result.add(intervals.get(j));
			break;
		}
		if (!flag)
		{
			Interval interval = new Interval(start, end);
			result.add(interval);
		}
		return result;
    }
	public static void main(String[] args) 
	{
		
	}
}
