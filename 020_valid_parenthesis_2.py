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
        ref = {')': '(', ']': '[', '}': '{'}
        stack_len = len(s) // 2
        stack = [None] * stack_len
        index = 0
        for i in range(len(s)):
            current_char = s[i]
            if current_char in ref:
                if not index:
                    return False
                index -= 1
                last_char = stack[index]
                if not last_char or last_char != ref[current_char]:
                    return False
            else:
                if index > stack_len - 1:
                    return False
                stack[index] = current_char
                index += 1
        return not index
