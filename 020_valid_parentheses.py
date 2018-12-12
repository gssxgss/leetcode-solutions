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
        stack = Stack(len(s))
        for i in range(len(s)):
            current_char = s[i]
            if current_char in ref:
                last_char = stack.pop()
                if not last_char or last_char != ref[current_char]:
                    return False
            else:
                stack.push(current_char)
        return not stack.index


class Stack:
    def __init__(self, size):
        self.s = [None] * size
        self.index = 0

    def push(self, item):
        self.s[self.index] = item
        self.index += 1

    def pop(self):
        if not self.index:
            return None
        self.index -= 1
        return self.s[self.index]


print(Solution().isValid(''))
