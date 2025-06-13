package medium.q1419;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * @Author liudeng
 * @Create 2025/6/11 14:53
 **/
public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int length = croakOfFrogs.length();
        List<ArrayDeque<Character>> queues = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            char c = croakOfFrogs.charAt(i);
            char before = getBefore(c);
            if (c == 'c') {
                if (queues.isEmpty()) {
                    ArrayDeque<Character> newQueue = new ArrayDeque<>();
                    newQueue.add(c);
                    queues.add(newQueue);
                    continue;
                }

                for (int j = 0; j < queues.size(); j++) {
                    ArrayDeque<Character> queue = queues.get(j);
                    Character peek = (Character)queue.peekLast();
                    if (before == peek) {
                        queue.add(c);
                        break;
                    }

                    if (j == queues.size() - 1) {
                        ArrayDeque<Character> newQueue = new ArrayDeque<>();
                        newQueue.add(c);
                        queues.add(newQueue);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < queues.size(); j++) {
                    ArrayDeque<Character> queue = queues.get(j);
                    Character peek = (Character)queue.peekLast();
                    if (before == peek) {
                        queue.add(c);
                        break;
                    }

                    if (j == queues.size() - 1) {
                        return -1;
                    }
                }
            }
        }

        return checkComplete(queues);
    }

    public int checkComplete(List<ArrayDeque<Character>> queues) {
        if (queues == null || queues.size() == 0) {
            return -1;
        }
        for (ArrayDeque<Character> queue : queues) {
            int size = queue.size();
            int i = size % 5;
            if (i != 0) {
                return -1;
            }
        }
        return queues.size();
    }

    public Character getBefore(Character c) {
        if (c == 'r') {
            return 'c';
        } else if (c == 'o') {
            return 'r';
        } else if (c == 'a') {
            return 'o';
        } else if (c == 'k') {
            return 'a';
        } else if (c == 'c') {
            return 'k';
        }
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minNumberOfFrogs("croakcroak"));
    }
}
