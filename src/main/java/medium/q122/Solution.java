package medium.q122;

/**
 * 买卖股票的最佳时机2
 *
 * @author liudeng
 * @date 2020/11/25 下午11:41
 * @since
 **/
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

    }

    /**
     * 动态规划
     *
     * @param prices
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        // dp代表目前持有的现金量
        // 二维数组的第一位代表第几天，第二位代表是否持有股票-0表示不持有、1表示持有
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[length - 1][0];
    }


    /**
     * 有利可图就卖-其实就是贪心算法
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                result += (prices[i] - prices[i - 1]);
            }
        }
        return result;
    }
}
