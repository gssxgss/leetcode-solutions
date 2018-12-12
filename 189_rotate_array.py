# https://leetcode.com/problems/rotate-array/description/


class Solution:
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums or not k or len(nums) == 1:
            return
        count = k % len(nums)
        if not count:
            return
        nums[:] = nums[-count:] + nums[:-count]


int_list = [1]
Solution().rotate(int_list, 0)
