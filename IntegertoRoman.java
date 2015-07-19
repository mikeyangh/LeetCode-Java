
public class IntegertoRoman {
	public String intToRoman(int num) 
    {
        StringBuilder Roman = new StringBuilder();
		int count = num/1000;
		while (count > 0)
		{
			Roman.append('M');
			count--;
		}
		num = num%1000;
		//////////////////////////////////
		count = num/100;
		if (count <= 3)
		{
			while (count > 0)
			{
				Roman.append('C');
				count--;
			}
		}
		else if (count == 4)
		{
			Roman.append("CD");
		}
		else if (count >=5 && count <=8)
		{
			count = count - 5;
			Roman.append('D');
			while (count > 0)
			{
				Roman.append('C');
				count--;
			}
		}
		else
		{
			Roman.append("CM");
		}
		num = num%100;
		///////////////////////////////////////
		count = num/10;
		if (count <= 3)
		{
			while (count > 0)
			{
				Roman.append('X');
				count--;
			}
		}
		else if (count == 4)
		{
			Roman.append("XL");
		}
		else if (count >=5 && count <= 8)
		{
			count = count - 5;
			Roman.append('L');
			while (count > 0)
			{
				Roman.append('X');
				count--;
			}
		}
		else
		{
			Roman.append("XC");
		}
		num = num%10;
		///////////////////////////////////////
		count = num;
		if (count <= 3)
		{
			while (count > 0)
			{
				Roman.append('I');
				count--;
			}
		}
		else if (count == 4)
		{
			Roman.append("IV");
		}
		else if (count >=5 && count <= 8)
		{
			count = count - 5;
			Roman.append('V');
			while (count > 0)
			{
				Roman.append('I');
				count--;
			}
		}
		else
		{
			Roman.append("IX");
		}
        return Roman.toString();
    }
}
