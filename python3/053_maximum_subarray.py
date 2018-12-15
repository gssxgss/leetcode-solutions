# https://leetcode.com/problems/maximum-subarray/
# Kanade's Algorithm

class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_sofar = max_ending_here = nums[0]
        for i in range(1, len(nums)):
            max_ending_here = max(max_ending_here + nums[i], nums[i])
            max_sofar = max(max_sofar, max_ending_here)
        return max_sofar

