package q152;

/**
 * @author liudeng
 * @date 2020/11/13 9:00 上午
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < length; i++) {
            int mx = max , mn = min;
            max = Math.max(mx * nums[i], Math.max(mn * nums[i], nums[i]));
            min = Math.min(mx * nums[i], Math.min(mn * nums[i], nums[i]));
            ans = Math.max(max, ans);
        }
        return ans;
    }
}
