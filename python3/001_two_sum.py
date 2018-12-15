# https://leetcode.com/problems/two-sum/description/


class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # # ver 1
        # dict_map = {}
        # index = 0
        # while index < len(nums):
        #     num = nums[index]
        #     complement = target - num
        #     if dict_map.get(complement) is None:
        #         dict_map[num] = index
        #     else:
        #         return [dict_map[complement], index]
        #     index += 1

        # ver 2
        dict_map = {}
        for index, num in enumerate(nums):
            if num in dict_map:
                return [dict_map[num], index]
            dict_map[target - num] = index


n = [1, 3, 4]
t = 7

print(Solution().twoSum(n, t))
