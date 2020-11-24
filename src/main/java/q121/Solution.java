package q121;

/**
 * 买卖股票的最佳时机
 *
 * @author liudeng
 * @date 2020/11/24 上午10:17
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 方法1-常规算法，暴力解法的优化版
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        int maxResult = 0;
        int maxNow = 0;
        for (int i = 1; i < length; i++) {
            maxNow = Math.max(0, maxNow += (prices[i] - prices[i - 1]));
            maxResult = Math.max(maxResult, maxNow);
        }
        return maxResult;
    }

    /**
     * 方法2-动态规划
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        // 某天，是否持股，手上拥有的现金流
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            // 第i天，不持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i -1][1] + prices[i]);
            // 第i天，持股
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }
}
