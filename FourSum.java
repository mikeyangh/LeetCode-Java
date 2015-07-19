import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class FourSum 
{
	public List<List<Integer>> fourSum(int[] num, int target) 
	{
		
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (num.length < 4)
			return result;
        
        HashMap<Integer, LinkedList<LinkedList<Integer>>> hashmap = new HashMap<>();
        for (int i = 0; i < num.length - 1; i++)
        {
        	for (int j = i+1; j < num.length; j++)
        	{

        		int key = num[i] + num[j];
        		if (!hashmap.containsKey(key))
        		{
        			hashmap.put(key, new LinkedList<LinkedList<Integer>>());
       			}
       			LinkedList<LinkedList<Integer>> possibleList = hashmap.get(key);
       			LinkedList<Integer> numberList = new LinkedList<>();
       			/*
       			if (num[i] < num[j])
       			{
       				numberList.add(num[i]);
       				numberList.add(num[j]);
       			}
       			else
       			{
       				numberList.add(num[j]);
       				numberList.add(num[i]);
       			}
       			if (!possibleList.contains(numberList))
       				possibleList.add(numberList);*/
       			numberList.add(i);
   				numberList.add(j);
   				possibleList.add(numberList);
        	}
        }
        //System.out.println(hashmap.keySet());
        
        
        
        
       	for (Integer sum1 : hashmap.keySet())
    	{
      		int sum2 = target - sum1;
      		
       		if (sum1 == sum2)
   			{
       			//System.out.println("sum1 = " + sum1 + "  sum2 = " + sum2 );
   				LinkedList<LinkedList<Integer>> list = hashmap.get(sum1);
   				//System.out.println(list);
   				for (LinkedList<Integer> two_number1 : list)
   				{
   					//System.out.print(two_number1);
   					for (LinkedList<Integer> two_number2 : list)
   					{
   						//System.out.println(two_number2);
   						if (!isIntersection(two_number1, two_number2))
   						{
   							//System.out.println(two_number1);
   							//System.out.println(two_number2);
   							LinkedList<Integer> four_number = new LinkedList<Integer>();
   							for (Integer number : two_number1)
   							{
   								four_number.add(num[number]);
   							}
   							for (Integer number : two_number2)
   							{
   								four_number.add(num[number]);
   							}
   							Collections.sort(four_number);
   							if (!result.contains(four_number))
   								result.add(four_number);
  						}
   					}
   				}
   			}
       		else if (hashmap.containsKey(sum2))
       		{
      			LinkedList<LinkedList<Integer>> list1 = hashmap.get(sum1);
      			LinkedList<LinkedList<Integer>> list2 = hashmap.get(sum2);
      			//System.out.println("sum1 = " + sum1 + "  sum2 = " + sum2 );
      			//System.out.println(list);
   				for (LinkedList<Integer> two_number1 : list1)
   				{
   					//System.out.print(two_number1);
  					for (LinkedList<Integer> two_number2 : list2)
   					{
  						if (!isIntersection(two_number1, two_number2))
  						{
  							//System.out.println(two_number2);
  							LinkedList<Integer> four_number = new LinkedList<Integer>();
  							for (Integer number : two_number1)
   							{
   								four_number.add(num[number]);
   							}
   							for (Integer number : two_number2)
   							{
   								four_number.add(num[number]);
   							}
  							Collections.sort(four_number);
  							if (!result.contains(four_number))
  								result.add(four_number);
  						}
 					}
   				}
       		}
       	}
       	return result;
    }
	private boolean isIntersection(LinkedList<Integer> list1, LinkedList<Integer> list2)
	{
		for (Integer a : list1)
		{
			for (Integer b : list2)
			{
				if (a == b)
				{
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args)
	{
		//int[] array = {7,1,7,-7,10,3,-5,-3,-9,6,-8,-6,-10,10,-3,4,2};
		//int target = 18;
		
		//int[] array = {0,0,0,0};
		//int target = 0;
		//int[] array = {7,1,7,-7,10,3,-5,-3,-9,6,-8,-6,-10,10,-3,4,2};
		//int target = 18;
		int[] array = {1,0,-1,0,-2,2};
		int target = 0;
		FourSum test = new FourSum();
		System.out.println(test.fourSum(array, target));
	}
}
