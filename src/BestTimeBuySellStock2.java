/**
 * 122. Best Time to Buy and Sell Stock II
 *
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 *     1 <= prices.length <= 3 * 10 ^ 4
 *     0 <= prices[i] <= 10 ^ 4
 */
public class BestTimeBuySellStock2 {
    public int maxProfit(int[] prices) {
        int max = 0;

        /* Playing with min and max
        int minIndex = minIndex(prices, 0, prices.length - 1);
        System.out.println("minIndex = " + minIndex);
        int maxIndex = maxIndex(prices, minIndex, prices.length - 1);
        System.out.println("maxIndex = " + maxIndex);
        max = prices[maxIndex] - prices[minIndex];
        */

        int index = 0;
        while (index < prices.length - 1) {
            System.out.println("Loop - index = " + index);
            System.out.println("    calling nextBottom - start = " + index + " end = " + prices.length);
            int bottom = nextBottom(prices, index, prices.length);
            System.out.println("    bottom: prices[" + bottom + "] = " + prices[bottom]);
            System.out.println("    calling nextPeak - start = " + bottom + " end = " + prices.length);
            int peak = nextPeak(prices, bottom, prices.length);
            System.out.println("    peak:   prices[" + peak + "] = " + prices[peak]);
            max = max + (prices[peak] - prices[bottom]);
            System.out.println("    max = " + max);
            index = peak + 1;
        }

        return max;
    }

    /**
     * Return index of the next bottom integer in input array between
     * indices start (inclusice) and end (exclusive).
     * @param input the array
     * @param start
     * @param end
     */
    private int nextBottom(int[] input, int start, int end) {
        int bottom = start;
        int index = start + 1;
        while (bottom < end - 1 && input[index] < input[bottom]) {
            bottom = index;
            index++;
        }
        return bottom;
    }

    /**
     * Return index of the next peak integer in input array between
     * indices start (inclusice) and end (exclusive).
     * @param input the array
     * @param start
     * @param end
     */
    private int nextPeak(int[] input, int start, int end) {
        int peak = start;
        int index = start + 1;
        while (peak < end - 1 && input[index] > input[peak]) {
            peak = index;
            index++;
        }
        return peak;
    }


    /**
     * Return index of minimum integer in input array between
     * indices start and end (inclusive)
     * @param input the array
     * @param start index to start searching from
     * @param end index to last element to search
     */
    private int minIndex(int[] input, int start, int end) {
        int min = start;
        for (int i = start+1; i <= end; i++) {
            if (input[i] < input[min]) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Return index of max integer in input array between
     * indices start and end (inclusive)
     * @param input the array
     * @param start index to start searching from
     * @param end index to last element to search
     */
    private int maxIndex(int[] input, int start, int end) {
        int max = start;
        for (int i = start+1; i <= end; i++) {
            if (input[i] > input[max]) {
                max = i;
            }
        }
        return max;
    }
}
