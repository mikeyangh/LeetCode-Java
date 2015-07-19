
public class EditDistance 
{
	public int minDistance(String word1, String word2) 
    {
        int[][] match = new int[word1.length()+1][word2.length()+1];
        match[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++)
        {
        	match[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++)
        	match[0][i] = i;
        for (int i = 1; i <= word1.length(); i++)
        	for (int j = 1; j <= word2.length(); j++)
        	{
        		if (word1.charAt(i-1) == word2.charAt(j-1))
        			match[i][j] = match[i-1][j-1];
        		else
        		{
        			int min = match[i-1][j-1];
        			if (match[i-1][j] < min)
        				min = match[i-1][j];
        			if (match[i][j-1] < min)
        				min = match[i][j-1];
        			match[i][j] = min + 1;
        		}
        	}
        
        return match[word1.length()][word2.length()];
    }
}
