/**
 * 202. Happy Number
 *
 * Write an algorithm to determine if a number n is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Return True if n is a happy number, and False if not.
 *
 * Example:
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */

import java.util.ArrayList;

public class HappyNumber {
    public boolean isHappy(int n) {
        int result = 0;
        ArrayList<Integer> digits = getDigits(n);
        System.out.println("inHappy digits = " + digits);
        result = sumOfSquares (digits);
        System.out.println("result = " + result);

        while (result != 1) {
            digits = getDigits(result);
            result = sumOfSquares(digits);
            System.out.println("result = " + result);
            if (result == 4) {
                return false;
            }
        }

        return true;
    }

    private ArrayList<Integer> getDigits(int n) {
        System.out.println("getDigits(" + n + ")");
        if (n < 10) {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            digits.add(n);
            return digits;
        }
        else {
            ArrayList<Integer> digits = new ArrayList<Integer>();
            digits = getDigits(n/10);
            digits.add(n%10);
            return digits;
        }
    }

    private int sumOfSquares(ArrayList<Integer> digits) {
        int sum = 0;
        for (int digit : digits) {
            sum = sum + (digit * digit);
        }
        return sum;
    }
}
