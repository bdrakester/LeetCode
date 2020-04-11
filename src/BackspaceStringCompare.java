/**
 * 844. Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 *     1 <= S.length <= 200
 *     1 <= T.length <= 200
 *     S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 *     Can you solve it in O(N) time and O(1) space?
 */

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        // Create S output
        String outputS = processInput(S);
        // System.out.println(outputS);

        // Create T output
        String outputT = processInput(T);
        // System.out.println(outputT);

        // Compare
        return outputS.equals(outputT);
    }

    private String processInput(String input) {
        char[] buffer = new char[input.length()];
        int bufferIndex = 0;
        for (int i = 0; i < input.length(); i++) {
            if (bufferIndex < 0) bufferIndex = 0;
            if (input.charAt(i) != '#') {
                buffer[bufferIndex] = input.charAt(i);
                bufferIndex++;
            }
            else {
                bufferIndex--;
            }
        }
        // System.out.println("bufferIndex = " + bufferIndex);
        String result = new String(buffer);
        // System.out.println(result.substring(0, bufferIndex));
        return result.substring(0, bufferIndex);
    }
}
