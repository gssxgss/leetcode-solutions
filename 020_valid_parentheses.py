# https://leetcode.com/problems/valid-parentheses/description/
# True: (), [()], ()[]{}
# False: )[, ((, (]
# First in Last out?


class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        if not s:
            return True
        if len(s) % 2:
            return False
        ref = {')': '(', ']': '[', '}': '{'}
        stack = ''
        for i in range(len(s)):
            symbol = s[i]
            if symbol in ref:
                if not stack or stack[-1] != ref[symbol]:
                    return False
                else:
                    stack = stack[:-1]
            else:
                stack += s[i]
        return not stack


print(Solution().isValid('(('))
