package medium.q1419;

import java.util.*;

/**
 * @ClassName Solution2
 * @Description
 * @Author liudeng
 * @Create 2025/6/11 20:26
 **/
public class Solution2 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        if (length % 5 != 0) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);

        char[] cnt = new char[4];
        int res = 0;
        Integer frog = 0;
        for (int i = 0; i < length; i++) {
            char c = croakOfFrogs.charAt(i);
            Integer now = map.get(c);

            if (now == 0) {
                frog++;
                cnt[0]++;
                if (frog > res) {
                    res = frog;
                }
            } else {
                if (cnt[now -1] == 0) {
                    return -1;
                }
                cnt[now - 1]--;
                if (4 == now) {
                    frog--;
                } else {
                    cnt[now]++;
                }
            }
        }
        if (frog > 0) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);

        String[] croakOfFrogs = {"c", "r", "o", "a"};
        System.out.println(croakOfFrogs);
    }
}
