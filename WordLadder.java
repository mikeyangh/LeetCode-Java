import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict)
	{
		Queue<String> queue = new LinkedList<>();
		Queue<Integer> level = new LinkedList<>();
		wordDict.add(endWord);
		queue.add(beginWord);
		level.add(1);
		while (!queue.isEmpty())
		{
			String str = queue.poll();
			int l = level.poll();
			if (str.equals(endWord))
				return l;
			for (int i = 0; i < str.length(); i++)
			{
				char[] word = str.toCharArray();
				for (char ch = 'a'; ch <= 'z'; ch++)
				{
					if (ch == str.charAt(i))
						continue;
					word[i] = ch;
					String next = String.valueOf(word);
					if (wordDict.contains(next))
					{
						queue.add(next);
						level.add(l+1);
						wordDict.remove(next);
					}
				}
			}
		}
		return 0;
	}
}
