package q309;

/**
 * 最佳买卖股票时机-含冷冻期
 *
 * @author liudeng
 * @date 2020/12/10 上午12:23
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }

        // dp[i][0]表示第i天，持有股票时有的现金额
        // dp[i][1]表示第i天， 不持有股票且处于冷静期时有的现金额
        // dp[i][2]表示第i天， 不持有股票且不处于冷静期时有的现金额
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i- 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[length - 1][1], dp[length - 1][2]);

    }
}
