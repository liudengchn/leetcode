package q198;

/**
 * @author liudeng
 * @date 2020/11/19 下午7:25
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int length = nums.length;
        if (0 == length) {
            return 0;
        }
        if (1 == length) {
            return nums[0];
        }

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i -1]);
        }

        return dp[length - 1];
    }
}
