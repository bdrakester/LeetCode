/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * If there're duplicates in arr, count them seperately.
 *
 * Example 1:
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 * Constraints:
 *     1 <= arr.length <= 1000
 *     0 <= arr[i] <= 1000
 */

import java.util.HashMap;

class CountingElements {
    public int countElements(int[] arr) {
        HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
        int result = 0;

        // Store elements in HashMap 
        for (int n : arr) {
            if ( !(elements.containsKey(n)) ) {
                elements.put(n,1);
            }
            else {
                int value = elements.get(n);
                elements.put(n, value+1);
            }
        }

        // DEBUG
        //System.out.println("After storing all elements:");
        //for (int key : elements.keySet()) {
        //    System.out.println("    elements[ " + key + " ] = " + elements.get(key));
        //}

        // Count valid elements
        for (int n : arr) {
            if ( elements.containsKey(n+1) ) {
                result++;
            }
        }
        return result;
    }
}