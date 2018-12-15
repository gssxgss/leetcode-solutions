# https://leetcode.com/problems/climbing-stairs/
# Hint: https://leetcode.com/problems/climbing-stairs/discuss/25299/Basically-it's-a-fibonacci.


class Solution:

    def __init__(self):
        self.cache = {}

    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 2

        if n in self.cache:
            return self.cache[n]
        else:
            res = self.climbStairs(n - 1) + self.climbStairs(n - 2)
            self.cache[n] = res
            return res
