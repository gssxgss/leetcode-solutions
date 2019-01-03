package solutions;

public class Problem026 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int replaceIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[replaceIndex] = nums[i];
                replaceIndex++;
            }
        }
        return replaceIndex;
    }
}
