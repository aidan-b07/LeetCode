package ArraysAndHashing;

import java.util.HashMap;

public class ValidAnagram {
    /*
    [EASY]

    Given two strings s and t, return true if the two strings are anagrams of each other,
    otherwise return false.

    An anagram is a string that contains the exact same characters as another string, but the
    order of the characters can be different.

    https://neetcode.io/problems/is-anagram

    Time Complexity: O(n + m)
    Space Complexity: O(u)
        m = s.length()
        n = t.length()
        u = number of unique characters in s & t
     */

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> charCount = new HashMap<>();

        for(char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for(char c : t.toCharArray()) {
            if(!charCount.containsKey(c)) return false;

            int count = charCount.get(c) - 1;

            if(count < 0) return false;

            charCount.replace(c, count);
        }

        return true;
    }
}
