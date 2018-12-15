# https://leetcode.com/problems/binary-gap/description/


class Solution:
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        is_start = False
        cur_count = 1
        max_count = 0

        while N > 0:
            if N % 2:
                if not is_start:
                    is_start = True
                    cur_count = 1
                else:
                    max_count = max(cur_count, max_count)
                    cur_count = 1
            else:
                cur_count += 1
            N = N // 2

        return max_count


print(Solution().binaryGap(1041))
