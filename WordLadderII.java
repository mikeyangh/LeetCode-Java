import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict)
	{
		List<List<String>> result = new LinkedList<>();
		dict.add(start);
		dict.add(end);
		HashMap<String, Integer> distance = new HashMap<>();
		for (String str : dict)
		{
			distance.put(str, Integer.MAX_VALUE);
		}
		distance.put(start, 0);
		Queue<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		HashMap<String, Set<String>> parrent = new HashMap<>();
		queue.add(start);
		while (!queue.isEmpty())
		{
			String str = queue.poll();
			visited.add(str);
			int d = distance.get(str)+1;
			for (int i = 0; i < str.length(); i++)
			{
				char[] word = str.toCharArray();		
				for (char ch = 'a'; ch <= 'z'; ch++)
				{
					if (ch == str.charAt(i))
						continue;
					word[i] = ch;
					String next = String.valueOf(word);
					
					if (!visited.contains(next) && dict.contains(next))
					{
						if (distance.get(next) == Integer.MAX_VALUE)
						{
							queue.add(next);
						}
						if (d <= distance.get(next))
						{
							distance.put(next, d);
							if (d == distance.get(next))
							{
								if (!parrent.containsKey(next))
									parrent.put(next, new HashSet<String>());
								parrent.get(next).add(str);
							}
							else
							{
								Set<String> set = new HashSet<>();
								set.add(str);
								parrent.put(next, set);
							}
						}
					}
				}
			}
		}
		//System.out.println(distance.get("cog"));
		//System.out.println(parrent);
		List<String> list = new LinkedList<>();
		backtrack(list, start, end, parrent, result);
		return result;
	}
	
	private void backtrack(List<String> list, String start, String end, HashMap<String, Set<String>> parrent, List<List<String>> result)
	{
		if (start.equals(end))
		{
			list.add(0, end);
			result.add(new ArrayList<>(list));
			list.remove(0);
			return;
		}
		if (!parrent.containsKey(end))
			return;
		list.add(0, end);
		for (String str : parrent.get(end))
		{
			backtrack(list, start, str, parrent, result);
		}
		list.remove(0);
	}
}
