/**
 * 136. Single Number
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    // Brute Force
    public int singleNumber(int[] nums) {
        System.out.println("nums.length = " + nums.length);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[" + i + "] = " + nums[i]);
            int current = nums[i];
            boolean duplicate = false;
            for (int j = 0; j < nums.length; j++) {

                if (nums[j] == nums[i] && j != i) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate == false) {
                return current;
            }
        }

        return 0;
    }
}
