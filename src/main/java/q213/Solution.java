package q213;

import java.util.Arrays;

/**
 * 抢劫2
 *
 * @author liudeng
 * @date 2020/11/23 上午9:25
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int robSon(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i -2] + nums[i], dp[i - 1]);
        }

        return dp[length - 1];
    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        return Math.max(robSon(Arrays.copyOfRange(nums, 0, (length - 1)))
        , robSon(Arrays.copyOfRange(nums, 1, length)));
    }

}
