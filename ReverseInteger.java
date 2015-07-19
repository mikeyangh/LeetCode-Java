
public class ReverseInteger {
	public int reverse(int x) {
        int remain;
        long reverse = 0;
        boolean positive = true;
        if(x < 0)
        {
            x = -x;
            positive = false;
        }
        while (x > 0)
        {
            remain = x%10;
            x = x/10;
            reverse = reverse*10+remain;
        }
        long boundary = 2147483648L;
        if((reverse > boundary && positive == false) || (reverse > boundary-1 && positive == true))
        {
            return 0;
        }
        if(!positive)
        {
            reverse = -reverse;
        }
        return (int) reverse;
    }
}
