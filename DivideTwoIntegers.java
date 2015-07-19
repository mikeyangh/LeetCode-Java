
public class DivideTwoIntegers 
{
	public int divide(int dividend, int divisor) 
    {
		long longDividend = dividend;
		long longDivisor = divisor;
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
			
		return (dividend > 0 ^ divisor > 0)? (int) -binaryDivide(Math.abs(longDividend),Math.abs(longDivisor)) : (int) binaryDivide(Math.abs(longDividend), Math.abs(longDivisor));
    }
	private long binaryDivide(long dividend, long divisor)
	{
		//long q = 0L;
		//System.out.println(dividend+" "+divisor);
		if (divisor > dividend)
			return 0;
		long q = 1L;
		long oldDivisor = divisor;
		while (divisor <= dividend)
		{
			divisor = divisor << 1;
			q = q << 1;
		}
		q = q >> 1;
		divisor = divisor >> 1;
		return q + binaryDivide(dividend - divisor, oldDivisor);
	}
	public static void main(String[] args)
	{
		DivideTwoIntegers test = new DivideTwoIntegers();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
		System.out.println(test.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
		System.out.println(test.divide(Integer.MIN_VALUE, -1));
		System.out.println(test.divide(56, 3));
	}
}
