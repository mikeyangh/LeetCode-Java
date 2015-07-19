import java.util.Arrays;


public class AddBinary 
{
	/*
	public String addBinary(String a, String b) 
	{
		int length = Math.max(a.length(), b.length())+1;
		char[] array = new char[length];
		char carry = '0';
		for (int i = a.length()-1, j = b.length()-1, index = length-1; index >= 0; i--, j--, index--)
		{
			char chA, chB;
			if (i >= 0)
				chA = a.charAt(i);
			else
				chA = '0';
			if (j >= 0)
				chB = b.charAt(j);
			else
				chB = '0';
			if (chA == '0' && chB == '0')
			{
				array[index] = carry ;
			}
			else if (chA == '1' && chB == '1')
			{
				array[index] = carry;
				carry = '1';
			}
			else
			{
				if (carry == '1')
				{
					array[index] = '0';
					carry = '1';
				}
				else
					array[index] = '1';
			}
		}
		if (array[0] == '0')
		{
			System.out.println("!!!");
			array = Arrays.copyOfRange(array, 1, length);
		}
		//System.out.println(Arrays.toString(array));
		
		return String.valueOf(array);
    }*/
	public String addBinary(String a, String b)
	{
		StringBuilder result = new StringBuilder();
		int length = Math.max(a.length(), b.length());
		char carry = '0';
		for (int i = a.length()-1, j = b.length()-1, index = length-1; index >= 0; i--, j--, index--)
		{
			char chA, chB;
			if (i >= 0)
				chA = a.charAt(i);
			else
				chA = '0';
			if (j >= 0)
				chB = b.charAt(j);
			else
				chB = '0';
			if (chA == '0' && chB == '0')
			{
				result.append(carry);
				carry = '0';
			}
			else if (chA == '1' && chB == '1')
			{
				result.append(carry);
				carry = '1';
			}
			else
			{
				if (carry == '1')
				{
					result.append('0');
					carry = '1';
				}
				else
					result.append('1');
			}
		}
		if (carry == '1')
			result.append('1');
		return result.reverse().toString();
	}
	public static void main(String[] args) 
	{
		AddBinary test = new AddBinary();
		System.out.println(test.addBinary("1010", "1011"));
	}
}
