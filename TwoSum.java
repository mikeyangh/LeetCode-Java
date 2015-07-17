import java.util.HashMap;
import java.util.Map;


public class TwoSum {
	public int[] twoSum(int[] numbers, int target) 
    {
       Map <Integer,Integer> map = new HashMap<>();
       int x;
       for(int i = 0;i < numbers.length; i++)
       {
           x = numbers[i];
           if(map.containsKey(target-x))
           {
               return new int[] { map.get(target-x)+1, i+1};
           }
           map.put(x,i);
       }
        throw new IllegalArgumentException("No two sum solution");
    }
}
