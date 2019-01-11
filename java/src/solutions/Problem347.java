/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

package solutions;

import java.util.*;

public class Problem347 {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num: nums) {
            if (countMap.containsKey(num))  {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        Map<Integer, ArrayList<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            ArrayList<Integer> keys;
            if (sortedMap.containsKey(value)) {
                keys = sortedMap.get(value);
            } else {
                keys = new ArrayList<>();
            }
            keys.add(key);
            sortedMap.put(value, keys);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry:sortedMap.entrySet()) {
            if (k < 1) break;
            ArrayList<Integer> entryValues = entry.getValue();
            int length = entryValues.size();
            if (length <= k) {
                result.addAll(entryValues);
                k -= length;
            } else {
                result.addAll(entryValues.subList(0, k));
                k = 0;
            }
        }
        return result;
    }
}
