package medium.q433;

import java.util.*;

/**
 * @ClassName Solution2
 * @Description
 * @Author liudeng
 * @Create 2025/6/9 16:27
 **/
public class Solution2 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();

        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }
        char[] chars = new char[4];
        chars[0] = 'A';
        chars[1] = 'C';
        chars[2] = 'G';
        chars[3] = 'T';

        if (startGene.equals(endGene)) {
            return 0;
        }

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> deque = new ArrayDeque<>();
        deque.offer(startGene);
        visited.add(startGene);
        int step = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int m = 0; m < size; m++) {
                String poll = deque.poll();
                for (int i = 0; i < startGene.length(); i++) {
                    for (int k = 0; k < chars.length; k++) {
                        char c = poll.charAt(i);

                        if (!(c == chars[k])) {
                            StringBuilder sb = new StringBuilder(poll);
                            sb.setCharAt(i, chars[k]);
                            String stringChange = sb.toString();
                            if (!visited.contains(stringChange) && bankSet.contains(stringChange)) {
                                if (endGene.equals(stringChange)) {
                                    return step;
                                }
                                deque.offer(stringChange);
                                visited.add(stringChange);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
