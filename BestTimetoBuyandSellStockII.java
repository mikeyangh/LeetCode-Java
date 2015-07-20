
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++)
        {
        	if (prices[i] <= prices[i-1])
        		continue;
        	int buy = prices[i-1];
        	while (i < prices.length && prices[i] > prices[i-1]) i++;
        	result += prices[i-1]-buy;
        }
        return result;
    }
}
