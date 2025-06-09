package medium.q1208;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution3
 * @Description
 * @Author liudeng
 * @Create 2025/6/6 15:35
 **/
public class Solution3 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int costEach = calcCost(s, t, i);
            list.add(costEach);
        }

        int left = 0;
        int right = 0;
        int maxLength = 0;
        int sum = 0;
        while (right <= length) {
            sum += list.get(right);
            while (sum > maxCost) {
                sum -= list.get(left);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public int calcCost(String s, String t, int i) {
        int up = s.charAt(i);
        int down = t.charAt(i);
        return Math.abs(up - down);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";

        int i = new Solution().equalSubstring(s, t, 3);
        System.out.println(i);
    }
}
