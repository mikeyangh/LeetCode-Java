import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
        {
            return 0;
        }
        int head = 0;
        int end = 1;
        int length = 1;
        //Hashtable<Character, Integer> myhash = new Hashtable<Character, Integer>();
        Map <Character,Integer> myhash = new HashMap<>();
        myhash.put(s.charAt(0),0);
        while(end < s.length())
        {
            if(myhash.containsKey(s.charAt(end)))
            {
                int temp_head = myhash.get(s.charAt(end)) + 1;
                for(int i = head; i < temp_head; i++)
                {
                    myhash.remove(s.charAt(i));
                }
                head = temp_head;
                myhash.put(s.charAt(end),end);
            }
            else
            {
                myhash.put(s.charAt(end),end);
            }
        
        
        
        
            if(end-head+1 > length)
            {
                length = end-head+1;
            }
            end++;
            
        }
        return length;
        
        
        
        
    }
}
