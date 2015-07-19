
public class CountandSay 
{
	public String countAndSay(int n) {
        StringBuilder str = new StringBuilder("1");
        for (int i = 0; i < n-1; i++)
        {
        	StringBuilder temp =new StringBuilder();
            for (int j = 0; j < str.length(); j++)
            {
            	int count = 1;
            	char ch = str.charAt(j);
            	while (j+1 < str.length() && ch == str.charAt(j+1))
            	{
            		count++;
            		j++;
            	}
            	temp.append(String.valueOf(count)).append(String.valueOf(ch));
            }
            //str.delete(0, str.length());
            //str.append(temp);
            str = temp;
        }
        return str.toString();
    }
	public static void main(String[] args)
	{
		CountandSay test = new CountandSay();
		System.out.println(test.countAndSay(5));
	}
		
}
