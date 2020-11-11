package q120;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liudeng
 * @date 2020/11/10 9:08 上午
 * @since
 **/
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> sum = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(-1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(-1);
        list3.add(-1);

        sum.add(list1);
        sum.add(list2);
        sum.add(list3);
        System.out.println(new Solution().minimumTotal(sum));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (0 == length) {
            return 0;
        }

        // 初始化
        int[][] dp = new int[length][length] ;
        int first = triangle.get(0).get(0);
        dp[0][0] = first;

        // 三角形的左边一列赋值
        for (int m = 1; m < length; m++) {
            dp[m][0] = triangle.get(m).get(0) + dp[m -1][0];
        }

        // 三角形的右边一列赋值
        for (int n = 1; n < length; n++) {
            dp[n][n] = triangle.get(n).get(n) + dp[n -1][n - 1];
        }

        // dp方程
        for (int i = 2; i < length; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        // dp方程最后一行的最小值
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            int now = dp[length - 1][i];
            if (now < result) {
                result = now;
            }
        }
        return result;
    }
}
