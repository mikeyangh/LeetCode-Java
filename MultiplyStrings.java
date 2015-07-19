import java.math.BigInteger;
import java.util.Arrays;


public class MultiplyStrings {
	/*
	public String multiply(String num1, String num2) 
	{
		if (num1.length() == 0 || num2.length() == 0)
			return "";
		BigInteger number1 = new BigInteger(num1);
		BigInteger number2 = new BigInteger(num2);
		
		return (number1.multiply(number2)).toString();
    }*/
	public String multiply(String num1, String num2) 
	{
		int[] result = new int[num1.length()+num2.length()];
		for (int i = num1.length()-1; i >= 0; i--)
			for (int j = num2.length()-1; j >=0 ; j--)
			{
				int index = i + j + 1;
				result[index] += (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
				result[index-1] += result[index]/10;
				result[index] = result[index]%10;
			}
		StringBuilder str = new StringBuilder();
		
		
		for (int i = 0; i < num1.length()+num2.length(); i++)
		{
			if (result[i] == 0 && str.length() == 0)
				continue;
			str.append(result[i]);
		}
		if (str.length() == 0)
			return "0";
		return str.toString();
	}

	/*
	public String add(String str1, String str2)
	{
		int length = Math.min(str1.length(), str2.length());
		int carry = 0;
		for (int i = 0; i < length; i++)
		{
			int a = str1.charAt(i) - '0';
			int b = str2.charAt(i) - '0';
			carry = (a + b + carry)/10;
			int remain = (a + b + carry)%10;
		}
	}*/
	public static void main(String[] args) 
	{
		MultiplyStrings test = new MultiplyStrings();
		//System.out.println(test.multiply("123", "321"));
		System.out.println(test.multiply("0", "321"));
	}

}
