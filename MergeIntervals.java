import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals 
{
	public List<Interval> merge(List<Interval> intervals) 
	{
		List<Interval> result = new LinkedList<>();
		if (intervals.size() == 0)
		    return result;
		Interval[] array = intervals.toArray(new Interval[intervals.size()]);
		Arrays.sort(array, new Comparator<Interval>(){
			public int compare (Interval a, Interval b)
			{
				if (a.start < b.start)
					return -1;
				else if (a.start > b.start)
					return 1;
				else
				{
					if (a.end < b.end)
						return -1;
					else if (a.end > b.end)
						return 1;
					else
						return 0;
				}
			}
		});
		for (int i = 0; i+1 < array.length; i++)
		{
			if (array[i+1].start == array[i].start)
				continue;
			
		}
		int i = 0;
		int start = array[0].start;
		int end = array[0].end;
		while (i < array.length)
		{
			int tempStart = array[i].start;
			while(i < array.length && array[i].start == tempStart)
			{
				i++;
			}
			int tempEnd = array[i-1].end;
			if (tempStart > end)
			{
				Interval item = new Interval(start, end);
				result.add(item);
				start = tempStart;
				end = tempEnd;
			}
			else
				end = Math.max(end, tempEnd);
		}
		Interval item = new Interval(start, end);
		result.add(item);
		return result;
    }
	public static void main(String[] args) 
	{
		List<Interval> list = new LinkedList<>();
		Interval first = new Interval(1,3);
		Interval second = new Interval(2,6);
		Interval third = new Interval(8,10);
		Interval fourth = new Interval(15,18);
		list.add(first);
		list.add(second);
		list.add(third);
		list.add(fourth);
		for (Interval item : list)
		{
			System.out.println(item.toString());
		}
		MergeIntervals test =  new MergeIntervals();
		list = test.merge(list);
		for (Interval item : list)
		{
			System.out.println(item.toString());
		}
		
	}
}
