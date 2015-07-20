
public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
        int[] maxBefore = new int[prices.length];
        maxBefore[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++)
        {
        	min = Math.min(min, prices[i]);
        	maxBefore[i] = Math.max(maxBefore[i-1], prices[i]-min);
        }
        int sum = 0;
        int max = 0;
        for (int i = prices.length-1; i >= 1; i--)
        {
        	max = Math.max(prices[i], max);
        	sum = Math.max(maxBefore[i-1]+max-prices[i], sum);
        }
        return Math.max(maxBefore[prices.length-1], sum);
    }
}
