/**
 * 53. Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++){
                //System.out.println("nums[" + i + "] - nums[" + j + "]");
                sum = sum + nums[j];
                //System.out.println("    sum = " + sum);
                if (sum > max) {
                    max = sum;
                }
                //System.out.println("    max = " + max);
            }
        }

        return max;
    }
}