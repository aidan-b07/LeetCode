package ArraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    /*
    [EASY]

    Given an integer array nums, return true if any value appears more than once in the array,
    otherwise return false

    https://neetcode.io/problems/duplicate-integer

    Time Complexity: O(n)
    Space Complexity: O(n)
     */

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(numSet.contains(nums[i])) return true;
            numSet.add(nums[i]);
        }

        return false;
    }
}
