/**
 * 49. Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *     All inputs will be in lowercase.
 *     The order of your output does not matter.
 */

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> anagrams = new HashMap<String, List>();

        for (String str : strs) {
            // System.out.println("str = " + str);
            char strArray[] = str.toCharArray();
            Arrays.sort(strArray);
            String sorted = new String(strArray);
            // System.out.println("    sorted = " + sorted);

            if (anagrams.containsKey(sorted)) {
                // System.out.println("containsKey ... adding");
                anagrams.get(sorted).add(str);
            }
            else {
                // System.out.println("else ... new List and adding");
                anagrams.put(sorted, new ArrayList<String>());
                anagrams.get(sorted).add(str);
            }
        }

        ArrayList<List<String>> result = new ArrayList<List<String>>();
        for (String key : anagrams.keySet()) {
            // System.out.println("key = " + key);
            // System.out.println("anagrams.get(" + key + ") = " + anagrams.get(key));
            result.add(anagrams.get(key));
        }
        return result;
    }
}