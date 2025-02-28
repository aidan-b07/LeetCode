package ArraysAndHashing;

import java.util.HashMap;

public class TwoSum {
    /*
    [EASY]

    Given an array of integers nums and an integer target, return the indices i and j
    such that nums[i] + nums[j] == target and i != j.

    You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

    Return the answer with the smaller index first.

    https://neetcode.io/problems/two-integer-sum

    Time Complexity: O(n)
    Space Complexity: O(n)
        n = nums.length
     */


    public int[] twoSum(int[] nums, int target) {
        // Stores target - nums[i] by index
        HashMap<Integer, Integer> remainders = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if(remainders.containsKey(val)) return new int[] {remainders.get(val), i};
            else remainders.put(target - val, i);
        }

        return null;
    }
}
