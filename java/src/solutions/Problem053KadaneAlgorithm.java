// https://leetcode.com/problems/maximum-subarray/
// https://en.wikipedia.org/wiki/Maximum_subarray_problem

// Kadane's algorithm

package solutions;

public class Problem053KadaneAlgorithm {
    /**
     * Get the Max Sum of in the Array
     *
     * @param nums Array of integers
     * @return Sum of the Sub Array
     */
    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
