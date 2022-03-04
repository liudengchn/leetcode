package medium.q714;

/**
 * 买卖股票的最佳时机，含手续费
 *
 * @author liudeng
 * @date 2020/12/11 上午12:26
 * @since
 **/
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        // 第一天不持有股票的利润
        int cash = 0;
        // 第一天持有股票的利润
        int hold = -prices[0];
        int length = prices.length;

        for (int i = 1; i < length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;

    }
}
