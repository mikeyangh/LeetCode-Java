
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) 
	{
		int maxPrice = 0;
		int minPrice = Integer.MAX_VALUE;
		for (int price : prices)
		{
			minPrice = Math.min(price, minPrice);
			maxPrice = Math.max(price-minPrice, maxPrice);
		}
		return maxPrice;
    }
}
