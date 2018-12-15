// https://leetcode.com/problems/maximum-subarray/

package solutions;

import java.util.Arrays;

public class Problem053 {
    /**
     * Get the Max Sum of in the Array
     *
     * @param nums Array of integers
     * @return Sum of the Sub Array
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        int[][] table = new int[len][len];

        for (int col = 0; col < len; col++) {
            for (int row = 0; row < len; row++) {
                if (col > row) continue;
                int lastRow = row - 1 < 0 ? 0 : row - 1;
                int sum = col == row ? nums[row] : nums[row] + table[col][lastRow];
                table[col][row] = sum;
                max = sum > max ? sum : max;
            }
        }
//        System.out.println(Arrays.deepToString(table));
        return max;
    }
}
