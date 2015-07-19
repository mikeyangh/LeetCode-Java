
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x < 0)
        {
            return false;
        }
        int head = x;
        int tail;
        int count = 0;
        while(head >= 10)
        {
            head = head/10;
            count++;
        }
        while (count >= 1)
        {
            tail = x%10;
            head = x;
            for (int i = 0; i < count; i++)
            {
                head = head/10;
            }
            if(head != tail)
            {
                return false;
            }
            for (int i = 0; i < count; i++)
            {
                head = head*10;
            }
            x = x-head;
            x = x/10;
            count = count-2;
        }
        return true;
    }
}
