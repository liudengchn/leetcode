package q5;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author liudeng
 * @Create 2022/4/1 11:40 下午
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        System.out.println(longestPalindrome(s));
    }

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLength = 1;
        int startIndex = 0;

        // 1.定义状态方程
        boolean[][] dp = new boolean[length][length];
        // 2.定义初始状态
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();

        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;

                if (j >= length) {
                    break;
                }

                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 定义状态转移方程
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 定义输出
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }

    /**
     * 自己实现
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String[] strings = s.split("");
        int strLength = strings.length;

        if (1 == strLength || 0 == strLength) {
            return s;
        }
        if (2 == strLength) {
            if (strings[0].equals(strings[1])) {
                return s;
            } else {
                return strings[0];
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i <= strLength - 2; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            boolean flag = false;
            for (int j = strLength - 1; j >= i; j--) {
                int m = i;
                int n = j;
                if (m == n) {
                    continue;
                }
                while (strings[m].equals(strings[n])) {
                    m++;
                    n--;
                    if (m >= n) {
                        sb.append("," + j);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (sb.toString().contains(",")) {
                list.add(sb.toString());
            }
        }

        int temp = 0;
        int start = 0;
        int end = 0;
        for (int k = 0; k < list.size(); k++) {
            String ss = list.get(k);
            String[] split = ss.split(",");
            int s1 = Integer.valueOf(split[0]);
            int s2 = Integer.valueOf(split[1]);
            int interval = s2 - s1;
            if (interval > temp) {
                temp = interval;
                start = s1;
                end = s2;
            }
        }
        return s.substring(start, end + 1);
    }
}
