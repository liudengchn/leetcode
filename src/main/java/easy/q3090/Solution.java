package easy.q3090;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description
 * @Author liudeng
 * @Create 2025/6/9 09:55
 **/
public class Solution {
    public int maximumLengthSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String substring = s.substring(i, j + 1);
                int i1 = checkLength(substring);
                if (i1 > max) {
                    max = i1;
                }
            }
        }

        return max;
    }

    public int checkLength(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > 2) {
                return -1;
            }
        }
        return length;
    }
}
