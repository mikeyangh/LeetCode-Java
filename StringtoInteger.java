
public class StringtoInteger {
	public int atoi(String str) {
        int pointer = 0;
        long number = 0L;
        long INT_MAX = 2147483647L;
        boolean positive = true;
        if (str.length() == 0)
        {
            return 0;
        }
   //     while (pointer < str.length())
     //   {
            while (str.charAt(pointer) == ' ')
            {
                pointer++;
            }
            if (str.charAt(pointer) == '+')
            {
                pointer++;
                while (str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9')
                {
                    number = number*10+str.charAt(pointer)-48;
                    pointer++;
                    if (positive && number > INT_MAX)
                    {
                        return (int) INT_MAX;
                    }
                    if(!positive && number > INT_MAX+1)
                    {
                        return (int) -(INT_MAX+1);
                    }
                    if(pointer >= str.length())
                    {
                        break;
                    }
                }
            }
            else if (str.charAt(pointer) == '-')
            {
                positive = false;
                pointer++;
                while (str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9')
                {
                    number = number*10+str.charAt(pointer)-48;
                    pointer++;
                    if (positive && number > INT_MAX)
                    {
                        return (int) INT_MAX;
                    }
                    if(!positive && number > INT_MAX+1)
                    {
                        return (int) -(INT_MAX+1);
                    }
                    if(pointer >= str.length())
                    {
                        break;
                    }
                }
            }
            else if(str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9')
            {
                while (str.charAt(pointer) >= '0' && str.charAt(pointer) <= '9')
                {
                    number = number*10+str.charAt(pointer)-48;
                    pointer++;
                    if (positive && number > INT_MAX)
                    {
                        return (int) INT_MAX;
                    }
                    if(!positive && number > INT_MAX+1)
                    {
                        return (int) -(INT_MAX+1);
                    }
                    if(pointer >= str.length())
                    {
                        break;
                    }
                }
            }
            else
            {
                return 0;
            }
            /*
            if (positive && number > INT_MAX)
            {
                return (int) INT_MAX;
            }
            if(!positive && number > INT_MAX+1)
            {
                return (int) -(INT_MAX+1);
            }*/
            if(positive)
            {
                return (int) number;
            }
            else
            {
                return (int) -number;
            }

    //    }
        
    }
}
