package q53;

/**
 * @author liudeng
 * @date 2020/11/12 11:13 上午
 * @since
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution().maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] p = new int[length];

        p[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            p[i] = nums[i] + (p[i - 1] > 0 ? p[i - 1] : 0);
            result = Math.max(result, p[i]);
        }
        return result;
    }
}
