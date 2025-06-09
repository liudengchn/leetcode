package medium.q1208;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution2
 * @Description
 * @Author liudeng
 * @Create 2025/6/6 15:17
 **/
public class Solution2 {
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

        int max = 0;
        for (int i = 0; i < length; i++) {
            int num = 0;
            int cost = list.get(i);
            int j = i + 1;
            while (cost < maxCost) {
                num++;

                if (j < length - 1) {
                    cost = cost + list.get(j);
                    j++;
                }
            }

            if (num > max) {
                max = num;
            }
        }

        return max;
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
