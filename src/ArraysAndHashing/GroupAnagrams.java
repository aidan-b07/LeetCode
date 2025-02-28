package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    /*
    [MEDIUM]

    Given an array of strings strs, group all anagrams together into sublists.
    You may return the output in any order.

    An anagram is a string that contains the exact same characters as another string,
    but the order of the characters can be different.

    https://neetcode.io/problems/anagram-groups
    */

    /*
    Time Complexity: O(n * m)
    Space Complexity: O(n * m)
        n = strs.length
        m = length of longest string
     */

    public List<List<String>> groupAnagrams(String[] strs) {
        // Stores map of hash by index
        //   Map contains character and strings
        HashMap<HashMap<Character, Integer>, List<String>> a = new HashMap<>();

        for(String s : strs) {
            HashMap<Character, Integer> charMap = new HashMap<>();

            for(char c : s.toCharArray()) {
                int count = charMap.getOrDefault(c, 0);
                charMap.put(c, count + 1);
            }

            List<String> anagrams = a.getOrDefault(charMap, new ArrayList<String>());
            anagrams.add(s);

            a.put(charMap, anagrams);
        }

        return a.values().stream().toList();
    }

    /*
    Time Complexity: O(n * m)
    Space Complexity: O(n)
        n = strs.length
        m = length of longest string
     */

    public List<List<String>> groupAnagrams2(String[] strs) {
        // Stores map of hash by index
        //   Map contains character and strings
        HashMap<String, List<String>> a = new HashMap<>();

        for(String s : strs) {
            int[] charCount = new int[26];

            for(char c : s.toCharArray()) {
                charCount[c - 'a']++;
            }

            String charCountStr = Arrays.toString(charCount);

            List<String> anagrams = a.getOrDefault(charCountStr, new ArrayList<String>());
            anagrams.add(s);

            a.put(charCountStr, anagrams);
        }

        return a.values().stream().toList();
    }
}
