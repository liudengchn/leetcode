package q354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liudeng
 * @date 2020/11/19 上午12:14
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int result = 1;

        for (int i = 1; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public int maxEnvelopes(int[][] envelopes) {
        // 根据左边数据对右边的数据排序
        // 左边相同的右边按从大到小排序，左边不相同的按从小到大排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });

        // 拿出右边的所有数据为一个数组
        int[] nums = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }
}
