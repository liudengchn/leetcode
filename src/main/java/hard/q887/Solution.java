package hard.q887;

import java.util.Arrays;

/**
 * 完全不懂，抄了抄了。。。
 *
 * @author liudeng
 * @date 2020/11/16 下午8:56
 * @since
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];

        // 给每行赋初值
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], i);
        }

        // 楼层为0，鸡蛋为所谓，全为0
        for (int j = 0; j <= K; j++) {
            dp[0][j] = 0;
        }

        // 楼层为1，鸡蛋为所谓，全为1
        dp[1][0] = 0;
        for (int j = 1; j <= K; j++) {
            dp[1][j] = 1;
        }

        // 鸡蛋为0，所有为0
        // 鸡蛋为1，挨个试，次数为i
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
            dp[i][1] = i;
        }

        // 动态转移方程
        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                // 在区间 [1, i] 里确定一个最优值
                int left = 1;
                int right = i;
                while (left < right) {
                    // 找 dp[k - 1][j - 1] <= dp[i - mid][j] 的最大值 k
                    int mid = left + (right - left + 1) / 2;

                    int breakCount = dp[mid - 1][j - 1];
                    int notBreakCount = dp[i - mid][j];
                    if (breakCount > notBreakCount) {
                        // 排除法（减治思想）写对二分见第 35 题，先想什么时候不是解
                        // 严格大于的时候一定不是解，此时 mid 一定不是解
                        // 下一轮搜索区间是 [left, mid - 1]
                        right = mid - 1;
                    } else {
                        // 这个区间一定是上一个区间的反面，即 [mid, right]
                        // 注意这个时候取中间数要上取整，int mid = left + (right - left + 1) / 2;
                        left = mid;
                    }
                }
                // left 这个下标就是最优的 k 值，把它代入转移方程 Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1) 即可
                dp[i][j] = Math.max(dp[left - 1][j - 1], dp[i - left][j]) + 1;
            }
        }
        return dp[N][K];
    }
}
