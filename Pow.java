
public class Pow {
	public double pow(double x, int n) 
	{
		if (n == 0)
			return 1;
		if (n < 0)
		{
			double denominator = powPositive(x, -n);
			return 1/denominator;
		}
		else
			return powPositive(x, n);
	}
	public double powPositive(double x, int n) 
	{
		if (n == 1)
			return x;
		double temp = pow(x, n/2);
		if (n%2 == 1)
			return temp * temp * x;
		else
			return temp * temp;

    }
	public static void main(String[] args) 
	{
		Pow test = new Pow();
		System.out.println(test.pow(3, -3));
	}
}
