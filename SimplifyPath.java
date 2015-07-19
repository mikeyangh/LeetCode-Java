import java.util.Arrays;
import java.util.Stack;


public class SimplifyPath 
{
	/*
	 * For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
	 */
	public String simplifyPath(String path) 
    {
		Stack<String> stack =new Stack<>();
		String[] dirs = path.split("/+");
		//System.out.println(Arrays.toString(dirs));
		for (String dir : dirs)
		{
			if (dir.length() == 0)
				continue;
			if (dir.equals("."))
				continue;
			else if (dir.equals(".."))
			{
				if (!stack.isEmpty())
					stack.pop();
			}
			else
				stack.push(dir);
		}
		//System.out.println(stack.toString());
		if (stack.isEmpty())
			return "/";
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty())
		{
			StringBuilder str = new StringBuilder("/");
			str.append(stack.pop());
			result = str.append(result);
		}
		return result.toString();
    }
	public static void main(String[] args) 
	{
		//String str = "/home//foo/";
		String str = "/a/./b/../../c/";
		String[] fields = str.split("/+");
		//System.out.println(Arrays.toString(fields));
		SimplifyPath test = new SimplifyPath();
		System.out.println(test.simplifyPath(str));
	}
}
