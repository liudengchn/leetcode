package q123;

/**
 * 买卖股票的最佳时机3
 *
 * @author liudeng
 * @date 2020/12/3 上午12:12
 * @since
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0 || prices == null) {
            return 0;
        }
        int[][] dp = new int[length][5];
        // 初始化第一天的状态，没操作一次即买或卖一次就在数组第二位加1
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < length; i++) {
            // 初始状态
            dp[i][0] = dp[i - 1][0];
            // 第i天第一次买入股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第i天第一次卖股票
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //处理第二次买入、第二次卖出
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        // 两两比较返回最大值
        return Math.max(Math.max( Math.max(dp[length-1][0],dp[length-1][1]),Math.max(dp[length-1][2],dp[length-1][3]) ),dp[length-1][4]);

    }
}
