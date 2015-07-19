import java.util.Arrays;


public class PlusOne 
{
	public int[] plusOne(int[] digits) 
    {
        if (digits.length == 0)
            return digits;
		for (int i = digits.length-1; i >= 0; i--)
		{
			if (digits[i] == 9)
			{
			    digits[i] = 0;
			}
			else
			{
			    digits[i]++;
			    break;
			}
		}
		if (digits[0] == 0)
		{
			digits = Arrays.copyOf(digits, digits.length + 1);
            digits[0] = 1;
		}
		return digits;
    }
	public static void main(String[] args) {
		
	}
}
