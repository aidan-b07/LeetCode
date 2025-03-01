package ArraysAndHashing;

import java.sql.SQLOutput;
import java.util.*;

public class TopKFrequentElements {
    /*
    [MEDIUM]

    Given an integer array nums and an integer k, return the k most frequent elements within
    the array.

    The test cases are generated such that the answer is always unique.

    You may return the output in any order.

    https://neetcode.io/problems/top-k-elements-in-list
     */

    /*
        Time Complexity: O( nlog(u) )
        Space Complexity: O(n + k)
            n = nums.length
            u = unique numbers
            k = k
     */

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> mostFrequent = new ArrayList<>();
        for(int i : count.keySet()) {
            mostFrequent.add(new int[] {count.get(i), i});
        }

        mostFrequent.sort((a, b) -> a[0] - b[0]);

        int[] vals = new int[k];
        for(int i = 0; i < k; i++){
            vals[i] = mostFrequent.get(mostFrequent.size() - i - 1)[1];
        }

        return vals;
    }
}
