# https://leetcode.com/problems/merge-two-sorted-lists/

# Definition for singly-linked list.


class LinkedList:
    def __init__(self, l):
        self.len: int = len(l)
        self.list: list = [None] * self.len
        for index, item in enumerate(l[::-1]):
            real_index: int = self.len - 1 - index
            if index:
                node: ListNode = ListNode(item)
                node.next: ListNode = self.list[real_index + 1]
                self.list[real_index] = node
            else:
                self.list[real_index] = ListNode(item)
    @property
    def first(self):
        return self.list[0]


class ListNode:
    def __init__(self, x):
        self.val: int = x
        self.next: ListNode = None


class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if not l1 and not l2:
            return l1
        if not l1:
            return l2
        if not l2:
            return l1

        head = None
        current = None

        while l1 and l2:
            if l1.val <= l2.val:
                if not head:
                    head = l1
                    current = l1
                else:
                    current.next = l1
                    current = current.next
                l1 = l1.next
            else:
                if not head:
                    head = l2
                    current = l2
                else:
                    current.next = l2
                    current = current.next
                l2 = l2.next
        if l1:
            current.next = l1
        else:
            current.next = l2

        return head


lnl1 = LinkedList([1, 2, 4])
lnl2 = LinkedList([1, 3, 4])

print(Solution().mergeTwoLists(lnl1.first, lnl2.first))
