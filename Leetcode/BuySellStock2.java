public class BuySellStock2 {

  public int maxProfit(int[] prices) {
    int profitSoFar;
    int maxProfit = 0;
    for (int i = 0; i < prices.length - 1; i++) {
      profitSoFar = 0;
      int boughtPrice = prices[i];
      int currPrice = 0;
      int prevPrice = -1;
      for (int j = i + 1; j < prices.length; j++) {
        currPrice = prices[j];
        if (currPrice < prevPrice) {
          // sell at previous price
          profitSoFar += prevPrice - boughtPrice;
          boughtPrice = currPrice;
        }
        prevPrice = prices[j];
      }
      if (boughtPrice < prices[prices.length - 1])
        profitSoFar += prices[prices.length - 1] - boughtPrice;
      maxProfit = Math.max(profitSoFar, maxProfit);
    }
    return maxProfit;
  }
}
