import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GenerateParentheses 
{	/*
	public List<String> generateParenthesis(int n) 
	{
		LinkedList<String> result = new LinkedList<String>();
		if (n == 0) return result;
        if (n == 1)
        {
        	result.add("()");
        	return result;
        }
        for (String str : generateParenthesis(n-1))
        {
        	for (int i = 0; i <= str.length(); i++)
        	{
        		String insertStr = str.substring(0, i) + "()" + str.substring(i);
        		if (!result.contains(insertStr))
        			result.add(insertStr);
        	}
        }
        return result;
    }
    */
	public List<String> generateParenthesis(int n) 
	{
		ArrayList<String> result = new ArrayList<String>();
		//generator(result, "", 0, 0, n);
		generator(result, new StringBuilder(), 0, 0, n);
		return result;
	}
	private void generator(ArrayList<String> list, StringBuilder generatedStr, int leftNumber, int rightNumber, int pairNumber)
	{
		if (leftNumber == pairNumber)
		{
			for (int i = 0; i < pairNumber - rightNumber; i++)
			{
				//generatedStr += ")";
				generatedStr.append(')');
			}
			list.add(generatedStr.toString());
			return ;
		}
		StringBuilder clone1 = new StringBuilder(generatedStr);	
		generator(list, clone1.append('('), leftNumber + 1, rightNumber, pairNumber);
		if (leftNumber > rightNumber)
		{
			StringBuilder clone2 = new StringBuilder(generatedStr);
			generator(list, clone2.append(')'), leftNumber, rightNumber + 1, pairNumber);
		}
	}
	
	public static void main(String[] args)
	{
		//String str = "abc";
		//System.out.println(str.substring(3));
		int n = 3;
		GenerateParentheses test = new GenerateParentheses();
		System.out.println(test.generateParenthesis(n));
	}
}
