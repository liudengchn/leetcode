package medium.q433;

import java.util.*;

/**
 * @ClassName Solution
 * @Description 错误的解答
 * @Author liudeng
 * @Create 2025/6/9 15:05
 **/
public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        List<String> all = new ArrayList<>();
        all.add(startGene);
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < startGene.length(); i++) {
            list.clear();
            for (String s : all) {
                changeOne(s, i, map);

                Set<String> set = map.keySet();
                list.addAll(set);
            }
            all.clear();
            if (list.contains(endGene)) {
                return map.get(endGene);
            }
            all.addAll(list);
        }
        return -1;
    }

    public List<String> keepExsit(List<String> list, String[] bank, String startGene) {
        List<String> res = new ArrayList<>();
        for (String s : bank) {
            if (list.contains(s)) {
                res.add(s);
            }
        }
        if (!list.contains(startGene)) {
            res.add(startGene);
        }
        return res;
    }

    public Map<String, Integer> changeOne(String origin, int index, Map<String, Integer> map) {
        changeOneMap(origin, index, 'A', map);
        changeOneMap(origin, index, 'C', map);
        changeOneMap(origin, index, 'G', map);
        changeOneMap(origin, index, 'T', map);
        return map;
    }

    public Map<String, Integer> changeOneMap(String origin, int index, char ch,Map<String, Integer> map) {
        StringBuilder sbA = new StringBuilder(origin);
        char c = origin.charAt(index);
        if (c == ch) {

        } else {
            sbA.setCharAt(index, ch);
            String strA = sbA.toString();
            map.put(strA, map.getOrDefault(strA, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(solution.minMutation(startGene, endGene, bank));
    }
}
