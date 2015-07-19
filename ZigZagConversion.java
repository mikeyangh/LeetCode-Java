
public class ZigZagConversion {
	public String convert(String s, int nRows) {
        if (s.length()==0)
        {
            return "";
        }
        int oldPointer = 0;
        int newPointer = 0;
        char[] charArray = new char[s.length()];
        if (nRows == 1)
        {
            return s;
        }
        for (int i = 0; i < nRows; i++)
        {
            oldPointer = i;
            boolean even = true;
            while(oldPointer < s.length())
            {
                if(i == 0 || i == nRows-1)
                {
                    charArray[newPointer] = s.charAt(oldPointer);
                    newPointer++;
                    oldPointer += (2*nRows-2);
                }
                else
                {
                    if(even)
                    {
                        charArray[newPointer] = s.charAt(oldPointer);
                        newPointer++;
                        oldPointer += (2*nRows-2*i-2);
                        even = false;
                    }
                    else
                    {
                        charArray[newPointer] = s.charAt(oldPointer);
                        newPointer++;
                        oldPointer += (2*i);
                        even = true;
                    }
                }
            }
        }
        String result = new String(charArray);
        return result; 
    }
}
