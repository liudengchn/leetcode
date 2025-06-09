package medium.q1208;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author liudeng
 * @Create 2025/6/6 11:19
 **/
public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int max = 0;
        for (int j = 0; j < length - 1; j++) {
            int realLength = 0;
            int cost = 0;
            int left = length - j;
            if (max > left) {
                break;
            }

            for (int i = j; i < length; i++) {
                cost = calcCost(s, t, maxCost, i, cost);
                if (cost == -1) {
                    if (realLength > max) {
                        max = realLength;
                    }
                    break;
                } else {
                    realLength++;
                    if (length == (i + 1)) {
                        if (realLength > max) {
                            max = realLength;
                        }
                    }
                }
            }
        }
        return max;
    }

    public int calcCost(String s, String t, int maxCost, int i, int cost) {
        int up = s.charAt(i);
        int down = t.charAt(i);

        if (up != down) {
            cost = cost + Math.abs(up - down);
            if (cost > maxCost) {
                cost = -1;
            }
            return cost;
        }
        return cost;
    }

    public static void main(String[] args) {
        String s = "krpgjbjjznpzdfy";
        String t = "nxargkbydxmsgby";

        int i = new Solution().equalSubstring(s, t, 14);
        System.out.println(i);
    }
}
