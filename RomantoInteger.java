
public class RomantoInteger {
	public int romanToInt(String s) 
    {
        int i = 0;
		int num = 0;
		int count;
		int length = s.length();
		while (s.charAt(i) == 'M')
		{
			num += 1000;
			i++;
			if (i == length)
			{
				return num;
			}
		}
		//System.out.println(num);
		////////////////////////////////////////////////////////
		count = 0;
		if (s.charAt(i) == 'D')
		{
			num += 500;
			i++;
			if (i == length)
			{
				return num;
			}
			else
			{
				while (s.charAt(i) == 'C')
				{
					num += 100;
					i++;
					if (i == length)
					{
						return num;
					}
				}
			}
		}
		else
		{
			while (s.charAt(i) == 'C')
			{
				count++;
				i++;
				if (i == length)
				{
					break;
				}
			}
			if (count >=2 && count <=3)
			{
				num = num+count*100;
				if (i == length)
				{
					return num;
				}
			}
			else if (count == 1)
			{
				if (i == length)
				{
					num += 100;
					return num;
				}
				if (s.charAt(i) == 'D')
				{
					num += 400;
					i++;
				}
				else if (s.charAt(i) == 'M')
				{
					num += 900;
					i++;
				}
				else
				{
					num += 100;
				}
				if (i == length)
				{
					return num;
				}
			}
		}
		//System.out.println(num);
		////////////////////////////////////
		count = 0;
		if (s.charAt(i) == 'L')
		{
			num += 50;
			i++;
			if (i == length)
			{
				return num;
			}
			else 
			{
				while (s.charAt(i) == 'X')
				{
					num += 10;
					i++;
					if (i == length)
					{
						return num;
					}
				}
			}
		}
		else
		{
			while (s.charAt(i) == 'X')
			{
				count++;
				i++;
				if (i == length)
				{
					break;
				}
			}
			if (count >=2 && count <=3)
			{
				num = num+count*10;
				if (i == length)
				{
					return num;
				}
			}
			else if (count == 1)
			{
				if (i == length)
				{
					num += 10;
					return num;
				}
				if (s.charAt(i) == 'L')
				{
					num += 40;
					i++;
				}
				else if (s.charAt(i) == 'C')
				{
					num += 90;
					i++;
				}
				else
				{
					num += 10;
				}
				if (i == length)
				{
					return num;
				}
			}
		}
		//System.out.println(num);
		/////////////////////////////////
		count = 0;
		if (s.charAt(i) == 'V')
		{
			num += 5;
			i++;
			if (i == length)
			{
				return num;
			}
			else 
			{
				while (s.charAt(i) == 'I')
				{
					num++;
					i++;
					if (i == length)
					{
						return num;
					}
				}
			}
		}
		else
		{
			while (s.charAt(i) == 'I')
			{
				count++;
				i++;
				if (i == length)
				{
					break;
				}
			}
			if (count >=2 && count <=3)
			{
				num = num+count;
				if (i == length)
				{
					return num;
				}
			}
			else if (count == 1)
			{
				if (i == length)
				{
					num++;
					return num;
				}
				if (s.charAt(i) == 'V')
				{
					num += 4;
					i++;
				}
				else if (s.charAt(i) == 'X')
				{
					num += 9;
					i++;
				}
				else
				{
					num++;
				}
				if (i == length)
				{
					return num;
				}
			}
		}
		return num;
        
    }
}
