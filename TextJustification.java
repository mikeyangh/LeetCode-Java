
import java.util.LinkedList;
import java.util.List;

public class TextJustification 
{
	public List<String> fullJustify(String[] words, int L) 
	{
		List<String> result = new LinkedList<>(); 
		int i = 0;
		while (i < words.length)
		{
			int length = words[i].length();
			int count = 1;
			int j = i+1;
			while (j < words.length)
			{
				length += words[j].length() + 1;
				if (length > L)
				{
					length = length - words[j].length() - 1;
					break;
				}
				count++;
				j++;
			}
			if (j == words.length)
			{
				StringBuilder lastLine = new StringBuilder();
				for (int k = i; k < words.length; k++)
				{
					lastLine.append(words[k]);
					if (k != words.length-1)	
						lastLine.append(' ');
				}
				int tempLength = lastLine.length();
				for (int k = 0; k < L-tempLength; k++)
				{
					lastLine.append(' ');
				}
				result.add(lastLine.toString());
			}
			else if (count == 1)
			{
				StringBuilder line = new StringBuilder();
				line.append(words[i]);
				for (int k = 0; k < L-words[i].length(); k++)
					line.append(' ');
				result.add(line.toString());
			}
			else
			{
				length = length - count + 1;
				//System.out.println(length);
				StringBuilder line = new StringBuilder();
				int spaceLengthSum = L - length;
				int numberOfLarge = spaceLengthSum % (count-1);
				int numberOfSmall = count-1-numberOfLarge;
				int spaceLength = spaceLengthSum/ (count-1);
				line.append(words[i]);
				for (int k = 0; k < numberOfLarge; k++)
				{
					for (int t = 0; t < spaceLength+1; t++)
						line.append(' ');
					line.append(words[i + 1 + k]);
				}
				for (int k = 0; k < numberOfSmall; k++)
				{
					for (int t = 0; t < spaceLength; t++)
						line.append(' ');
					line.append(words[i + 1 + numberOfLarge + k]);
				}
				result.add(line.toString());
			}
			i += count;
		}
		return result;
    }
	public static void main(String[] args) 
	{
		//String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		String[] words = {"a"};
		TextJustification test = new TextJustification();
		System.out.println(test.fullJustify(words, 16).toString());
	}
}
